class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int global_min=arrays.get(0).get(0);
        int global_max=arrays.get(0).get(arrays.get(0).size()-1);
        int max_distance=0;
        for (int i=1;i<arrays.size();i++){
            int current_min=arrays.get(i).get(0);
            int current_max=arrays.get(i).get(arrays.get(i).size()-1);
            int current_distance=Math.max(Math.abs(global_max-current_min),Math.abs(current_max-global_min));
            max_distance=Math.max(max_distance,current_distance);
            global_min=Math.min(global_min,current_min);
            global_max=Math.max(global_max,current_max);
        }
        return max_distance;
    }
}