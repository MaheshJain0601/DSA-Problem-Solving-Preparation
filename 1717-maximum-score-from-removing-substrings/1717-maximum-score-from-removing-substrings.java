class Solution {
    private String removeSubStr(String s, String matchStr) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char ch;
        while (index < s.length()) {
            ch = s.charAt(index);
            if (sb.length() >= 1 && ch == matchStr.charAt(1) && sb.charAt(sb.length() - 1) == matchStr.charAt(0)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
            index++;
        }
        return sb.toString();
    }
    public int maximumGain(String s, int x, int y) {
        int N = s.length();
        int maxScore = 0;

        String maxStr = (x > y) ? "ab" : "ba";
        String minStr = (x <= y) ? "ab" : "ba";
    
        String first_temp = removeSubStr(s, maxStr);
        int charRemoved = N - first_temp.length();

        maxScore += ((charRemoved/2) * Math.max(x, y));

        String second_temp = removeSubStr(first_temp, minStr);
        charRemoved = first_temp.length() - second_temp.length();

        maxScore += ((charRemoved/2) * Math.min(x, y));
        
        return maxScore;
    }
}