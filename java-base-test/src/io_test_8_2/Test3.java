package io_test_8_2;

import java.io.*;

public class Test3 {
    public static void main(String[] args) {

        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;

        try {
            File recFile = new File("src\\io_test_8_2\\1.jpeg");
            File desFile = new File("src\\io_test_8_2\\3.jpeg");

            bin = new BufferedInputStream(new FileInputStream(recFile));
            bout = new BufferedOutputStream(new FileOutputStream(desFile));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bin.read(bytes)) != -1) {
                bout.write(bytes, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bin != null) {
                try {
                    bin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bout != null) {
                        try {
                            bout.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
