package 算法练习;

import java.util.Scanner;

/**
 * @author leibaobao
 * 取球博弈
 */
public class G {
    public static int [] n = new int[3];
    public static int [] init = new int[5];
    public static int [] end = new int[1000];
    public static char [] sign = {'-','0','0','+'};
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 3; i++){
            n[i] = scan.nextInt();
        }
        int Min = Math.min(n[0], Math.min(n[1], n[2]));
        for(int i = 0; i < 5; i++){
            init[i] = scan.nextInt();
        }
        for(int i = 0; i < Min; i++){
            end[i] = 2;
        }
        for(int i = Min; i < end.length; i++){
            int temp = 0;
            for(int j =0; j < 3; j++){
                if(i - n[j] < 0)
                    continue;
                else if(end[i-n[j]] == 3){
                    if(n[j]%2 != 0)
                        temp = 1 > temp ? 1 : temp;
                }
                else if(end[i-n[j]] == 0){
                    if(n[j]%2 == 0)
                        temp = 3;
                    else
                        temp = 2 > temp ? 2 : temp;
                }
                else if(end[i-n[j]] == 2){
                    if(n[j]%2==0)
                        temp = 2 > temp ? 2 : temp;
                    else
                        temp = 3;
                }
                else if(end[i-n[j]] == 1){
                    if(n[j]%2==0)
                        temp = 1 > temp ? 1 : temp;
                }
            }
            end[i] = temp;
        }
        for(int i = 0; i < 5; i++){
            System.out.print(sign[end[init[i]]]+" ");
        }
    }

}
