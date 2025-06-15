class SparseVector {
    int[] nums;
    SparseVector(int[] nums) {
        this.nums = Arrays.copyOf(nums, nums.length);
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        for(int i = 0; i < vec.nums.length; i++){
            product += vec.nums[i] * this.nums[i];
        }
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);