class Solution {
    public int minCapability(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        while(min < max){
            int mid = min + (max - min)/2;
            boolean isPossible = check(nums, k, mid);
            if(isPossible){
                max = mid;
            }else{
                min = mid + 1; 
            }
        }
        return min;
    }

    public boolean check(int[] nums, int k, int mid){        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= mid){
                k--;
                i++;
            }

            if(k == 0){
                return true;
            }
        }
        return false;
    }
}