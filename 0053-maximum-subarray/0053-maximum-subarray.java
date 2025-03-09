class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
        
    }

    public int maxSubArray(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int mid = (start+end)/2;
        int leftmax = maxSubArray(nums, start, mid);
        int rightmax = maxSubArray(nums, mid+1, end);
        int middle = nums[mid] + nums[mid + 1];
        int rightCur = 0;
        int rightMax = 0;
        for(int i = mid + 2; i <= end; i++){
            rightCur += nums[i];
            rightMax = Math.max(rightMax, rightCur);
        }
        int leftCur = 0;
        int leftMax = 0;
        for(int i = mid - 1; i >= start; i--){
            leftCur += nums[i];
            leftMax = Math.max(leftMax, leftCur);
        }

        middle = middle + rightMax + leftMax;
        return Math.max(middle, Math.max(leftmax, rightmax));
    }
}