class MovingAverage {
    LinkedList<Integer> list;
    int cap;
    int sum;
    public MovingAverage(int size) {
        list = new LinkedList<>();
        cap = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if(list.size() == cap){
            sum -= list.pop();
        }
        list.add(val);
        sum+=val;
        return (double) (sum) / list.size();
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */