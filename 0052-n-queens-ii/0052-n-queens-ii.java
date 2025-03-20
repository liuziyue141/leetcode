class Solution {
    int res = 0;
    Set<Integer> cols;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    public int totalNQueens(int n) {
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();
        cols = new HashSet<>();
        totalNQueens(0, n);
        return res;
    }

    public void totalNQueens(int row, int n){
        if(row == n){
            res = res + 1;
            return;
        }
        for(int col = 0; col < n; col++){
            if(!cols.contains(col) && !posDiag.contains(row + col) && !negDiag.contains(row - col)){
                cols.add(col);
                posDiag.add(row + col);
                negDiag.add(row - col);
                totalNQueens(row + 1, n);
                cols.remove(col);
                posDiag.remove(row + col);
                negDiag.remove(row - col);
            }
        }
    }
}