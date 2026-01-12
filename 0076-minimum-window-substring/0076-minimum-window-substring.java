class Solution {
    public String minWindow(String s, String t) {
        String DEFAULT_ANSWER = "";
        int tLength = t.length();
        int sLength = s.length();
        if (tLength > sLength) return DEFAULT_ANSWER;

        int minWindowSize = Integer.MAX_VALUE;
        int minStrStartIndex = Integer.MAX_VALUE;
        int requiredCount = tLength;
        
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch: t.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        int i = 0, j = 0;
        int currFreq;
        char ch;

        while (j < sLength) {
            ch = s.charAt(j);
            currFreq = freqMap.getOrDefault(ch, 0);
            if (currFreq > 0) {
                requiredCount -= 1;   
            }
            freqMap.put(ch, currFreq - 1);

            while (i <= j && requiredCount == 0) {
                if (minWindowSize >= j - i + 1) {
                    minWindowSize = j - i + 1;
                    minStrStartIndex = i;
                }
                ch = s.charAt(i);
                freqMap.put(ch, freqMap.get(ch) + 1);
                if (freqMap.get(ch) > 0) {
                    requiredCount += 1;
                }
                i++;
            }
            j++;
        }
        return minWindowSize == Integer.MAX_VALUE ? DEFAULT_ANSWER : s.substring(minStrStartIndex, minStrStartIndex + minWindowSize);
        
    }
}