class Solution {
    public String smallestPalindrome(String s) {
        int N = s.length();
        int mid = N / 2;
        char[] chars = s.toCharArray();
        Arrays.sort(chars, 0, mid);
        for (int index = 0; index < mid; ++index) {
            chars[N - 1 - index] = chars[index];
        }
        return new String(chars);
    }
}