class Solution {
    class Node {
        public int element;
        public int frequency;
        public Node(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }
        
        public int getFrequency() {
            return this.frequency;
        }
        
        public int getElement() {
            return this.element;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((item1, item2) -> Integer.compare(item1.getFrequency(), item2.getFrequency()));
        for(Map.Entry<Integer,Integer> item: map.entrySet()) {
            minHeap.add(new Node(item.getKey(), item.getValue()));
            if (minHeap.size() > k) minHeap.poll(); 
        }

        int[] result = new int[k];
        for (int index = 0; index < k; index++) {
            result[index] = minHeap.poll().getElement();
        }
        return result;
    }
}