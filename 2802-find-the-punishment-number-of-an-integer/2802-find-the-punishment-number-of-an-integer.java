class Solution {
    public int punishmentNumber(int n) {
        // partition("10000", 100);
        // return 0;
        int sum = 0;
        for(int i = 0; i <= n; i++){
            if(canPartition(i*i, i)){
                sum += i * i;
            }
        }
        return sum;
    
    }

    public boolean canPartition(int num, int target) {
        // Invalid partition found
        if (target < 0 || num < target) {
            return false;
        }

        // Valid partition found
        if (num == target) {
            return true;
        }

        // Recursively check all partitions for a valid partition
        return (
            canPartition(num / 10, target - (num % 10)) ||
            canPartition(num / 100, target - (num % 100)) ||
            canPartition(num / 1000, target - (num % 1000))
        );
    }
}