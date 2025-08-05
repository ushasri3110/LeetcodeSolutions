class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count=0;
        for (int i:fruits){
            int unplaced=1;
            for (int j=0;j<baskets.length;j++){
                if (i<=baskets[j]){
                    baskets[j]=0;
                    unplaced=0;
                    break;
                }
            }
            count+=unplaced;
        }
        return count;
    }
}