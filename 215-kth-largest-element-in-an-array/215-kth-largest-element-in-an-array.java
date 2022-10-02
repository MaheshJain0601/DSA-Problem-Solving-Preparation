class Solution {
    // TC: O(N) + O(KlogN)
    // SC: O(N)
    // One of the solution; Not so efficient
    public int possibleFindKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int item: nums) {
            pq.offer(item);
        }
        for (int index = 0; index < k - 1; index++) {
            pq.poll();
        }
        return pq.poll();
    }
    
    // TC: O(N)
    // SC: O(K)
    // Best efficient solution
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int element: nums) {
            pq.offer(element);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}