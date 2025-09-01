class LRUCache {
    HashMap<Integer, Node> map;
    DoublyLinkedList list;
    int cap;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoublyLinkedList();
        cap = capacity;
    }
    
    public int get(int key) {
        Node n = map.getOrDefault(key, null);
        if(n == null){
            return -1;
        }
        list.remove(n);
        list.push(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            list.remove(n);
            list.push(n);
            return;
        }
        if(map.size() == cap){
            Node toremove = list.pop();
            map.remove(toremove.key);
        }
        Node n = new Node(key, value);
        map.put(key, n);
        list.push(n);
    }
}

class Node{
    int key;
    int val;
    Node next;
    Node prev;
    public Node(){}
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;
    int size;
    public DoublyLinkedList(){
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    public Node pop(){
        Node oldTail = tail.prev;
        remove(oldTail);
        return oldTail;
    }

    public void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
        size--;
    }

    public void push(Node n){
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
        size++;
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */