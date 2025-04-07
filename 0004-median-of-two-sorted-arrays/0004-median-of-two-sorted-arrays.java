class Solution {
    // Function to find the median of merged sorted arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length + nums2.length)%2 == 0){
            return ((double)medianHelper(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, (nums1.length + nums2.length)/2) + 
            (double)medianHelper(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, (nums1.length + nums2.length)/2 - 1))/2;
        }else{
            return (double) medianHelper(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1, (nums1.length + nums2.length)/2);
        }
    }

    public int medianHelper(int[] nums1, int[] nums2, int nums1Left, int nums1Right, int nums2Left, int nums2Right, int target){
        if(nums1Left > nums1Right){
            return nums2[target - nums1Left];
        }
        if(nums2Left > nums2Right){
            return nums1[target - nums2Left];
        }
        int num1Mid = (nums1Left + nums1Right)/2;
        int num2Mid = (nums2Left + nums2Right)/2;

        if(num1Mid + num2Mid < target){
            if(nums1[num1Mid] > nums2[num2Mid]){
                return medianHelper(nums1, nums2, nums1Left, nums1Right, num2Mid + 1, nums2Right, target);
            }else{
                return medianHelper(nums1, nums2, num1Mid + 1, nums1Right, nums2Left, nums2Right, target);
            }
        }else{
            if(nums1[num1Mid] > nums2[num2Mid]){
                return medianHelper(nums1, nums2, nums1Left, num1Mid - 1, nums2Left, nums2Right, target);
            }else{
                return medianHelper(nums1, nums2, nums1Left, nums1Right, nums2Left, num2Mid - 1, target);
            }
        }
    }
}