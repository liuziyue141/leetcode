class Solution {
    public long distributeCandies(int n, int limit) {
        // enumerate the candy one child has retrieved
        // find the candy remaining
        // if remaining / 2 > limit --> 0
        // if remaining / 2 < limit & remaining <= limit --> remaining * 2 - (remaining + 1) %2
        // if remaining / 2 < limit & remaining > limit --> (limit - (remaining - limit)) * 2 - (remaining + 1) %2
        long sum = 0;
        
        for(int i = 0; i <= Math.min(n, limit); i++){
            int remaining = n - i;
            if((remaining + 1)/2 > limit){
                continue;
            }
            if(remaining <= limit){
                sum += remaining + 1;
            }else{
                sum += 2*limit - remaining + 1;
            }
        }

        return sum;
    }
}