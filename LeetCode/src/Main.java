import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[1000];
        int index = 0;
        while (sc.hasNextInt()){
            data[index]= sc.nextInt();
            index++;
        }
        HashMap<Integer, List<String>> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i <index-1 ; i++) {
            if (data[i]<data[i+1]){
                continue;
            }
            else if (i-start+1>=max){
                max = i-start+1;
                String ss = null;
                for (int s = start; s <=i ; s++) {
                    ss = new String(data[s]+" ");
                }
                if (map.containsKey(i-start+1)){
                    map.get(i-start+1).add(ss.trim());
                }else
                    map.put(i-start+1, Arrays.asList(ss));
                start = index+1;
            }
        }

        List<String> strings = map.get(max);
        for (String e:strings)
            System.out.println(e);
    }
}