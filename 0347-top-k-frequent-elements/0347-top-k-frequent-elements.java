class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Element> map = new HashMap<Integer, Element>();
        for(int i = 0; i<nums.length; i++){
            Element e = map.getOrDefault(nums[i], new Element(nums[i]));
            e.frequency = e.frequency + 1;
            map.put(nums[i], e);
        }
        
        PriorityQueue<Element> pq = new PriorityQueue<Element>((Element a, Element b) -> {
            return a.frequency - b.frequency;
        });
        for(Element entry: map.values()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll().value;
        }
        return res;
    }

    class Element{
        int value;
        int frequency;
        public Element(int value){
            this.value = value;
            this.frequency = 0;
        }
    }
}