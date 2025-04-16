class Solution {
    // public int hIndex(int[] citations) {
    //     Arrays.sort(citations);
    //     int hIdx = 0;
    //     for(int i = 0; i < citations.length; i++){
    //         hIdx = Math.max(hIdx, Math.min(citations.length - i, citations[i]));
    //     }
    //     return hIdx;
    // }
    // count sort
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for(int i = 0; i < citations.length; i++){
            count[Math.min(citations[i], citations.length)]++;
        }
        int hIdx = 0;
        int numPaper = 0;
        for(int i = count.length - 1; i >= 0; i--){
            numPaper += count[i];
            hIdx = Math.max(Math.min(i, numPaper), hIdx);
        }
        return hIdx;
    }
}