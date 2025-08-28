


class Solution {
    public int minOperations(int n) {
        int totalOpts = 0;
        while(n > 0){
            if((n & 3) == 3){
                totalOpts++;
                n++;
                //n = n >> 2;
            }else{
                totalOpts += (n & 1);
                n = n >> 1;
            }
        }

        return totalOpts;
    }
}