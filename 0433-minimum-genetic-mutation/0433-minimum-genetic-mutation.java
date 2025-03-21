class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)){
            return 0;
        }
        char[] elements = new char[]{'A', 'C', 'G', 'T'};
        Deque<String> geneQueue = new ArrayDeque<>();
        Set<String> bankSet = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < bank.length; i++){
            bankSet.add(bank[i]);
        }
        geneQueue.addLast(startGene);
        seen.add(startGene);
        int cnt = 0;

        while(!geneQueue.isEmpty()){
            int size = geneQueue.size();
            for(int i = 0; i < size; i++){
                StringBuilder cur = new StringBuilder(geneQueue.removeFirst());
                if(endGene.equals(cur.toString())){
                    return cnt;
                }
                for(int j = 0; j < 8; j++){
                    char old = cur.charAt(j);
                    for(char elem : elements){
                        cur.setCharAt(j, elem);
                        if(!seen.contains(cur.toString()) && bankSet.contains(cur.toString())){
                            seen.add(cur.toString());
                            geneQueue.addLast(cur.toString());
                        }
                    }
                    cur.setCharAt(j, old);
                }
            }
            cnt++;
        }
        return -1;
    }
}