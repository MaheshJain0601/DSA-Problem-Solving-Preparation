class Solution {
    // Brute force
    // Sort each word and group them in their respective buckets
    // TC: O(N*KLogK)
    public List<List<String>> groupAnagramsBruteForce(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        char[] tempChars;
        String temp, sortedTemp;
        for (String str: strs) {
            temp = new String(str);
            tempChars = temp.toCharArray();
            Arrays.sort(tempChars);
            sortedTemp = new String(tempChars);

            hashMap.computeIfAbsent(sortedTemp, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry: hashMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;        
    }

    // Optimal force
    // IN constraints it is mentioned all chars are lowercase english letters i.e., 26
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        char[] tempChars;
        String temp, sortedTemp;
        for (String str: strs) {
            sortedTemp = generateSortedStr(str);

            hashMap.computeIfAbsent(sortedTemp, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry: hashMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;        
    }

    private String generateSortedStr(String str) {
        int[] strArray = new int[26];
        for(char ch: str.toCharArray()) {
            strArray[ch-'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < 26; ++index) {
            int freq = strArray[index];
            while(freq != 0) {
                sb.append(index + 'a');
                freq--;
            }
        }
        return sb.toString();
    }
}