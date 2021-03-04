package com.demo06;

import java.io.*;
import java.util.*;

public class TestHuffmanCode {
    public static void main(String[] args){
//        String msg="can you can a can as a can canner can a can.";
//        byte[] bytes=msg.getBytes();
//        //进行赫夫曼编码
//        byte[] b=huffmanZip(bytes);
//        //进行解码
//        byte[] newBytes=decode(huffCodes,b);
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(Arrays.toString(newBytes));
//        System.out.println(new String(newBytes));
        String src="1.bmp";
        String dst="2.zip";
//        try {
//            zipFile(src,dst);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            unZip("2.zip","3.bmp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件解压
     * @param src
     * @param dst
     */
    public static void unZip(String src,String dst) throws Exception{
        //创建一个输入流
        InputStream is=new FileInputStream(src);
        //读取文件数据
        //读取byte数组
        ObjectInputStream ois=new ObjectInputStream(is);
        byte[] b =(byte[]) ois.readObject();
        //读取赫夫曼编码表
        Map<Byte,String> codes=(Map<Byte,String>)ois.readObject();
        ois.close();
        is.close();
        //解码
        byte[] newBytes=decode(codes,b);
        //创建一个输出流
        OutputStream os=new FileOutputStream(dst);
        //写出数据
        os.write(newBytes);
        os.close();
        
    }
    
    
    /**
     * 文件压缩
     * @param src 目标文件输入地址
     * @param dst 压缩输出地址
     */
    public static void zipFile(String src,String dst) throws IOException {
        //创建一个输入流
        InputStream is=new FileInputStream(src);
        //创建一个和输入流指向的文件大小一样的byte数组
        byte[] b=new byte[is.available()];
        //读取文件内容
        is.read(b);
        is.close();
        //使用赫夫曼编码进行压缩
        byte[] byteZip=huffmanZip(b);
        //输出流
        OutputStream os=new FileOutputStream(dst);
        ObjectOutputStream oos=new ObjectOutputStream(os);
        oos.writeObject(byteZip);
        //存入赫夫曼编码表 便于解码
        oos.writeObject(huffCodes);
        oos.close();
        os.close();
    }
    
    
    /**
     * 使用指定的赫夫曼编码表进行解码
     * @param huffCodes
     * @param bytes
     * @return
     */
    private static byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
        //将byte数组转换为一个二进制字符串
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<bytes.length;i++) {
            byte b=bytes[i];
            //是否是最后一个 是最后一个不补
            boolean flag=(i==bytes.length-1);
            sb.append(byteToBitStr(!flag,b));
        }
        //将字符串按照指定的赫夫曼编码进行编码
        //把赫夫曼编码的键值对调换
        Map<String,Byte> map=new HashMap<>();
        for (Map.Entry<Byte,String> entry:huffCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        //创建一个集合，用于存byte
        List<Byte> list=new ArrayList<>();
        //处理字符串
        for (int i=0;i<sb.length();){
            int count=1;
            boolean flag=true;
            Byte b=null;
            //截取出一个byte
            while (flag){
                String key=sb.substring(i,i+count);
                b=map.get(key);
                if (b==null){
                    count++;
                }else {
                    flag=false;
                }
            }
            list.add(b);
            i+=count;
        }
        //把集合转为数组
        byte[] b=new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i]=list.get(i);
        }
        return b;
    }

    //将byte转换为8位字符串表示
    private static String byteToBitStr(boolean flag,byte b){
        int temp=b;
        //判断是否需要补
        if (flag){
            temp|=256;//按位或实现 整数->8位
        }
        String str=Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }
    /**
     * 进行赫夫曼编码压缩的方法
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //先统计每一个byte出现的次数,并放入一个集合中
        List<Node> nodes=getNodes(bytes);
        //创建一颗赫夫曼树
        Node tree=createHuffmanTree(nodes);
        //创建一个赫夫曼编码表
        Map<Byte,String> huffCodes=getCodes(tree);
        //System.out.println(huffCodes);
        //编码
        byte[] b=zip(bytes,huffCodes);
        return b;
    }

    /**
     * 进行赫夫曼编码
     * @param bytes
     * @param huffCodes
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb=new StringBuilder();
        //把需要压缩的数组转换为赫夫曼编码格式二进制字符串
        for (byte b : bytes) {
            sb.append(huffCodes.get(b));
        }
        //System.out.println(sb);
        //定义字符数组长度
        int len=0;
        if (sb.length()/8==0){
            len=sb.length()/8;
        }else {
            len=sb.length()/8+1;
        }
        byte[] by=new byte[len];
        int index=0;//记录新的by位置
        for (int i = 0; i < sb.length(); i+=8) {
            String strByte;
            if (i+8>sb.length()){
                 strByte=sb.substring(i);
            }else {
                 strByte=sb.substring(i,i+8);
            }
            //把字符串转为数字
            byte byt=(byte)Integer.parseInt(strByte,2);
            by[index]=byt;
            index++;
        }
        return by;
    }

    //用于临时存储路径
    static StringBuilder sb=new StringBuilder();
    //用于存储赫夫曼编码
    static Map<Byte,String> huffCodes=new HashMap<>();
    /**
     * 根据赫夫曼树创建赫夫曼编码表
     * @param tree
     * @return
     */
    private static Map<Byte, String> getCodes(Node tree) {
        if (tree==null){
            return null;
        }
        getCodes(tree.left,"0",sb);
        getCodes(tree.right,"1",sb);
        return huffCodes;
    }

    /**
     * 递归调用获取左右节点树的编码
     * @param node
     * @param code  路径编码 0左 1右
     * @param sb
     */
    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2=new StringBuilder(sb);
        sb2.append(code);
        if (node.data==null){
            //如何该节点值为空 则继续遍历该节点左右节点树
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb2);
        }else {
            //不为空则存入 哈夫曼编码map
            huffCodes.put(node.data,sb2.toString());
        }
    }


    /**
     * 创建赫夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);
            //取出两个权值最低的二叉树
            Node left=nodes.get(0);
            Node right=nodes.get(1);
            //创建一颗新的二叉树
            Node parent=new Node(null,left.weight+right.weight);
            //把之前取出来的二叉树设置为新创建的二叉树的子树
            parent.left=left;
            parent.right=right;
            //从list中移除取出来的权值最低的两个二叉树
            nodes.remove(left);
            nodes.remove(right);
            //把新创建的二叉树放入集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 把byte数组转为node集合
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes=new ArrayList<>();
        Map<Byte,Integer> map=new HashMap<>();
        //统计每一个byte出现的次数
        for (byte b : bytes) {
            Integer count=map.get(b);
            if (count==null){
                map.put(b,1);
            }else {
                map.put(b,count+1);
            }
        }
        for (Map.Entry<Byte,Integer> entry:map.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
}
