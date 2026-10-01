class Node {
    int data;
    int key;
    Node prev;
    Node next;
    Node(int key, int data) {
        this.data = data;
        this.key = key;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    int capacity = 0;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map.clear();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.data;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        insertAfterHead(node);

        if(map.size() > capacity) {
            Node lru = tail.prev;
            deleteNode(lru);
            map.remove(lru.key);
        }
    }

    void insertAfterHead(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

    void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
