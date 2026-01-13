class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int maxVowels(String s, int k) {
        int i = 0, j = 0;
        int maxVowels = Integer.MIN_VALUE;
        int currVowels = 0;
        char ch;
        while (j < s.length()) {
            ch = s.charAt(j);
            if (isVowel(ch)) {
                currVowels += 1;
            }

            if (j - i + 1 == k) {
                maxVowels = Math.max(maxVowels, currVowels);
                ch = s.charAt(i);
                if (isVowel(ch)) {
                    currVowels -= 1;
                }
                i++;
            }
            j++;
        }
        return maxVowels;
    }
}