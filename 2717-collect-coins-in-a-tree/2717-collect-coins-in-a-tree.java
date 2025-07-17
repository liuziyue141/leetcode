class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int totalEdge = 2 * edges.length;
        int removedEdge = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        // use breadth-first search to remove all the leaf with no leafs
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() == 1 && coins[entry.getKey()] == 0){
                q.add(entry.getKey());
            }
        }
        // remove the node and the parent's node using breadth first search
        while(!q.isEmpty()){
            int cur = q.poll();
            if(map.get(cur).size() == 0){
                continue;
            }
            int neighbor = map.get(cur).iterator().next();
            map.get(cur).remove(neighbor);
            map.get(neighbor).remove(cur);
            if(map.get(neighbor).size() == 1 && coins[neighbor] == 0){
                q.add(neighbor);
            }
            removedEdge += 2;
        }

        // use breadth first search to remove at most 2 edges 
        // for each leaf node
        // if the parent node has one child
        // remove the parent node

        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            if(entry.getValue().size() == 1){
                q.add(entry.getKey());
            }
        }
        int step = 2;
        while(step > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                if(map.get(cur).size() == 0){
                    continue;
                }
                int neighbor = map.get(cur).iterator().next();
                map.get(cur).remove(neighbor);
                map.get(neighbor).remove(cur);
                if(map.get(neighbor).size() == 1){
                    q.add(neighbor);
                }
                removedEdge += 2;
            }
            step--;
        }
        return totalEdge - removedEdge;
    }
}