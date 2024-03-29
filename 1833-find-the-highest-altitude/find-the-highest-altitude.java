class Solution {
    public int largestAltitude(int[] gain) {
        int max_altitude=0;
        int altitudes[]=new int[gain.length+1];
        altitudes[0]=0;
        for (int i=1;i<altitudes.length;i++){
            altitudes[i]=altitudes[i-1]+gain[i-1];
            max_altitude=Math.max(max_altitude,altitudes[i]);
        }
        return max_altitude;
    }
}