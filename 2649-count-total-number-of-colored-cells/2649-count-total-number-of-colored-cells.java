class Solution {
    public long coloredCells(int n) {
        // sum of 2*(n-1)
        return 1-4*n+4*(long)(n+1)*n/2;
    }
}