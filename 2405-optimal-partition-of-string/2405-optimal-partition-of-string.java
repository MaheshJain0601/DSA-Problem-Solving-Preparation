class Solution {
    public int partitionString(String s) {
        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        
        int minPossibleUniqueSubstrCount = 0;
        int currentStart = 0;
        
        for (int index = 0; index < s.length(); ++index) {
            char ch = s.charAt(index);
            
            if (lastSeenIndex.get(ch) != null && currentStart <= lastSeenIndex.get(ch)) {
                currentStart = index;
                minPossibleUniqueSubstrCount++;
            }
            lastSeenIndex.put(ch, index);
        }
        minPossibleUniqueSubstrCount++;
        
        return minPossibleUniqueSubstrCount;
    }
}