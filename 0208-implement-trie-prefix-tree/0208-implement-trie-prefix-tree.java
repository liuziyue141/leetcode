class Trie {
    Node root;
    public Trie() {
        root = new Node(false);
    }
    
    public void insert(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(cur.child[idx] == null){
                cur.child[idx] = new Node(false);
            }
            cur = cur.child[idx];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i)-'a';
            if(cur.child[idx]==null){
                return false;
            }
            cur = cur.child[idx];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i)-'a';
            if(cur.child[idx]==null){
                return false;
            }
            cur = cur.child[idx];
        }
        return true;
    }
    
}

class Node{
    Node[] child;
    boolean isWord;
    public Node(boolean isWord){
        child = new Node[26];
        this.isWord = isWord;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */