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
        Node newNode = null;
        if(!map.containsKey(key)){
            if(tail.next.freq == 1){
                newNode = tail.next;
            }else{
                newNode = new Node(1);
                newNode.putBetween(tail, tail.next);
            }
        }else{
            Node oldNode = map.get(key);
            if(oldNode.next.freq == oldNode.freq + 1){
                newNode = oldNode.next;
            }else{
                newNode = new Node(oldNode.freq + 1);
                newNode.putBetween(oldNode, oldNode.next);
            }
            oldNode.set.remove(key);
            if(oldNode.set.isEmpty()){
                oldNode.remove();
            }
        }
        newNode.set.add(key);
        map.put(key, newNode);
    }
    
    public void dec(String key) {
        Node oldNode = map.get(key);
        if(oldNode.freq == 1){
            map.remove(key);
        }else{
            Node newNode = null;
            if (oldNode.prev.freq == oldNode.freq - 1){
                newNode = oldNode.prev;
            }else{
                newNode = new Node(oldNode.freq - 1);
                newNode.putBetween(oldNode.prev, oldNode);
            }
            newNode.set.add(key);
            map.put(key, newNode);
        }
        oldNode.set.remove(key);
        if(oldNode.set.isEmpty()){
            oldNode.remove();
        }
    }
    
    public String getMaxKey() {
        if(head.prev == tail){
            return "";
        }else{
            return head.prev.set.iterator().next();
        }
    }
    
    public String getMinKey() {
        if(tail.next == head){
            return "";
        }else{
            return tail.next.set.iterator().next();
        }
    }

}

class Node{
    Node prev;
    Node next;
    int freq;
    Set<String> set;

    public Node(){}
    public Node(int freq){
        this.freq = freq;
        set = new HashSet<>();
    }

    public void putBetween(Node prev, Node next){
        prev.next = this;
        next.prev = this;
        this.prev = prev;
        this.next = next;
    }

    public void remove(){
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


