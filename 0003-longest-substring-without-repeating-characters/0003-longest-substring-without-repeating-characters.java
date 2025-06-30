class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToIndexPosition = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (charToIndexPosition.containsKey(ch)) {
                // Added Math.max, because what if left has already surpassed 
                // the duplicate character which we are current positioning to
                left = Math.max(left, charToIndexPosition.get(ch) + 1);
            }
            charToIndexPosition.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}