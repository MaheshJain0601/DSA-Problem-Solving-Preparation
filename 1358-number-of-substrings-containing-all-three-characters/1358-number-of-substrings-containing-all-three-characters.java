class Solution {
    public int numberOfSubstrings(String s) {
        int []countOccurence = new int[3];
        int i = 0, j = 0;
        int length = s.length();
        
        int totalPossibleSubstr = 0;
        
        while (j < length) {
            char ch = s.charAt(j);
            countOccurence[ch - 'a'] += 1;
            
            while (
                (i <= j) 
                && 
                ((countOccurence[0] >= 1) && (countOccurence[1] >= 1) && (countOccurence[2] >= 1))) {
                totalPossibleSubstr += (length - j);
                countOccurence[s.charAt(i) - 'a'] -= 1;
                i++;
            }
            j++;
        }
        
        return totalPossibleSubstr;
    }
}