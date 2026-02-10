class Solution {
    private boolean checkFrequencySame(int[] chars) {
        int prevFreq = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] > 0 && prevFreq != 0 && chars[i] != prevFreq) {
                return false;
            } else if (prevFreq == 0) {
                prevFreq = chars[i];
            }
        }
        return true;
    }
    public int longestBalanced(String s) {
        int N = s.length();

        int[] chars;
        char ch;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; ++i) {
            chars = new int[26];
            for (int j = i; j < N; ++j) {
                ch = s.charAt(j);
                chars[ch - 'a']++;
                if (checkFrequencySame(chars)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }
}