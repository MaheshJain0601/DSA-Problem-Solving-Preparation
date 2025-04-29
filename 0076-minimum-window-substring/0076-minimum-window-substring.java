class Solution {
    public String minWindow(String s, String t) {
        String DEFAULT_ANSWER = "";
        if (t.length() > s.length()) {
            return DEFAULT_ANSWER;
        }

        Map<Character, Integer> freq = new HashMap<>();

        for (char ch: t.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        int minWindow = Integer.MAX_VALUE;
        int windowStart = -1;
        int requiredCount = t.length();
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (freq.containsKey(ch) && freq.get(ch) > 0) {
                requiredCount -= 1;
            }
            freq.put(ch, freq.getOrDefault(ch, 0) - 1);

            while (i <= j && requiredCount == 0) {
                if (j - i + 1 < minWindow) {
                    minWindow = j - i + 1;
                    windowStart = i;
                }
                freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
                if (freq.get(s.charAt(i)) > 0) {
                    requiredCount += 1;
                }
                i++;
            }
            j++;
        }

        return minWindow == Integer.MAX_VALUE ? DEFAULT_ANSWER : s.substring(windowStart, windowStart + minWindow);
    }
}