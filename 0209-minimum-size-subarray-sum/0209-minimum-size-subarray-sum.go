func minSubArrayLen(target int, nums []int) int {
    left := 0
    right := 0
    sum := 0
    maxInt := int(^uint(0) >> 1)
    length := maxInt
    for right < len(nums){
        sum = sum + nums[right]
        right++
        for sum - nums[left]>= target {
            sum = sum - nums[left]
            left++
        }
        if sum >= target{
            length = min(length, right - left)
        }
    }
    if length == maxInt {
        return 0
    }
    return length
}