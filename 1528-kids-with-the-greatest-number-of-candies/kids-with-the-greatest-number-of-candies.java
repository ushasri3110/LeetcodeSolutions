class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max_value=Integer.MIN_VALUE;
        for (int i=0;i<candies.length;i++){
            max_value=Math.max(max_value,candies[i]);
        }
        ArrayList<Boolean> result=new ArrayList<>();
        for (int i=0;i<candies.length;i++){
            if (candies[i]+extraCandies>=max_value){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }
}