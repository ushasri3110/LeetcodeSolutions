class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> productMap=new HashMap<>();
        int res=0;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                int product=nums[i]*nums[j];
                productMap.put(product,productMap.getOrDefault(product,0)+1);
            }
        }
        for (int product:productMap.keySet()){
            int freq=productMap.get(product);
            int numPairs=((freq-1)*freq)/2;
            res+=numPairs*8;
        }
        return res;
    }
}