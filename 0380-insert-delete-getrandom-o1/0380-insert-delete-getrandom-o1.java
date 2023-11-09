import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    
    ArrayList<Integer> nums;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new java.util.Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        int pos = nums.size();
        map.put(val, pos);
        nums.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int index = map.get(val);
        if (index < nums.size()-1) {
            int lastElement = nums.get(nums.size()-1);
            nums.set(index , lastElement);
            map.put(lastElement, index);
        }
        nums.remove(nums.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        if (nums.size() <= 0) {
            return -1;
        }
        
        int index = random.nextInt(nums.size());
        return nums.get(index);   
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */