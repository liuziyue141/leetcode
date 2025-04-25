func solve(board [][]byte)  {
    m := len(board)
    n := len(board[0])

    for i := 0; i < n; i++{
        if board[0][i] == byte('O'){
            dfs(board, 0, i)
        }
    }
    for i := 0; i < n; i++{
        if board[m-1][i] == byte('O'){
            dfs(board, m-1, i)
        }
    }

    for i := 1; i < m-1; i++{
        if board[i][0] == byte('O'){
            dfs(board, i, 0)
        }
    }

    for i := 1; i < m-1; i++{
        if board[i][n-1] == byte('O'){
            dfs(board, i, n-1)
        }
    }

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++{
            if board[i][j] == byte('V'){
                board[i][j] = byte('O')
            }else {
                board[i][j] = byte('X')
            }
        }
    }
}

func dfs(board [][]byte, r int, c int){
    board[r][c] = byte('V')
    dx := []int{0, 0, 1, -1}
    dy := []int{1, -1, 0, 0}
    for i := 0; i < len(dx); i++{
        x := r + dx[i]
        y := c + dy[i]
        if x >= 0 && x < len(board) && y >= 0 && y < len(board[0]) && board[x][y] == byte('O'){
            dfs(board, x, y)
        }
    }
}