func minSubArrayLen(target int, nums []int) int {
    left := 0;
    right := 0;
    sum := 0;
    length := len(nums) + 1
    for right < len(nums){
        sum = sum + nums[right]
        right = right + 1
        for sum - nums[left] >= target {
            sum = sum - nums[left]
            left = left + 1
        }
        if sum >= target {
            length = min(right - left, length)
        }
    }
    if length == len(nums) + 1 {
        return 0
    }
    return length
}