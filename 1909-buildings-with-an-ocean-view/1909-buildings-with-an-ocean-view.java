class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for(int i = heights.length - 1; i >= 0; i--){
            if (heights[i] > max){
                res.add(i);
                max = heights[i];
            }
        }

        int[] result = new int[res.size()];
        res = res.reversed();
        for(int i = res.size() - 1; i >= 0; i--){
            result[i] = res.get(i);
        }
        return result;
    }
}