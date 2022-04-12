class Solution {
    public String minWindow(String s, String t) {
        String answer = "";
        Map<Character, Integer> tMap = new HashMap<>();
        for (int index = 0; index < t.length(); ++index) {
            char ch = t.charAt(index);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        
        int desiredMatch = t.length();
        int match = 0;
        int left = -1;
        int right = -1;
        Map<Character, Integer> sMap = new HashMap<>();
        while (true) {
            boolean firstLoop = false;
            boolean secondLoop = false;
            // acquire till find equal length
            while (right < s.length()-1 && match < desiredMatch) {
                right++;
                char ch = s.charAt(right);
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                
                if (sMap.getOrDefault(ch, 0) <= tMap.getOrDefault(ch, 0)) {
                    match++;
                }
                firstLoop = true;
            }
            // collect answer && release for finding minimum length
            while (left < right && match == desiredMatch) {
                String potAnswer = s.substring(left+1, right+1);
                if (answer.length() == 0 || potAnswer.length() < answer.length()) {
                    answer = potAnswer;
                }
                
                left++;
                char ch = s.charAt(left);
                if (sMap.get(ch) == 1) {
                    sMap.remove(ch);
                } else {
                    sMap.put(ch, sMap.get(ch)-1);
                }
                
                 if (sMap.getOrDefault(ch, 0) < tMap.getOrDefault(ch, 0)) {
                    match--;
                }
                secondLoop = true;
            }
            if (firstLoop == false && secondLoop == false) {
                break;
            }
        }
        return answer;
    }
}