class Solution {
    // detect DAG
    // topological sort use bfs and in-degree

    public String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> n = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        Set<Character> nodeSet = new HashSet<>();
        for(char i = 'a'; i <= 'z'; i++){
            n.put(i, new HashSet<>());
            indegree.put(i, 0);
        }
        for(int i = 0; i < words[0].length(); i++){
            nodeSet.add(words[0].charAt(i));
        }
        // set up graph
        for(int i = 1; i < words.length; i++){
            int j = 0;
            if(words[i].equals(words[i-1])){
                continue;
            }
            if(words[i-1].startsWith(words[i])){
                return "";
            }
            while(j < words[i-1].length() && words[i-1].charAt(j) == words[i].charAt(j)){
                j++;
            }
            if(j < words[i-1].length()){
                char from = words[i-1].charAt(j);
                char to = words[i].charAt(j);
                if(!n.get(from).contains(to)){
                    n.get(from).add(to);
                    indegree.put(to, indegree.get(to) + 1);
                }
            }
            while(j < words[i].length()){
                nodeSet.add(words[i].charAt(j));
                j++;
            }
        }
        LinkedList<Character> q = new LinkedList<>();
        for(Character node : nodeSet){
            if(indegree.get(node)==0){
                q.add(node);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char cur = q.poll();
            sb.append(cur);
            Set<Character> neighbor = n.get(cur);
            for(char node : neighbor){
                indegree.put(node, indegree.get(node) - 1);
                if(indegree.get(node) == 0){
                    q.add(node);
                }
            }
        }

        if(sb.length() != nodeSet.size()){
            return "";
        }else{
            return sb.toString();
        }
    }
}