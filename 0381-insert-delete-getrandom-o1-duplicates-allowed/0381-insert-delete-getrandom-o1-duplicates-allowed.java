class RandomizedCollection {

    private List<Integer> nums;
    private Map<Integer, Set<Integer>> numIndex;
    private Random random;

    public RandomizedCollection() {
        nums = new ArrayList<>();
        numIndex = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        boolean containsVal = numIndex.containsKey(val);
        numIndex.computeIfAbsent(val, k -> new HashSet<>()).add(nums.size());
        nums.add(val);
        return !containsVal;
    }
    
    public boolean remove(int val) {
        boolean containsVal = numIndex.containsKey(val);
        // val does not exists
        if (!containsVal) {
            return false;
        }
        
        // val exists then retrive one of the index
        int valIndex = numIndex.get(val).iterator().next();
        numIndex.get(val).remove(valIndex);
        if (numIndex.get(val).isEmpty()) {
            numIndex.remove(val);
        }
        
        int lastIndex = nums.size() - 1;

        if (valIndex != lastIndex) {
            numIndex.get(nums.get(lastIndex)).remove(lastIndex);
            numIndex.get(nums.get(lastIndex)).add(valIndex);

            nums.set(valIndex, nums.get(lastIndex));
        }
        nums.remove(lastIndex);
        
        return true;
    }
    
    public int getRandom() {
        if (nums.size() <= 0) {
            return -1;
        }
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */