class Solution {
    public String predictPartyVictory(String senate) {
        char prev=' ';
        int dCount=0;
        int rCount=0;
        int nextRBanned=0;
        int nextDBanned=0;
        Queue<Character> queue=new LinkedList<>();
        for (char ch:senate.toCharArray()){
            if (ch=='R'){
                rCount++;
            }
            else{
                dCount++;
            }
            queue.offer(ch);
        }
        if (dCount==0){
            return "Radiant";
        }
        else if (rCount==0){
            return "Dire";
        }

        while(rCount>0 && dCount>0){
            prev=queue.poll();
            if (prev=='R'){
                if (nextRBanned==0){
                    nextDBanned++;
                    queue.offer(prev);
                }
                else{
                    rCount--;
                    nextRBanned--;
                }
            }
            else{
                if(nextDBanned==0){
                    nextRBanned++;
                    queue.offer(prev);
                }
                else{
                    dCount--;
                    nextDBanned--;
                }
            }
        }
        return queue.peek()=='R'?"Radiant":"Dire";
    }
}