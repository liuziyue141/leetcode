class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIdx = 0;
        for(int i = 0; i < citations.length; i++){
            hIdx = Math.max(hIdx, Math.min(citations.length - i, citations[i]));
        }
        return hIdx;
    }
}