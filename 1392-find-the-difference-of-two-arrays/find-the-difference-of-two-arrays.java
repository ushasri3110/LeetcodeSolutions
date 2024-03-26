class Solution {
    public List<Integer> getElementsOnlyInFirstList(int[] nums1,int[] nums2){
        Set<Integer> onlyInNums1=new HashSet<>();
        Set<Integer> existsInNums2=new HashSet<>();
        for (int i:nums2){
            existsInNums2.add(i);
        }
        for (int j:nums1){
            if (!existsInNums2.contains(j)){
                onlyInNums1.add(j);
            }
        }
        return new ArrayList<>(onlyInNums1);

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getElementsOnlyInFirstList(nums1,nums2),getElementsOnlyInFirstList(nums2,nums1));
    }
}