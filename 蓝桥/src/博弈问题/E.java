package 博弈问题;

/**
 * 凑字符串输赢问题
 */
public class E {
    static int f(char[] x){
        String s = new String((x));
        if (s.contains("LOL")) return -1;
        if (!s.contains("*")) return 0;


        boolean ping = false;
        for (int i = 0; i < x.length; i++) {
            if (x[i] == '*') {
                try {
                    x[i] = 'L';
                    switch (f(x)){
                        case -1:return 1;
                        case 0:ping = true;
                    }
                    x[i] = 'O';
                    switch (f(x)){
                        case -1:return 1;
                        case 0:ping = true;
                    }
                }
                finally {
                    x[i] = '*';
                }
            }
        }
        if (ping) return 0;
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(f("***".toCharArray()));
        System.out.println(f("L**L".toCharArray()));
        System.out.println(f("L**L".toCharArray()));
        System.out.println(f("***".toCharArray()));

    }

}
