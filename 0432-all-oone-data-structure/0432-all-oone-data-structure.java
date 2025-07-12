class AllOne {
    Node head;
    Node tail;
    Map<String, Node> map;
    public AllOne() {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.prev = tail;
        tail.next = head;
    }
    
    public void inc(String key) {
        if(!map.containsKey(key)){
            Node min = new Node(1, key);
            tail.putAhead(min);
            map.put(key, min);
            return;
        }
        Node node = map.get(key);
        Node cur = node;
        while(cur != head && cur.cnt < node.cnt + 1){
            cur = cur.next;
        }
        node.cnt++;
        node.removeFromList();
        cur.putBehind(node);
    }
    
    public void dec(String key) {
        Node node = map.get(key);
        if(node.cnt == 1){
            node.removeFromList();
            map.remove(key);
            return;
        }
        Node cur = node;
        while(cur != tail && cur.cnt > node.cnt - 1){
            cur = cur.prev;
        }
        node.cnt--;
        node.removeFromList();
        cur.putAhead(node);
    }
    
    public String getMaxKey() {
        if(head.prev == tail){
            return "";
        }else{
            return head.prev.key;
        }
    }
    
    public String getMinKey() {
        if(tail.next == head){
            return "";
        }else{
            return tail.next.key;
        }
    }

}

class Node{
    Node prev;
    Node next;
    String key;
    int cnt;

    public Node(){}
    public Node(int cnt, String key){
        this.key = key;
        this.cnt = cnt;
    }

    public void putBehind(Node behind){
        this.prev.next = behind;
        behind.prev = this.prev;
        behind.next = this;
        this.prev = behind;
    }

    public void putAhead(Node ahead){
        this.next.prev = ahead;
        ahead.next = this.next;
        this.next = ahead;
        ahead.prev = this;
    }

    public void removeFromList(){
        this.next.prev = this.prev;
        this.prev.next = this.next;
        this.prev = null;
        this.next = null;
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


