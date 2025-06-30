class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans=new int[spells.length];
        Arrays.sort(potions);
        for (int i=0;i<spells.length;i++){
            int current=spells[i],low=0,high=potions.length-1,index=-1;
            while (low<=high){
                int mid=low+(high-low)/2;
                long product= (long) current*potions[mid];
                if (product>=success) {
                    index=mid;
                    high=mid-1;
                }
                else low=mid+1;
            }
            ans[i]=index>=0?potions.length-index:0;
        }
        return ans;
    }
}