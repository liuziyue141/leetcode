type LRUCache struct {
    Map map[int]*Node
    Queue LinkedList
    Cap int
}

type LinkedList struct {
    Head *Node
    Tail *Node
}

func (this *LinkedList) moveToFront(node *Node) {
    this.remove(node)
    this.add(node)
}

func (this *LinkedList) removeLast() *Node{
    evictNode := this.Tail.Prev
    this.remove(evictNode)
    return evictNode
}

func (this *LinkedList) add(node *Node){
    node.Next = this.Head.Next
    node.Prev = this.Head
    node.Next.Prev = node
    this.Head.Next = node
}

func (this *LinkedList) remove(node *Node){
    node.Prev.Next = node.Next
    node.Next.Prev = node.Prev
    node.Prev = nil
    node.Next = nil
}

type Node struct {
    Key int
    Value int
    Next *Node
    Prev *Node
} 


func Constructor(capacity int) LRUCache {
    head := &Node{
        Key: -1,
    }
    tail := &Node{
        Key: -1,
    }
    head.Next = tail
    tail.Prev = head
    queue := LinkedList{head, tail}
    return LRUCache{make(map[int]*Node), queue, capacity}
}


func (this *LRUCache) Get(key int) int {
    val, ok := this.Map[key]; 
    if !ok{
        return -1
    }
    this.Queue.moveToFront(val)
    return val.Value
}


func (this *LRUCache) Put(key int, value int)  {
    val, ok := this.Map[key]; 
    if ok{
        val.Value = value
        this.Queue.remove(val)
    }else{
        val = &Node{key, value, nil, nil}
        if this.Cap == len(this.Map){
            evict := this.Queue.removeLast()
            delete(this.Map, evict.Key)
        }
        this.Map[key] = val
    }
    this.Queue.add(val)
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */