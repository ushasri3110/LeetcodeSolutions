class Solution {
    public boolean isVowel(char c){
        if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        char[] arr=s.toCharArray();
        int count=0;
        for(int i=0;i<k;i++){
            if (isVowel(arr[i])){
                count++;
            }
        }
        int maxCount=count;
        int i=0;
        int j=k;
        while(j<arr.length){
            if (isVowel(arr[i])){
                count--;
            }
            i++;
            if (isVowel(arr[j])){
                count++;
            }
            j++;
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}