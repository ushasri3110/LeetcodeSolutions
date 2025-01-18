class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int greatest=-1;
        for (int i=n-1;i>=0;i--){
            int current=arr[i];
            arr[i]=greatest;
            if (current>greatest){
                greatest=current;
            }
        }
        arr[n-1]=-1;
        return arr;
    }
}