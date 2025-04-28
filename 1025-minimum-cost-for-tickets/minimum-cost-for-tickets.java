class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer,Integer> map=new HashMap<>();
        return mincost(0,days,costs,map);
    }
    public int mincost(int index,int[] days,int[] costs,Map<Integer,Integer> map){
        if (index >= days.length) {
            return 0;
        }
        if (map.containsKey(index)){
            return map.get(index);
        }
        int oneDay=costs[0]+mincost(index+1,days,costs,map);
        int i=index;
        while (i<days.length && days[i]<days[index]+7){
            i++;
        }
        int sevenDay=costs[1]+mincost(i,days,costs,map);
        int j=index;
        while (j<days.length && days[j]<days[index]+30){
            j++;
        }
        int thirtyDay=costs[2]+mincost(j,days,costs,map);
        int minCost=Math.min(oneDay,Math.min(sevenDay,thirtyDay));
        map.put(index,minCost);
        return minCost;
    }
}