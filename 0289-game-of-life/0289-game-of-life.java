class Solution {
    public void gameOfLife(int[][] board) {
        int[] prev = new int[board[0].length];
        int[] cur = new int[board[0].length];
        // for(int i = 0; i < board[0].length; i++){
        //     cur[i] = board[0].length;
        // }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int cnt = prev[j];
                if(j > 0){
                    cnt = cnt + prev[j-1] + cur[j-1];
                }
                if(j<board[0].length - 1){
                    cnt = cnt + prev[j+1] + board[i][j+1];
                }
                if(i<board.length - 1){
                    cnt += board[i+1][j];
                }
                if(i<board.length - 1 && j<board[0].length - 1){
                    cnt += board[i+1][j + 1];
                }
                if(i<board.length - 1 && j>0){
                    cnt += board[i+1][j-1];
                }
                cur[j] = board[i][j];

                // System.out.println(i + " " + j + " " + cnt);

                if(cnt < 2){
                    board[i][j] = 0;
                }
                if(cnt == 3){
                    board[i][j] = 1;
                }
                if(cnt > 3){
                    board[i][j] = 0;
                }
            }

            for(int j = 0; j < board[0].length; j++){
                prev[j] = cur[j];
            }
            // System.out.println(Arrays.toString(prev));
        }
    }
}