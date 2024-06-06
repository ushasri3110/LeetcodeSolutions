class Solution {
    public boolean isNStraightHandHelper(int[] hand,int groupSize,int i,int n){
        int next=hand[i]+1;
        hand[i]=-1;
        int count=1;
        i++;
        while (i<n && count < groupSize){
            if (hand[i]==next){
                next=hand[i]+1;
                hand[i]=-1;
                count++;
            }
            i++;
        }
        if (count!=groupSize){
            return false;
        }
        return true;
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        if (hand.length%groupSize!=0){
            return false;
        }
        for (int i=0;i<hand.length;i++){
            if (hand[i]>=0){
                if (!isNStraightHandHelper(hand,groupSize,i,hand.length)){
                    return false;
                }
            }
        }
        return true;
    }
}