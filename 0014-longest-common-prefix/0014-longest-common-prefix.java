class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder answer = new StringBuilder();
        Arrays.sort(strs);
        String firstElement = strs[0];
        String lastElement = strs[strs.length-1];
        
        for (int index = 0; index < Math.min(firstElement.length(), lastElement.length()); ++index) {
            
            if (firstElement.charAt(index) != lastElement.charAt(index)) {
                break;
            }
            
            answer.append(firstElement.charAt(index));
        }
        
        return answer.toString();
    }
}