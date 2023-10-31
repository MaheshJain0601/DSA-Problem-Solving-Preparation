class Solution {
    double MOD = 1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer, Long> map = new HashMap<>();
        
        Arrays.sort(arr);
        map.put(arr[0], 1L);
        
        for (int i = 1; i < arr.length; ++i) {
            int root = arr[i];
            map.put(root, 1L);
            
            for (int j = 0; j < i; ++j) {
                int leftChild = arr[j];
                if (root % leftChild == 0 && map.containsKey(arr[i]/leftChild)) {
                    long leftPossibleWays = map.get(leftChild);
                    long rightPossibleWays = map.get(arr[i]/leftChild);
                    
                    map.put(root, map.get(root) + (leftPossibleWays * rightPossibleWays));
                }   
            }
        }
        
        int result = 0;
        
        for (Map.Entry<Integer, Long> entry: map.entrySet()) {
            result = (int)((result + entry.getValue()) % MOD);
        }
        
        return result;
    }
}