import ("container/list")

type Value struct {
    key int
    value int 
}

type LRUCache struct {
    Map map[int]*list.Element
    Queue *list.List
    Cap int
}

func Constructor(capacity int) LRUCache {
    return LRUCache{make(map[int]*list.Element), list.New(), capacity}
}


func (this *LRUCache) Get(key int) int {
    elem, ok := this.Map[key]; 
    if !ok{
        return -1
    }
    this.Queue.MoveToFront(elem)
    return elem.Value.(*Value).value
}


func (this *LRUCache) Put(key int, value int)  {
    elem, ok := this.Map[key]; 
    if ok{
        elem.Value.(*Value).value = value
        this.Queue.MoveToFront(elem)
    }else{
        val := &Value{
            key: key, 
            value: value,
        }
        if this.Cap == len(this.Map){
            evict := this.Queue.Remove(this.Queue.Back())
            delete(this.Map, evict.(*Value).key)
        }
        this.Queue.PushFront(val)
        this.Map[key] = this.Queue.Front()
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */