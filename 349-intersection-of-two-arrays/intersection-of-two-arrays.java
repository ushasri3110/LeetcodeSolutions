class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        List<Integer> res=new ArrayList<>();
        for (int i:nums1){
            set.add(i);
        }
        for (int i:nums2){
            if (set.contains(i) && !res.contains(i)) res.add(i);
        }
        int[] arr=new int[res.size()];
        int j=0;
        for (int i:res) arr[j++]=i;
        return arr;
    }
}