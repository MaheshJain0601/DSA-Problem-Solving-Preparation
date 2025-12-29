class Solution {
    // Stack based approach
    public String removeDuplicatesStack(String s) {
        StringBuilder sb = new StringBuilder();
        int size;
        for (char ch: s.toCharArray()) {
            size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == ch) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    // Two Pointer
    public String removeDuplicates(String s) {
        int begin = 0, end = 0;
        char[] input = s.toCharArray();
        while (end < input.length) {
            input[begin] = input[end];
            if (begin > 0 && input[begin-1] == input[begin]) {
                begin -= 2;
            }
            end++;
            begin++;
        }
        return new String(input, 0, begin);
    }
}