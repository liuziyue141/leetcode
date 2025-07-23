class NumberContainers {
    HashMap<Integer, TreeSet<Integer>> valIdxMap;
    HashMap<Integer, Integer> idxValMap;
    public NumberContainers() {
        valIdxMap = new HashMap<>();
        idxValMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(idxValMap.containsKey(index)){
            int oldVal = idxValMap.get(index);
            valIdxMap.get(oldVal).remove(index);
        }
        idxValMap.put(index, number);
        valIdxMap.putIfAbsent(number, new TreeSet<>());
        valIdxMap.get(number).add(index);
    }
    
    public int find(int number) {
        if(!valIdxMap.containsKey(number)){
            return -1;
        }
        TreeSet<Integer> set = valIdxMap.get(number);
        if(set.isEmpty()){
            return -1;
        }
        return set.getFirst();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */