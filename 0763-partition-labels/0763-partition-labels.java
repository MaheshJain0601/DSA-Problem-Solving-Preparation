class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastOcurrence = new int[26];
        
        char ch;
        for (int index = 0; index < s.length(); ++index) {
            ch = s.charAt(index);
            lastOcurrence[ch - 'a'] = index;
        }

        List<Integer> result = new ArrayList<>();

        int start = 0, end = 0;
        for (int index = 0; index < s.length(); ++index){
            end = Math.max(end, lastOcurrence[s.charAt(index) - 'a']);
            if (end == index){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}