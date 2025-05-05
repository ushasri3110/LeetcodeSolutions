class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] arr=new int[101];
        for (int i:nums){
            arr[i]++;
        }
        int goodPairs=0;
        for (int count:arr){
            goodPairs+=(count*(count-1))/2;
        }
        return goodPairs;
    }
}