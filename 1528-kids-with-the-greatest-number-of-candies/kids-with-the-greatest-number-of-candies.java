class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies=0;
        for(int i:candies){
            if (i>maxCandies){
                maxCandies=i;
            }
        }
        List<Boolean> res=new ArrayList<>();
        for(int i:candies){
            if (i+extraCandies>=maxCandies){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;
    }
}