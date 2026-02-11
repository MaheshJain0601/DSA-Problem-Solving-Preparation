class Solution {
    static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    // Brute force
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (b.first != a.first) {
                return Integer.compare(b.first, a.first);
            }
            return Integer.compare(b.second, a.second);
        });
        for (int index = 0; index < arr.length; ++index) {
            pq.offer(new Pair(Math.abs(x - arr[index]), arr[index]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>(pq.size());
        while (!pq.isEmpty()) {
            result.add(pq.poll().second);
        }
        Collections.sort(result);
        return result;
    }
}