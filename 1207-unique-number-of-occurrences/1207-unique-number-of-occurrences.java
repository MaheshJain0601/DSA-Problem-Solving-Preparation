class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int element: arr) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element)+1);
            } else {
                map.put(element, 1);
            }
        }
        return new HashSet(map.values()).size() == map.values().size();
    }
}