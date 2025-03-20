class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        totalNQueens(0, 0, n, new ArrayList<>());
        return res;
    }

    public void totalNQueens(int row, int col, int n, List<int[]> positions){
        if(col == n){
            return;
        }
        if(row == n){
            res = res + 1;
            return;
        }
        if(validPos(positions, row, col)){
            positions.add(new int[]{row, col});
            totalNQueens(row + 1, 0, n, positions);
            positions.remove(positions.size()-1);
        }
        totalNQueens(row, col + 1, n, positions);
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