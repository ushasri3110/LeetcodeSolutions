class Solution {
    public int findLucky(int[] arr) {
        int ans=-1;
        Map<Integer,Integer> freq=new HashMap<>();
        for (int i:arr){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        for (int i:freq.keySet()){
            if (freq.get(i)==i && i>ans) ans=i;
        }
        return ans;
    }
}