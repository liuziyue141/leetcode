class MaxStack {
    LLElement head;
    LLElement tail;
    TreeSet<TSElement> set; 
    int id;
    public MaxStack() {
        // ascending order
        set = new TreeSet<>((TSElement a, TSElement b) -> {
            if (a.val == b.val){
                return a.id - b.id;
            }
            return a.val - b.val;
        });
    }
    
    public void push(int x) {
        LLElement lln = new LLElement(x, null, null, null);
        TSElement tsn = new TSElement(x, id, lln);
        id++;
        lln.ts = tsn;
        if(head == null){
            head = lln;
            tail = lln;
        }else{
            tail.r = lln;
            lln.l = tail;
            tail = lln;
        }
        set.add(tsn);
    }
    
    public int pop() {
        LLElement toremove = tail;
        if (tail == head){
            tail = null;
            head = null;
        }else{
            tail = toremove.l;
            tail.r = null;
            toremove.l = null;
        }
        set.remove(toremove.ts);
        return toremove.val;
    }
    
    public int top() {
        return tail.val;
    }
    
    public int peekMax() {
        return set.last().val;
    }
    
    public int popMax() {
        TSElement toremove = set.pollLast();
        LLElement lltoremove = toremove.ll;
        if (head == tail){
            head = null;
            tail = null;
        }
        else if (head == lltoremove){
            head = lltoremove.r;
            lltoremove.r = null;
            head.l = null;
        }else if (tail == lltoremove){
            tail = lltoremove.l;
            lltoremove.l = null;
            tail.r = null;
        }else{
            lltoremove.l.r = lltoremove.r;
            lltoremove.r.l = lltoremove.l;
            lltoremove.l = null;
            lltoremove.r = null;
        }
        return lltoremove.val;
    }
}

// element for the link list
class LLElement{
    int val;
    LLElement l;
    LLElement r;
    TSElement ts;
    public LLElement(int val, LLElement l, LLElement r, TSElement ts){
        this.val = val;
        this.l = l;
        this.r = r;
        this.ts = ts;
    }
}

class TSElement{
    int val;
    int id;
    LLElement ll;

    public TSElement(int val, int id, LLElement ll){
        this.val = val;
        this.id = id;
        this.ll = ll;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */