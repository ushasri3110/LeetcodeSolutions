class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets=new List[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int i:map.keySet()){
            int freq=map.get(i);
            if (buckets[freq]==null){
                buckets[freq]=new ArrayList<>();
            }
            buckets[freq].add(i);
        }
        int[] res=new int[k];
        int count=0;
        for (int i=buckets.length-1;i>=0 && count<k;i--){
            if (buckets[i]!=null){
                for (Integer num:buckets[i]){
                    res[count++]=num;
                }
            }
        }
        return res;
    }
}