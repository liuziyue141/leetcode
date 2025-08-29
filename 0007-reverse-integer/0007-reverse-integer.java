class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int res = 0;
        int sign = x < 0? -1:1;
        x = (int)Math.abs(x);
        while(x > 0){
            int digit = x % 10;
            if(sign == 1 && (res > max / 10 || (res == max/10 && digit > max%10))){
                return 0;
            }
            if(sign == -1 && (res > max / 10 || (res == max/10 && digit > max%10 + 1))){
                return 0;
            }
            res = res * 10 + digit;
            x/=10;
        }

        return sign * res;
    }
}