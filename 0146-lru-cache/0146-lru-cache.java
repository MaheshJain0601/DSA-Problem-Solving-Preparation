class LRUCache {
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    Node head, tail;
    Map<Integer, Node> lookup;
    int capacity;


    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        lookup = new HashMap<>();
        this.capacity = capacity;
    }

    private void insertAfter(Node node, Node newNode) {
        Node temp = node.next;

        newNode.next = temp;
        newNode.prev = node;

        node.next = newNode;
        temp.prev = newNode;
    }

    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    
    public int get(int key) {
        Node node = lookup.get(key);
        if (node == null) {
            return -1;
        }
        deleteNode(node);
        insertAfter(head, node);

        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = lookup.get(key);
        if (node == null) {
            if (lookup.size() == capacity) {
                lookup.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            node = new Node(key, value);
            insertAfter(head, node);
            lookup.put(key, node);
        } else {
            node.val = value;
            deleteNode(node);
            insertAfter(head, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */