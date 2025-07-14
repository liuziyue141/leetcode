class RandomizedSet {
    List<Integer> randomList;
    Map<Integer, Integer> idxMap;
    Random r;
    int end = 0;
    public RandomizedSet() {
        idxMap = new HashMap<>();
        randomList = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(idxMap.containsKey(val)){
            return false;
        }
        if(end == randomList.size()){
            randomList.add(val);
        }else{
            randomList.set(end, val);
        }
        idxMap.put(val, end);
        end = end + 1;
        return true;
    }
    
    public boolean remove(int val) {
        if(!idxMap.containsKey(val)){
            return false;
        }
        int idx = idxMap.get(val);
        if(idx != end - 1){
            randomList.set(idx, randomList.get(end - 1));
            idxMap.put(randomList.get(end - 1), idx);
        }
        idxMap.remove(val);
        end = end - 1;
        return true;
    }
    
    public int getRandom() {
        int randomInt = r.nextInt(0, end);
        return randomList.get(randomInt);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */