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
    // TC: O(nlogk) + O(klogk)
    // SC: O(k) + O(k)
    public List<Integer> findClosestElementsBrute(int[] arr, int k, int x) {
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

    // Better Solution
    // TC: O(N)
    // SC: O(N)
    public List<Integer> findClosestElementsBetter(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        int low = 0;
        int high = arr.length - 1;

        while (high - low >= k) {
            int distLow = Math.abs(arr[low] - x); 
            int distHigh = Math.abs(arr[high] - x);

            if (distLow <= distHigh) {
                high--;         
            } else {
                low ++;
            }
        }

        while(low <= high)
            result.add(arr[low++]);

        return result;
    }

    // Optimal
    // TC: O(log (N-K) + K)
    // SC: O(N)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        while (left < right){
            int mid = left + (right - left)/2;
            if (x - arr[mid] > arr[mid+k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        List<Integer> result = new ArrayList();
        for(int i = left ; i < left+k ; i++){
            result.add(arr[i]);
        }
        return result;
    }
}