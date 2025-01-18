class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        if (n==0){
            return res;
        }
        int candidate1=Integer.MIN_VALUE;
        int candidate2=Integer.MIN_VALUE;
        int count1=0;
        int count2=0;
        for (int i:nums){
            if (i==candidate1){
                count1++;
            }
            else if (i==candidate2){
                count2++;
            }
            else if (count1==0){
                candidate1=i;
                count1=1;
            }
            else if (count2==0){
                candidate2=i;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for (int i:nums){
            if (i==candidate1){
                count1++;
            }
            if (i==candidate2){
                count2++;
            }
        }
        System.out.println(count1+" "+count2);
        if (count1>n/3){
            res.add(candidate1);
        }
        if (count2>n/3){
            res.add(candidate2);
        }
        return res;
    }
}