class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> unique = new HashSet<>();
        int left = 0;
        int longest = 0;
        for (int right = 0; right < s.length(); ++right) {
            while (unique.contains(s.charAt(right))) {
                unique.remove(s.charAt(left));
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            unique.add(s.charAt(right));
        }        
        return longest;
    }
}