class Solution {
    public int findClosest(int x, int y, int z) {
        int xs=Math.abs(x-z);
        int ys=Math.abs(y-z);
        return xs<ys?1:(xs>ys?2:0);
    }
}