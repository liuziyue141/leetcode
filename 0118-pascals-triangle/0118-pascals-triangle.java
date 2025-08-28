class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        for(int i = 1; i < numRows; i++){
            int[] curlevel = new int[i+1];
            List<Integer> prev = res.get(i-1);
            curlevel[0] = 1;
            curlevel[i] = 1;
            for(int j = 1; j < i; j++){
                int val = prev.get(j-1) + prev.get(j);
                curlevel[j] = val;
            }
            res.add(Arrays.stream(curlevel).boxed().collect(Collectors.toList()));
        }
        return res; 
    }
}