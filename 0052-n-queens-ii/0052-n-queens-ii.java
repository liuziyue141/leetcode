class Solution {
    int res = 0;
    Set<Integer> cols;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    public int totalNQueens(int n) {
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();
        cols = new HashSet<>();
        totalNQueens(0, 0, n);
        return res;
    }

    public void totalNQueens(int row, int col, int n){
        if(col == n){
            return;
        }
        if(row == n){
            res = res + 1;
            return;
        }
        if(!cols.contains(col) && !posDiag.contains(row + col) && !negDiag.contains(row - col)){
            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);
            totalNQueens(row + 1, 0, n);
            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
        }
        totalNQueens(row, col + 1, n);
    }

    public boolean validPos(List<int[]> positions, int row, int col){
        for(int[] position : positions){
            if(Math.abs(position[0] - row) == Math.abs(position[1] - col) || position[0] == row || position[1] == col){
                return false;
            }
        }

        return true;
    }
}