class Solution {
    public int compress(char[] chars) {
        int count=1;
        int k=0;
        for (int i=0;i<chars.length;i++){
            if (i+1<chars.length && chars[i]==chars[i+1]){
                count++;
            }
            else{
                chars[k]=chars[i];
                k++;
                if (count>1){
                    char arr[]=String.valueOf(count).toCharArray();
                    for(char c:arr){
                        chars[k]=c;
                        k++;
                    }
                }
                count=1;
            }
        }
        return k;
    }
}