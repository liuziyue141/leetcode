class Solution {
    public boolean checkPowersOfThree(int n) {
        int factor = 1;
        while(factor <= n){
            factor *= 3;
        }
        while(factor >= 1){
            if(n >= factor){
                n = n - factor;
                if(n == 0){
                    return true;
                }
                if(n >= factor){
                    return false;
                }
            }
            factor /= 3;
        }

        return false;
        
    }
}