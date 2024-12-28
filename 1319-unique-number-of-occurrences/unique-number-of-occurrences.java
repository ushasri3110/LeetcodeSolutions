class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:arr){
            map.put(i,map.getOrDefault(i,1)+1);
        }
        List<Integer> list=new ArrayList<>();
        for (int i:map.values()){
            if (list.contains(i)){
                return false;
            }
            list.add(i);
        }
        return true;
    }
}