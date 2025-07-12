class Solution {
    public int maxProduct(int[] arr) {
        // code here
        int max=arr[0];
        int min=arr[0];
        int result=arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]<0){
                int temp=max;
                max=min;
                min=temp;
            }
            max=Math.max(max*arr[i],arr[i]);
            min=Math.min(min*arr[i],arr[i]);
            result=Math.max(result,max);
        }
        return result;
    }
}