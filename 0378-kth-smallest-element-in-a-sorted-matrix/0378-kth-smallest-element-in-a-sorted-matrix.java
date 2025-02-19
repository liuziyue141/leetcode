class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> matrix[a.x][a.y] - matrix[b.x][b.y]);
        pq.add(new Pair(0,0));
        Pair smallest = null;
        for(int i = 0; i < k; i++){
            smallest = pq.poll();
            boolean addFChild = true;
            boolean addSChild = true;
            if(smallest.x+1 >= matrix.length){
                addFChild = false;
            }
            if(smallest.y+1 >= matrix.length){
                addSChild = false;
            }
            for(Pair pair : pq){
                if(smallest.x+1 >= pair.x && smallest.y >= pair.y){
                    addFChild = false;
                }
                if(smallest.x >= pair.x && smallest.y+1 >= pair.y){
                    addSChild = false;
                }
            }

            if(addFChild){
                pq.add(new Pair(smallest.x+1, smallest.y));
            }
            if(addSChild){
                pq.add(new Pair(smallest.x, smallest.y+1));
            }
        }

        return matrix[smallest.x][smallest.y];
    }
}