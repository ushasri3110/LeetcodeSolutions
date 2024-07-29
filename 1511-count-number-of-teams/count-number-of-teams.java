class Solution {
    public int numTeams(int[] rating) {
        int ans=0;
        int n=rating.length;
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                for(int k=j;k<n;k++){
                    if (rating[i]<rating[j] && rating[j]<rating[k]){
                        ans++;
                    }
                    else if(rating[i]>rating[j] && rating[j]>rating[k]){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}