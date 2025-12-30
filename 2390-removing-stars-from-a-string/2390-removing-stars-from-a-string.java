class Solution {
    public String removeStarsStackApproach(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()) {
            if (ch != '*') {
                sb.append(ch);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public String removeStars(String s) {
        char[] result = s.toCharArray();
        int i = 0, j = 0;;
        while (j < result.length) {
            result[i] = result[j];
            if (result[i] == '*') {
                i -= 2;
            }
            i++;
            j++;
        }
        return new String(result, 0, i);
    }
}