class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort the balloons based on their end coordinates
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int arrows = 0;
        int prevEnd = Integer.MAX_VALUE;
        
        // Count the number of non-overlapping intervals
        for (int i = 0; i < points.length; i++) {
            prevEnd = Math.min(prevEnd, points[i][1]);
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1];
            }
        }
        
        return arrows + 1;
    }
}