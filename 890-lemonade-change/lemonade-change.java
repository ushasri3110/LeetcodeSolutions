class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveBills=0;
        int tenBills=0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveBills++;
            } else if (bill == 10) {
                if (fiveBills <= 0) {
                    return false;
                }
                fiveBills--;
                tenBills++;
            } else if (bill == 20) {
                if (tenBills > 0 && fiveBills > 0) {
                    tenBills--;
                    fiveBills--;
                } else if (fiveBills >= 3) {
                    fiveBills -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}