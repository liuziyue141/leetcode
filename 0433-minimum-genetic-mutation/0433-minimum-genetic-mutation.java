class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)){
            return 0;
        }
        Deque<String> geneQueue = new ArrayDeque<>();
        boolean[] visited = new boolean[bank.length];
        geneQueue.addLast(startGene);
        int cnt = 0;
        while(!geneQueue.isEmpty()){
            int size = geneQueue.size();
            for(int i = 0; i < size; i++){
                String cur = geneQueue.removeFirst();
                if(cur.equals(endGene)){
                    return cnt;
                }
                for(int j = 0; j < bank.length; j++){
                    if(visited[j]){
                        continue;
                    }
                    if(isNeighbor(bank[j], cur)){
                        visited[j] = true;
                        geneQueue.addLast(bank[j]);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public boolean isNeighbor(String target, String source){
        int cnt = 0;
        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) != source.charAt(i)){
                cnt++;
                if(cnt > 1){
                    return false;
                }
            }
        }
        return cnt==1; 
    }
}