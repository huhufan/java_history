package S;


import java.util.*;

public class Solution1 {
    private  class Freq  {
        int e,fre;

        public Freq(int e, int fre) {
            this.e = e;
            this.fre = fre;
        }
    }
    private class FreqComparator implements Comparator<Freq>{
        @Override
        public int compare(Freq o1, Freq o2) {
            return o1.fre-o2.fre;
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
        PriorityQueue<Freq> pq = new PriorityQueue<Freq>(new FreqComparator());
        for (int key:map.keySet()){
            if (pq.size()<k){
                pq.add(new Freq(key,map.get(key)));
            }
            else if (map.get(key)>pq.peek().fre){
                pq.remove();
                pq.add(new Freq(key,map.get(key)) );
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int f=0;f<k;f++){
            res.add(pq.remove().e);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,1,3,5,5,5,5,5,4,4,2,2};
        List<Integer> list = new Solution1().topKFrequent(a, 3);
        for (int i=list.size()-1;i>=0;i--)
            System.out.println(list.get(i));
    }
}
