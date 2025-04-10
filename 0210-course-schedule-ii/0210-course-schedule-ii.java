class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] inorder = new int[numCourses];
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new HashSet<>());
        }

        for(int[] prereq : prerequisites){
            inorder[prereq[0]]++;
            graph.get(prereq[1]).add(prereq[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(inorder[i] == 0){
                queue.addLast(i);
            }
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while(!queue.isEmpty()){
            int cur = queue.removeFirst();
            res[idx] = cur;
            idx++;
            Set<Integer> neighbor = graph.get(cur);
            for(int n : neighbor){
                inorder[n]--;
                if(inorder[n] == 0){
                    queue.addLast(n);
                }
            }
            
        }
        if(idx==numCourses){
            return res;
        }else{
            return new int[0];
        }
    }
}