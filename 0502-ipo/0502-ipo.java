class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // sort based on capital
        // priorityQueue <> add the (profits, capital pairs )
        int n = profits.length;
        ArrayList<Project> projectList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            projectList.add(new Project(profits[i], capital[i]));
        }
        Collections.sort(projectList, (Project a, Project b) -> {
            return a.capital - b.capital;
        });

        PriorityQueue<Project> pq  = new PriorityQueue<>((Project a, Project b) -> {
            return b.profit - a.profit;
        });
        int curCapital = w;
        int idx = 0;
        while(k>0){
            while(idx < n && projectList.get(idx).capital <= curCapital){
                pq.add(projectList.get(idx));
                idx++;
            }

            if(pq.isEmpty()){
                break;
            }
            Project p= pq.poll();
            curCapital += p.profit;
            k--;
        }

        return curCapital;
    }   
}

class Project {
    int profit;
    int capital;
    public Project(int profit, int capital){
        this.profit = profit;
        this.capital = capital;
    }
}