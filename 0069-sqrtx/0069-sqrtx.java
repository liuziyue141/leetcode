class Solution {
    public int mySqrt(int x) {
        int right = 46340;
        int left = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid * mid > x){
                right = mid - 1;
            }else if(mid * mid == x){
                return mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}