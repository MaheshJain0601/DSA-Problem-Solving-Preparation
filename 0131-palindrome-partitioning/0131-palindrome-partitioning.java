class Solution {
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }
    private void partitionHelper(String s, int index, List<List<String>> result, List<String> curr) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i + 1));
                partitionHelper(s, i + 1, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s.length() <= 0) {
            return result;
        }
        List<String> curr = new ArrayList<>();
        partitionHelper(s, 0, result, curr);
        return result;
    }
}