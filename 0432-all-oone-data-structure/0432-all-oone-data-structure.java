class AllOne {
    static class Node {
        int freq;
        Node prev, next;
        Set<String> elements;
        public Node(int freq) {
            this.freq = freq;
            prev = next = null;
            elements = new HashSet<>();
        }
    }

    Node head, tail;
    Map<String, Node> keyToNodes;

    public AllOne() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        keyToNodes = new HashMap<>();
    }
    
    public void inc(String key) {
        Node currNode = keyToNodes.get(key);
        // key is not present
        if (currNode == null) {
            Node firstNode = head.next;
            if (firstNode != tail && firstNode.freq == 1) {
                firstNode.elements.add(key);
                keyToNodes.put(key, firstNode);
            } else {
                Node newNode = new Node(1);
                newNode.elements.add(key);
                insertAfter(head, newNode);
                keyToNodes.put(key, newNode);
            }
        } else {
            Node nextNode = currNode.next;
            if (nextNode != tail && nextNode.freq == currNode.freq + 1) {
                nextNode.elements.add(key);
                keyToNodes.put(key, nextNode);
            } else {
                Node newNode = new Node(currNode.freq + 1);
                newNode.elements.add(key);
                insertAfter(currNode, newNode);
                keyToNodes.put(key, newNode);
            }

            currNode.elements.remove(key);
            if (currNode.elements.isEmpty()) {
                removeNode(currNode);
            }
        }
    }
    
    public void dec(String key) {
        Node currNode = keyToNodes.get(key);
        if (currNode.freq == 1) {
            currNode.elements.remove(key);
            keyToNodes.remove(key);
            if (currNode.elements.isEmpty()) {
                removeNode(currNode);
            }
        } else {
            Node prevNode = currNode.prev;
            if (prevNode != head && prevNode.freq == currNode.freq - 1) {
                prevNode.elements.add(key);
                keyToNodes.put(key, prevNode);
            } else {
                Node newNode = new Node(currNode.freq - 1);
                newNode.elements.add(key);
                insertAfter(prevNode, newNode);
                keyToNodes.put(key, newNode);
            }
            currNode.elements.remove(key);
            if (currNode.elements.isEmpty()) {
                removeNode(currNode);
            }
        }
    }
    
    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.elements.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.elements.iterator().next();
    }

    // Doubly linked list helpers
    private void insertAfter(Node prev, Node node) {
        node.prev = prev;
        node.next = prev.next;
        prev.next.prev = node;
        prev.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */