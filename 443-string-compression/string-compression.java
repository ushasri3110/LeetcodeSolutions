class Solution {
    public int compress(char[] chars) {
        int k=0;
        int count=1;
        for (int i=0;i<chars.length;i++){
            if (i+1<chars.length && chars[i]==chars[i+1]){
                count++;
            }
            else{
                chars[k++]=chars[i];
                if (count>1){
                    char[] arr=String.valueOf(count).toCharArray();
                    for (char ch:arr){
                        chars[k++]=ch;
                    }
                }
                count=1;
            }
        }
        return k;
    }
}