type LRUCache struct {
    Map map[int]*Node
    Queue LinkedList
    Cap int
}

type LinkedList struct {
    Head *Node
    Tail *Node
}

func (this *LinkedList) removeLast() *Node{
    oldTail := this.Tail
    if this.Tail == this.Head{
        this.Tail = nil
        this.Head = nil
        oldTail.Next = nil
        oldTail.Prev = nil
        return oldTail
    }
    newTail := this.Tail.Prev
    this.Tail = newTail
    oldTail.Next = nil
    oldTail.Prev = nil
    return oldTail
}

func (this *LinkedList) add(node *Node){
    node.Next = this.Head
    if this.Head != nil{
        this.Head.Prev = node
    }
    if this.Tail == nil{
        this.Tail = node
    }
    this.Head = node
}

func (this *LinkedList) remove(node *Node){
    if node.Prev != nil{
        node.Prev.Next = node.Next
    }
    if node.Next != nil{
        node.Next.Prev = node.Prev
    }
    if node == this.Tail{
        this.Tail = node.Prev
    }
    if node == this.Head{
        this.Head = node.Next
    }
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
    queue := LinkedList{nil, nil}
    return LRUCache{make(map[int]*Node), queue, capacity}
}


func (this *LRUCache) Get(key int) int {
    val, ok := this.Map[key]
    if !ok{
        return -1
    }
    this.Queue.remove(val)
    this.Queue.add(val)
    return val.Value
}


func (this *LRUCache) Put(key int, value int)  {
    val, ok := this.Map[key]
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