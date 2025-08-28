class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for(int i = 1; i < numRows; i++){
            List<Integer> curlevel = new ArrayList<>();
            List<Integer> prev = res.get(i-1);
            curlevel.add(1);
            for(int j = 1; j < i; j++){
                int val = prev.get(j-1) + prev.get(j);
                curlevel.add(val);
            }
            curlevel.add(1);
            res.add(curlevel);
        }
        return res; 
    }
}