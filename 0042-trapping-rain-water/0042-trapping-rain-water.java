class Solution {
    public int trap(int[] height) {
        int[] rightMax = new int[height.length];
        int[] leftMax = new int[height.length];
        for(int i = 1; i < leftMax.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }
        for(int i = rightMax.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }
        int res = 0;
        for(int i = 1; i < height.length - 1; i++){
            res = res + Math.max((Math.min(leftMax[i], rightMax[i]) - height[i]), 0);
        }
        return res;
    }
}