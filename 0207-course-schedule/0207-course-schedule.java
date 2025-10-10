class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int canTake = 0;
        List<List<Integer>> edge = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            edge.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] preq : prerequisites){
            int a = preq[0];
            int b = preq[1];
            edge.get(b).add(a);
            indegree[a]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
                canTake++;
            }
        }


        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<Integer> outgoing = edge.get(cur);
            for(int node : outgoing){
                indegree[node]--;
                if(indegree[node] == 0){
                    queue.add(node);
                    canTake++;
                }
            }
        }

        return canTake == numCourses;
    }
}