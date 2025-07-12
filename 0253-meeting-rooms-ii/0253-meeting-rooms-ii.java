class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int cnt = 0;
        Arrays.sort(intervals, (int[] a, int[] b) ->  a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < intervals.length; i++){
            int[] curInterval = intervals[i];
            while(!pq.isEmpty() && pq.peek() <= curInterval[0]){
                pq.poll();
            }
            pq.add(curInterval[1]);
            cnt = Math.max(cnt, pq.size());
        }
        return cnt;
    }
}