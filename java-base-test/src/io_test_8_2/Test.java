package io_test_8_2;


import java.io.*;

public class Test {

    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file = new File("src\\io_test_8_2\\hello.txt");//被赋值的源文件，该文件必须存在

            fr = new FileReader(file);
            fw = new FileWriter("src\\io_test_8_2\\hello2.txt");//写入到此文件中，此文件可以不存在；该方法还有一个append参数传入false代表覆盖原文件，true代表在原文件后面追加

            char[] cbuf = new char[5];                                      //字符的一个缓冲数组
            int len;
            while ((len = fr.read(cbuf)) != -1) {                            //一次最多可以读缓冲数组容量的字符，返回值len代表这一次读入了几个字符，如果什么也没有读到，返回-1
                fw.write(cbuf, 0, len);                                  // 将缓冲数组的内容通过FileWriter写入到新文件中
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {                                                         //相应的流必须手动关闭，因为不在垃圾回收的范围之内。
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fw != null) {
                        try {
                            fw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
