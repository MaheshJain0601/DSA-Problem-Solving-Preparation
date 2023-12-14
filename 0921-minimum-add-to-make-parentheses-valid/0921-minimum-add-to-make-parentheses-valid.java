class Solution {
    public int minAddToMakeValid(String s) {
        
        int openParenCount = 0;
		int closeParenCount = 0;
        int length = s.length();
        
		// for (char ch: pattern.toCharArray()) {
        for (int index = 0; index < length; ++index) {
            char ch = s.charAt(index);
			if (ch == '(') {
				openParenCount++;
			} else if (ch == ')' && openParenCount > 0) {
				openParenCount--;
			} else if (ch == ')') {
				closeParenCount++;
			}
		}

		return openParenCount+closeParenCount;
        
    }
}