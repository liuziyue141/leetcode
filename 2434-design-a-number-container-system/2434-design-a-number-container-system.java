class NumberContainers {
    HashMap<Integer, PriorityQueue<Integer>> valIdxMap;
    HashMap<Integer, Integer> idxValMap;
    public NumberContainers() {
        valIdxMap = new HashMap<>();
        idxValMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        idxValMap.put(index, number);
        valIdxMap.putIfAbsent(number, new PriorityQueue<>());
        valIdxMap.get(number).add(index);
    }
    
    public int find(int number) {
        if(!valIdxMap.containsKey(number)){
            return -1;
        }
        PriorityQueue<Integer> pq = valIdxMap.get(number);
        while(!pq.isEmpty() && idxValMap.get(pq.peek()) != number){
            pq.poll();
        }
        if(pq.isEmpty()){
            valIdxMap.remove(number);
            return -1;
        }else{
            return pq.peek();
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */