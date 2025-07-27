class Solution {
    public int maxDifference(String s, int k) {
        int max = Integer.MIN_VALUE;
        for(int a = 0; a <= 4; a++){
            for(int b = 0; b <= 4; b++){
                if(a == b){
                    continue;
                }

                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int aCnt = 0;
                int bCnt = 0;
                int pACnt = 0; // previous count
                int pBCnt = 0;
                int prevPos = -1;
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) - '0' == a){
                        aCnt++;
                    }
                    if(s.charAt(i) - '0' == b){
                        bCnt++;
                    }

                    while(i - prevPos >= k && bCnt - pBCnt >= 2){
                        int status = getStatus(pACnt, pBCnt);
                        best[status] = Math.min(best[status], pACnt - pBCnt);
                        prevPos++;
                        if(s.charAt(prevPos) - '0' == a){
                            pACnt++;
                        }
                        if(s.charAt(prevPos) - '0' == b){
                            pBCnt++;
                        }
                    }

                    int status = getStatus(aCnt, bCnt);
                    int targetStatus = 2 ^ status;
                    if(best[targetStatus] != Integer.MAX_VALUE){
                        max = Math.max(max, aCnt - bCnt - best[targetStatus]);
                    }
                }
            }
        }

        return max;
    }

    public int getStatus(int aCnt, int bCnt){
        return (aCnt%2)<<1|bCnt%2;
    }
}