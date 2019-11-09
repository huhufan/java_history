package 算法练习;

public class H {

    public static void main(String[] args) {
        int a[] ={1,2,3};
        int b[] = {3,2,3,4,5};
        boolean flag = true;

        int c = Math.min(a[0],Math.min(a[1],a[2]));

        for (int i = 0; i < 1; i++) {
            int e=0,f=0;
            for (int j=0;j<b[i]/c+1;j++){
                for (int d=0;d<a.length;d++){
                    if (b[j] == 0) {

                    }
                    if (b[j]>=a[d]){
                        System.out.println(a[d]);
                        b[j]=b[j]-a[d];
                        if (flag){
                            e+=a[d];
                        }
                        if (!flag) {
                            f+=a[d];
                        }
                    }
                    else{
                        continue;
                    }
                    System.out.println(e+"--"+f);
                }
            }
        }
    }
}
