class Solution {
    public int brightestPosition(int[][] lights) {
        Arrays.sort(lights, (int[] a, int[] b) -> {
            return a[0] - a[1] - b[0] + b[1];
        });
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        int idx = Integer.MIN_VALUE;
        for(int i = 0; i < lights.length; i++){
            int[] l = lights[i];
            while(!heap.isEmpty() && heap.peek() < l[0] - l[1]){
                heap.poll();
            }
            heap.offer(l[0] + l[1]);
            if(heap.size() > max){
                max = heap.size();
                idx = l[0] - l[1];
            }
        }
        return idx;
    }
}