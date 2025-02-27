class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int MOD = (int)1e9+7;
        long sum = 0;
        int n = nums.length;
        long p = 1;
        for(int i = 0; i < n; i++){
            sum = (sum + p * nums[i] - p * nums[n-i-1])%MOD;
            p = (p<<1)%MOD;
        }
        return (int)((sum+MOD)%MOD);
    }
}