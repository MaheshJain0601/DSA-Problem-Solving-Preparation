class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[N-k+1];
        int index = 0;
        while (index < N) {
            while (!deque.isEmpty() && deque.peekFirst() <= index - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[index] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            
            deque.offerLast(index);
            if (index >= k -1) {
                result[index - k + 1] = nums[deque.peekFirst()];
            }
            index++;
        }
        return result;
    }
}