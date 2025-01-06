class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int res[]=new int[n];
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<n;i++){
            if (boxes.charAt(i)=='1'){
                set.add(i);
            }
        }
        for (int i=0;i<n;i++){
            int count=0;
            for(int j:set){
                count+=Math.abs(i-j);
            }
            res[i]=count;
        }
        return res;
    }
}