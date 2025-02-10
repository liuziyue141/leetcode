class WordDictionary {

    Node root;

    class Node{
        boolean isWord;
        Node[] child;

        public Node(boolean isWord){
            this.isWord = isWord;
            this.child = new Node[26];
        }
    }
    public WordDictionary() {
        root = new Node(false);
    }
    
    public void addWord(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            if(cur.child[word.charAt(i)-'a']==null){
                cur.child[word.charAt(i)-'a'] = new Node(false);
            }
            cur = cur.child[word.charAt(i)-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, Node root){
        Node cur = root;
        while(index < word.length() && word.charAt(index) != '.'){
            if(cur.child[word.charAt(index)-'a']==null){
                return false;
            }
            cur = cur.child[word.charAt(index) - 'a'];
            index++;
        }
        if(index == word.length()){
            return cur.isWord;
        }else{
            for(int i = 0; i < 26; i++){
                if(cur.child[i] != null && dfs(word, index + 1, cur.child[i])){
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */