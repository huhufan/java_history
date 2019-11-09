package io_test_8_2;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.io.*;

public class Test5 {
    public static void main(String[] args) {

        InputStreamReader inReader = null;
        OutputStreamWriter outWriter = null;

        try {
            File recFile = new File("src\\io_test_8_2\\a.txt");
            File desFile = new File("src\\io_test_8_2\\aa.txt");

            inReader = new InputStreamReader(new FileInputStream(recFile), "utf-8");
            outWriter = new OutputStreamWriter(new FileOutputStream(desFile), "utf-8");

            char[] chars = new char[20];
            int len;
            while ((len = inReader.read(chars)) != -1) {
                outWriter.write(chars, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inReader != null) {
                try {
                    inReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (outWriter != null) {
                        try {
                            outWriter.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
