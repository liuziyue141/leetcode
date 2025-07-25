class Solution {
    int[] dpSteal;
    int[] dpNotSteal;
    public int minCapability(int[] nums, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        dpSteal = new int[nums.length + 1];
        dpNotSteal = new int[nums.length + 1];
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
        dpSteal[0] = k;
        dpNotSteal[0] = k;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= mid){
                dpSteal[i + 1] = dpNotSteal[i] - 1;
            }else{
                dpSteal[i + 1] = dpSteal[i];
            }

            dpNotSteal[i + 1] = dpSteal[i];

            if(dpSteal[i+1] == 0){
                return true;
            }
        }
        return false;
    }
}