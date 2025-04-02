class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int count = countNeighbor(i, j, board);
                //board[i][j] = board[i][j]<<1;
                if(count == 3){
                    if(board[i][j] == 1){
                        board[i][j] = 4;
                    }else{
                        board[i][j] = 3;
                    }
                }
                else if(count == 2){
                    if(board[i][j] == 1){
                        board[i][j] = 4;
                    }else{
                        board[i][j] = 2;
                    }
                }
                else{
                    if(board[i][j] == 1){
                        board[i][j] = 5;
                    }else{
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 4 || board[i][j] == 3){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }

    public int countNeighbor(int row, int col, int[][] board){
        int cnt = 0;
        for(int i = row - 1; i <= row + 1; i++){
            for(int j = col - 1; j <= col + 1; j++){
                if((i==row && j == col) || i < 0 || i >= board.length || j < 0 || j >= board[0].length)
                    continue;
                if(board[i][j] == 5 || board[i][j] == 4 || board[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }
}