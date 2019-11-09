package io_test_8_2;


import java.io.*;

public class Tes4 {

    public static void main(String[] args) {
        BufferedReader bread = null;
        BufferedWriter bwrite = null;
        try {
            File resFile = new File("src\\io_test_8_2\\hello.txt");
            File desFile = new File("src\\io_test_8_2\\hello3.txt");

            bread = new BufferedReader(new FileReader(resFile));
            bwrite = new BufferedWriter(new FileWriter(desFile));
            //换一种方式，按行读取
            String data;
            while ((data = bread.readLine()) != null) {
                bwrite.write(data);//这样会去掉换行符的，如果正常格式可以bwrite.write(data+"\n")
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bread != null) {
                try {
                    bread.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bwrite != null) {
                        try {
                            bwrite.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
