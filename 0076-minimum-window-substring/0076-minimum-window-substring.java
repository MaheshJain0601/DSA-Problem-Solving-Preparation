class Solution {
    public String minWindow(String s, String t) {
        String DEFAULT_ANSWER = "";
        int sLength = s.length();
        int tLength = t.length();
        if (tLength > sLength) return DEFAULT_ANSWER;

        Map<Character, Integer> freqMap = new HashMap<>();
        char ch;
        for (int index = 0; index < tLength; ++index) {
            ch = t.charAt(index);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int requiredCount = tLength;
        int minWindowSize = Integer.MAX_VALUE;
        int minStrStartIndex = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int currFreq;

        while (j < sLength) {
            ch = s.charAt(j);
            currFreq = freqMap.getOrDefault(ch, 0);
            if (currFreq > 0) {
                requiredCount--;
            }
            freqMap.put(ch, currFreq - 1);


            while (i <= j && requiredCount == 0) {
                if (minWindowSize > j - i + 1) {
                    minWindowSize = j - i + 1;
                    minStrStartIndex = i;
                }
                ch = s.charAt(i);
                freqMap.put(ch, freqMap.get(ch) + 1);
                if (freqMap.get(ch) > 0) {
                    requiredCount++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? DEFAULT_ANSWER : s.substring(minStrStartIndex, minStrStartIndex + minWindowSize);
    }
}