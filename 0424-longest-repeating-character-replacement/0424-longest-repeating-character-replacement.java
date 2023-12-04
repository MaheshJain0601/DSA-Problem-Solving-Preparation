class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] charFrequency = new int[26];
        int start = 0, end = 0, maxLen = 0, maxFrequency = 0;
        
        while (end < s.length()) {
            int idx = s.charAt(end) - 'A';
            charFrequency[idx]++;
            
            maxFrequency = Math.max(maxFrequency, charFrequency[idx]);
            
            if (end-start+1-maxFrequency > k) {
                charFrequency[s.charAt(start)-'A']--;
                start++;
            }
            
            maxLen = Math.max(maxLen, end-start+1);    
            end++;
        }
        
        return maxLen;
    }
}