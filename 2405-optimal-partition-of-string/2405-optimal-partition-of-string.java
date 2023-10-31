class Solution {
    public int partitionString(String s) {
        int[] lastSeenIndex = new int[26];
        Arrays.fill(lastSeenIndex, -1);
        
        int minPossibleUniqueSubstrCount = 0;
        int currentStart = 0;
        int index = 0;
        for (index = 0; index < s.length(); ++index) {
            char ch = s.charAt(index);
            
            int charIndex = ch - 'a';
            
            if (lastSeenIndex[charIndex] >= currentStart) {
                currentStart = index;
                minPossibleUniqueSubstrCount++;
            }
            lastSeenIndex[charIndex] = index;
        }
        if (currentStart < index)
            minPossibleUniqueSubstrCount++;
        
        return minPossibleUniqueSubstrCount;
    }
}