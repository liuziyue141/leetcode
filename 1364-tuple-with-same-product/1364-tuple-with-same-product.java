class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productMap = new HashMap<>();
        if(nums.length < 4){
            return 0;
        }
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                productMap.put(nums[i]*nums[j], productMap.getOrDefault(nums[i]*nums[j], 0) + 1);
            }
        }
        int total = 0;
        for(int cnt : productMap.values()){
            if(cnt >= 2){
                total += 8 * cnt * (cnt - 1) / 2;
            }
        }
        return total;
    }
}