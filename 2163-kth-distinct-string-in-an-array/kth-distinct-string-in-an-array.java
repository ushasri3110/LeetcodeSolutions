class Solution {
    public String kthDistinct(String[] arr, int k) {
        int a=0;
        HashMap<String,Integer> map=new HashMap<>();
        for (String i:arr){
           map.put(i,map.getOrDefault(i,0)+1);
        }
        for (String j:arr){
            if (map.get(j)==1){
                k--;
            }
            if (k==0){
                return j;
            }
        }
        return "";
    }
}