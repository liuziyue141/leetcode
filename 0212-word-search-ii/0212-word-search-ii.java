class Solution {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    class Node {
        boolean isWord;
        Node[] childs;
        public Node (){
            childs = new Node[26];
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        Node root = new Node();
        for(String w : words){
            Node cur = root;
            for(int i = 0; i < w.length(); i++){
                if(cur.childs[w.charAt(i) - 'a'] == null){
                    cur.childs[w.charAt(i) - 'a'] = new Node();
                }
                cur = cur.childs[w.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }
        
        dfs(res,visited, board, root);
        return res;
    }

    public void dfs(List<String> res, boolean[][] visited, char[][] board, Node root){
        StringBuilder st = new StringBuilder();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(root.childs[board[i][j] - 'a']!= null){
                    explore(root.childs[board[i][j] - 'a'], board, visited, i, j, res, st);
                }
            }
        }
    }

    public void explore(Node root, char[][] board, boolean[][] visited, int x, int y, List<String> res, StringBuilder cur){
        visited[x][y] = true;
        cur.append(board[x][y]);
        if(root.isWord){
            root.isWord = false;
            res.add(cur.toString());
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < board.length && nx >= 0 && ny < board[0].length && ny >= 0 
                && !visited[nx][ny] &&  root.childs[board[nx][ny] - 'a']!= null){
                explore(root.childs[board[nx][ny] - 'a'], board, visited, nx, ny, res, cur);
            }
        }
        visited[x][y] = false;
        cur.deleteCharAt(cur.length()-1);
    }
}
