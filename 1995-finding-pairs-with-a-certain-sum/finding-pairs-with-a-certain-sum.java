class FindSumPairs {
    Map<Integer,Integer> freq=new HashMap<>();
    int[] nums1;
    int[] nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        this.freq=new HashMap<>();
        for (int i:nums2){
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int old=nums2[index];
        freq.put(old,freq.get(old)-1);
        nums2[index]+=val;
        freq.put(nums2[index],freq.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {
        int cnt=0;
        for (int i:nums1){
            int req=tot-i;
            cnt+=freq.getOrDefault(req,0);
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */