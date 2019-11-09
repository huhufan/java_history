package 图;

public class Test4 {
    static int sum(int[] a,int start,int end){
        int sum = 0;
        for (int i=start;i<=end;i++){
            sum+=a[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] a = new int[49];
         for(int i= 0;i<a.length;i++){
            a[i]=i+1;
        }
        for (int j=0;j<a.length-3;j++){
            int left = sum(a,0,j-1);
            int mul1 = a[j]*a[j+1];
            for (int k=j+2;k<a.length-1;k++){
                int cent = sum(a,j+2,k-1);
                int mul2 = a[k]*a[k+1];
                int right = sum(a,k+2,a.length-1);
                if (left+mul1+cent+mul2+right==2015)
                    System.out.println((j+1)+","+(k+1));
            }


        }

    }
}
