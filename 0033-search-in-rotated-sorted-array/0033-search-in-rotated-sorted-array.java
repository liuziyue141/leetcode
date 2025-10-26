class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            // compare nums[mid] with nums[r]
            if(nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        int k = l;


        l = 0;
        r = nums.length - 1;

        while(l <= r){
            int mid = l + (r - l)/2;
            int midVal = nums[(mid + k)%nums.length];
            if(midVal == target){
                return (mid + k)%nums.length;
            }else if(midVal < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return -1;
    }
}