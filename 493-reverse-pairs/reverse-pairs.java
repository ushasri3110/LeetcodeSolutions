class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
    public int mergeSort(int[] nums,int low,int high){
        int count=0;
        if (low>=high) return count;
        int mid=(low+high)/2;
        count+=mergeSort(nums,low,mid);
        count+=mergeSort(nums,mid+1,high);
        count+=merge(nums,low,mid,high);
        return count;
    }
    public int merge(int[] arr,int low,int mid,int high){
        int count=0;
        int right=mid+1;
        for (int left=low;left<=mid;left++){
            while (right <= high && (long) arr[left] > 2L * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        int i=low;
        int j=mid+1;
        List<Integer> temp=new ArrayList<>();
        while (i<=mid && j<=high){
            if (arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                j++;
            }
        }
        while (i<=mid){
            temp.add(arr[i]);
            i++;
        }
        while (j<=high){
            temp.add(arr[j]);
            j++;
        }
        for (int x=low;x<=high;x++){
            arr[x]=temp.get(x-low);
        }
        return count;
    }
}