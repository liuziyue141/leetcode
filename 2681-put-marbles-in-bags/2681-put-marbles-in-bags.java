class Solution {
    public long putMarbles(int[] weights, int k) {
        // 
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < weights.length - 1; i++){
            minpq.offer(weights[i] + weights[i+1]);
            maxpq.offer(weights[i] + weights[i+1]);
        }

        long maxS = 0;
        long minS = 0;
        for(int i = 0; i < k - 1; i++){
            maxS += maxpq.poll();
            minS += minpq.poll();
        }

        return maxS - minS;

    }
}