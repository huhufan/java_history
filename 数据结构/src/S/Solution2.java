package S;


import java.util.*;

public class Solution2 {
    private  class Freq  {
        int e,fre;

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
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        for (int key:map.keySet()){
            if (pq.size()<k){
                pq.add(key);
            }
            else if (map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int f=0;f<k;f++){
            res.add(pq.remove());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,1,3,5,5,5,5,5,4,4,2,2};
        List<Integer> list = new Solution2().topKFrequent(a, 3);
        for (int i=list.size()-1;i>=0;i--)
            System.out.println(list.get(i));
    }
}
