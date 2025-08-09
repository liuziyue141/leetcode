class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (int[] a, int[] b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });

        PriorityQueue<Integer> endDates = new PriorityQueue<>();

        int maxDay = Integer.MIN_VALUE;
        for(int i = 0; i < events.length; i++){
            maxDay = Math.max(maxDay, events[i][1]);
        }
        int cnt = 0;
        int j = 0;


        for(int i = 0; i <= maxDay; i++){
            //add all events we can attend
            while(j < events.length && events[j][0] <= i){
                endDates.add(events[j][1]);
                j++;
            }

            //removed expired event
            while(!endDates.isEmpty() && endDates.peek() < i){
                endDates.poll();
            }

            if(!endDates.isEmpty()){
                endDates.poll();
                cnt++;
            }
        }
        return cnt;
    }
}