package 队列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    class Freq  implements Comparable<Freq> {
        int e,fre;
        @Override
        public int compareTo(Freq o) {
            if (this.fre<o.fre) return 1;
            if (this.fre>o.fre) return -1;
            return 0;
        }

        public Freq(int e, int fre) {
            this.e = e;
            this.fre = fre;
        }
    }

    public List<Integer> topKFrequent(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        PriorityQueue<Freq> pq = new PriorityQueue<Freq>();
        for (int key:map.keySet()){
            if (pq.getSize()<k){
                pq.enqueue(new Freq(key,map.get(key)));
            }
            else if (map.get(key)>pq.getFront().fre){
                pq.dequeue();
                pq.enqueue(new Freq(key,map.get(key)) );
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int f=0;f<k;f++){
            res.add(pq.dequeue().e);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,1,3,5,5,5,5,5,4,4,2,2};
        List<Integer> list = new Solution().topKFrequent(a, 3);
        for (int i=list.size()-1;i>=0;i--)
            System.out.println(list.get(i));
    }
}
