class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorCnt = new HashMap<>();
        HashMap<Integer, Integer> colorMap = new HashMap<>();
        int[] res = new int[queries.length];
        int totalColor = 0;
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            if(colorMap.containsKey(query[0])){
                int cnt = colorCnt.get(colorMap.get(query[0])) - 1;
                if(cnt == 0){
                    totalColor--;
                }
                colorCnt.put(colorMap.get(query[0]), cnt);
            }

            int cnt = colorCnt.getOrDefault(query[1], 0);
            if(cnt == 0){
                totalColor++;
            }
            colorCnt.put(query[1], cnt + 1);
            colorMap.put(query[0], query[1]);
            res[i] = totalColor;
        }
        return res;
    }
}