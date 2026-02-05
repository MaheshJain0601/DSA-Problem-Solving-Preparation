class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOcurrence = new int[26];
        
        char ch;
        for (int index = 0; index < s.length(); ++index) {
            ch = s.charAt(index);
            lastOcurrence[ch - 'a'] = Math.max(lastOcurrence[ch - 'a'], index);
        }

        int i = 0, j, end;
        List<Integer> result = new ArrayList<>();
        while (i < s.length()) {
            ch = s.charAt(i);
            end = lastOcurrence[ch - 'a'];
            j = i;
            while (j < end) {
                ch = s.charAt(j);
                end = Math.max(end, lastOcurrence[ch - 'a']);
                j++;
            }
            result.add(j-i+1);
            i = j + 1;
        }

        return result;
    }
}