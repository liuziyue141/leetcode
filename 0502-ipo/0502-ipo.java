class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // sort based on capital
        // priorityQueue <> add the (profits, capital pairs)
        int n = profits.length;
        // ArrayList<Project> projectList = new ArrayList<>();
        PriorityQueue<Project> capitalPq  = new PriorityQueue<>((Project a, Project b) -> {
            return a.capital - b.capital; // a.capital - b.capital ascending b.capital - a.capital descending
        });
        for(int i = 0; i < n; i++){
            capitalPq.add(new Project(profits[i], capital[i]));
        }

        PriorityQueue<Project> profitPq  = new PriorityQueue<>((Project a, Project b) -> {
            return b.profit - a.profit; // a.profit - b.profit minheap b.profit - a.profit maxheap
        });
        while(k>0){
            while(!capitalPq.isEmpty() && capitalPq.peek().capital <= w){
                profitPq.add(capitalPq.poll());
            }

            if(profitPq.isEmpty()){
                break;
            }
            w += profitPq.poll().profit;
            k--;
        }

        return w;
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