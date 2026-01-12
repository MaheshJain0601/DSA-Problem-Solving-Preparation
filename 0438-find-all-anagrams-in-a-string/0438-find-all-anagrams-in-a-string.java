class Solution {
    private boolean allOccurencesFound(int[] freq) {
        for (int index = 0; index < freq.length; ++index) {
            if (freq[index] > 0) 
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String txt, String pat) {
        int pattern_length = pat.length();
        int txt_length = txt.length();
        List<Integer> allAnagrams = new ArrayList<>();
        if (pattern_length > txt_length) {
            return allAnagrams;
        }
        
        int[] freq = new int[26];
        char ch;
        for (int index = 0; index < pattern_length; ++index) {
            ch = pat.charAt(index);
            freq[ch - 'a'] += 1;
        }
        
        int i = 0, j = 0;
        
        while (j < txt_length) {
            ch = txt.charAt(j);
            freq[ch - 'a'] -= 1;
            if (j - i + 1 == pattern_length) {
                if (allOccurencesFound(freq)) {
                    allAnagrams.add(i);
                }
                freq[txt.charAt(i) - 'a'] += 1;
                i++;
            }
            j++;
        }
        return allAnagrams;
    }
}