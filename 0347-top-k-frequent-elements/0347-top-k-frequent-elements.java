class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Element> map = new HashMap<Integer, Element>();
        for(int i = 0; i<nums.length; i++){
            Element e = map.getOrDefault(nums[i], new Element(nums[i]));
            e.frequency = e.frequency + 1;
            map.put(nums[i], e);
        }
        List<Element> list = new ArrayList<>(map.values());
        quickSelect(map.size() - k, list, 0, map.size() - 1);
        int[] res = new int[k];
        int idx = 0;
        for(int i = map.size() - k; i < map.size(); i++){
            res[idx] = list.get(i).value;
            idx++;
        }
        return res;
    }

    public void quickSelect(int k, List<Element> list, int start, int end){
        int pivot = end;
        int cur = start;
        int pivotVal = list.get(pivot).frequency;
        for(int i = start; i <= end; i++){
            if(list.get(i).frequency < pivotVal){
                Element temp = list.get(i);
                list.set(i, list.get(cur));
                list.set(cur, temp);
                cur++;
            }
        }
        Element temp = list.get(cur);
        list.set(cur, list.get(pivot));
        list.set(pivot, temp);

        if(cur == k){
            return;
        }else if(cur > k){
            quickSelect(k, list, start, cur - 1);
        }else{
            quickSelect(k, list, cur + 1, end);
        }
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