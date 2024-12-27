class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int canPlace = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int prev = -1;
            int next = -1;
            if (flowerbed[i] == 0) {
                if (i == 0 || flowerbed[i - 1] == 0) {
                    prev = 0;
                }
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    next = 0;
                }
            }
            if (prev == 0 && next == 0) {
                flowerbed[i] = 1;
                canPlace++;
            }
        }
        if (canPlace >= n) {
            return true;
        }
        return false;
    }
}