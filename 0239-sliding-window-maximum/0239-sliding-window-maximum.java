class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dequeue = new LinkedList<>();
        
        int[] result = new int[nums.length-k+1];
        int left = 0, right = 0, index = 0;
        
        while (right < nums.length) {
            
            while (!dequeue.isEmpty() && nums[right] > nums[dequeue.peekLast()]) {
                dequeue.pollLast();
            }
            dequeue.offerLast(right);
            
            if (right -left + 1 == k) {
                result[index++] = nums[dequeue.peekFirst()];
                if (nums[left] == nums[dequeue.peekFirst()]) {
                    dequeue.pollFirst();
                }
                left++;
            }
            right++;
        }
        
        return result;
        
    }
}