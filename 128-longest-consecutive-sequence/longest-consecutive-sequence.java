// class Solution {
//     public int longestConsecutive(int[] nums) {
//         HashSet<Integer> set=new HashSet<>();
//         for (int i:nums){
//             set.add(i);
//         }
//         int ans=0;
//         for (int i:set){
//             if (!set.contains(i-1)){
//                 int count=1;
//                 int current=i;
//                 while (set.contains(current+1)){
//                     current++;
//                     count++;
//                 }
//                 ans=Math.max(ans,count);
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> map=new HashMap<>();
        int longest=0;
        for (int i:nums){
            map.put(i,false);
        }
        for (int i:nums){
            int current=1;
            int next=i+1;
            while (map.containsKey(next) && map.get(next)==false){
                current++;
                map.put(next,true);
                next++;
            }
            int prev=i-1;
            while (map.containsKey(prev) && map.get(prev)==false){
                current++;
                map.put(prev,true);
                prev--;
            }
            longest=Math.max(longest,current);
        }
        return longest;
    }
}