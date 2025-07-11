class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        int c1=0,c2=0;
        int m1=Integer.MIN_VALUE,m2=Integer.MIN_VALUE;
        for (int i:nums){
            if (c1==0 && i!=m2){
                c1=1;
                m1=i;
            }
            else if (c2==0 && i!=m1){
                c2=1;
                m2=i;
            }
            else if (i==m1){
                c1++;
            }
            else if (i==m2){
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for (int i:nums){
            if (i==m1) c1++;
            if (i==m2) c2++;
        }
        if (c1>(n/3)) res.add(m1);
        if (c2>(n/3)) res.add(m2);
        return res;
    }
}