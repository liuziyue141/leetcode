class MovingAverage {
    LinkedList<Integer> list;
    int cap;
    int size;
    int sum;
    public MovingAverage(int size) {
        list = new LinkedList<>();
        cap = size;
        this.size = 0;
        this.sum = 0;
    }
    
    public double next(int val) {
        if(size == cap){
            size--;
            sum -= list.pop();
        }
        list.add(val);
        sum+=val;
        size++;
        return (double) (sum) / size;
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */