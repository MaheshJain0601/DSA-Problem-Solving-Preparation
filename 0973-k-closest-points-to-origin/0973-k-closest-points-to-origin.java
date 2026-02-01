class Solution {
    class Pair<T, Q> {
        T first;
        Q second;
        public Pair(T first, Q second) {
            this.first = first;
            this.second = second;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, int[]>> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.first, a.first));
        for (int[] point: points) {
            int sortingKey = ((point[0]*point[0]) + (point[1]*point[1]));
            queue.offer(new Pair(sortingKey, point));
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!queue.isEmpty()) {
            result[index] = queue.poll().second;
            index++;
        }
        return result;
    }
}