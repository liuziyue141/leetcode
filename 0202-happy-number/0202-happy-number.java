class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(n!=1 && !set.contains(n)){
            set.add(n);
            int newN = 0;
            while(n>0){
                newN += (n%10)*(n%10);
                n/=10;
            }
            n = newN;

        }

        return n==1;
    }
}