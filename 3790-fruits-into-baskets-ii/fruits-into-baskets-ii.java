class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int placed=0;
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<baskets.length;i++){
            list.add(i,baskets[i]);
        }
        for (int i:fruits){
            for (int j=0;j<list.size();j++){
                if (list.get(j)>=i){
                    placed++;
                    list.remove(j);
                    break;
                }
            }
        }
        return baskets.length-placed;
    }
}