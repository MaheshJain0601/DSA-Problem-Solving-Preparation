class Solution {
    public int minAddToMakeValid(String s) {
        int openingBrackets = 0, closingBrackets = 0;
        int N = s.length();

        int index = 0;
        char ch;
        while (index < N) {
            ch = s.charAt(index);
            if (ch == '(') {
                openingBrackets++;
            } else if (openingBrackets > 0) {
                openingBrackets--;
            } else {
                closingBrackets++;
            }
            index++;
        }
        return openingBrackets + closingBrackets;
        
    }
}