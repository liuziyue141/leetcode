class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = (dividend > 0) ^ (divisor > 0)? -1 : 1;
        long quotient = 1;
        long dr = Math.abs((long)divisor);
        long dd = Math.abs((long)dividend);
        long originalDivisor = dr;
        while((dr << 1) < dd){
            dr = dr << 1;
            quotient = quotient << 1; 
        }
        long res = 0;
        while(dd >= originalDivisor){
            while(dr > dd){
                dr = dr >> 1;
                quotient = quotient >> 1;
            }
            res += quotient;
            dd = dd - dr;
        }

        return sign * (int)res; 
    }
}