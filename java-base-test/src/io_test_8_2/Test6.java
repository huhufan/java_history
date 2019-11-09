package io_test_8_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {
    public static void main(String[] args) {

        InputStreamReader inputStreamReader = null;
        BufferedReader bw = null;

        try {
            inputStreamReader = new InputStreamReader(System.in);
            bw = new BufferedReader(inputStreamReader);

            String data;
            while (true) {
                System.out.println("请输入内容");
                data = bw.readLine();
                if ("exit".equalsIgnoreCase(data)) {
                    System.out.println("程序已退出");
                    break;
                }
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
