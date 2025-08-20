class Solution {
    public boolean checkPowersOfThree(int n) {
        int last = n;
        int cur = (int)(Math.log(n) / Math.log(3));
        while(cur < last){
            // System.out.println(cur);
            // System.out.println(n);
            last = cur;
            n = n - (int)Math.pow(3, cur);
            if(n == 0){
                return true;
            }
            cur = (int)(Math.log(n) / Math.log(3)+0.0001);

        }
        return false;
    }
}