class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, ArrayList<String>> answer = new HashMap<>();
        for (String str: strs) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int index = 0; index < str.length(); ++index) {
                if (temp.containsKey(str.charAt(index))) {
                    int value = temp.get(str.charAt(index));
                    value++;
                    temp.put(str.charAt(index), value);
                } else {
                    temp.put(str.charAt(index), 1);
                }
            }
            if (answer.containsKey(temp)) {
                answer.get(temp).add(str);
            } else {
                answer.put(temp, new ArrayList<>());
                answer.get(temp).add(str);
            }
        }
        return new ArrayList<>(answer.values());
    }
}