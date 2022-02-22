class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int item: nums) {
            pq.offer(item);
        }
        for (int index = 0; index < k - 1; index++) {
            pq.poll();
        }
        return pq.poll();
    }
}