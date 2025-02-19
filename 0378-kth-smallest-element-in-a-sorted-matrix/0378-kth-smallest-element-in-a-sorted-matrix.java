class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public String toString(){
            return this.x + " " + this.y;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> matrix[a.x][a.y] - matrix[b.x][b.y]);
        HashSet<Pair> set = new HashSet<>();
        pq.add(new Pair(0,0));
        set.add(new Pair(0,0));
        Pair smallest = null;
        for(int i = 0; i < k; i++){
            smallest = pq.poll();
            if(smallest.x+1 < matrix.length && !set.contains(new Pair(smallest.x+1, smallest.y))){
                pq.add(new Pair(smallest.x+1, smallest.y));
                set.add(new Pair(smallest.x+1, smallest.y));
            }
            if(smallest.y+1 < matrix.length && !set.contains(new Pair(smallest.x, smallest.y+1))){
                pq.add(new Pair(smallest.x, smallest.y+1));
                set.add(new Pair(smallest.x, smallest.y+1));
            }
        }

        return matrix[smallest.x][smallest.y];
    }
}