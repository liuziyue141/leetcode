class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int idx = digits.length - 1;
        while(carry == 1 && idx >= 0){
            carry = (digits[idx] + 1)/10;
            digits[idx] = (digits[idx] + 1)%10;
            idx--;
        }

        if(carry != 1){
            return digits;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}