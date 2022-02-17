class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        for (int index = 0; index < s.length(); ++index)
            alphabets[s.charAt(index) - 'a']++;
        for (int index = 0; index < t.length(); ++index)
            alphabets[t.charAt(index) - 'a']--;
        for (int i: alphabets) 
            if (i != 0)
                return false;
        return true;       
    }
}