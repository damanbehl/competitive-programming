import java.util.HashSet;
//https://leetcode.com/problems/longest-consecutive-sequence/description/
class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> keySet = new HashSet<>();
        for(Integer num: nums)
            keySet.add(num);
        int longestSequence = 0;
        for(Integer num: keySet){
            if(!keySet.contains(num-1)){
                int currentNum = num;
                int count = 1;
                // longestSequence = 1;
                while(keySet.contains(currentNum+1)){
                    currentNum +=1;
                    count++;
                }
                longestSequence = Math.max(count, longestSequence);
            }
        }
        return longestSequence;
    }
}