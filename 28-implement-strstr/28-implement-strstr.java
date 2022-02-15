class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        return (haystack.contains(needle) ? haystack.indexOf(needle): -1);        
    }
}