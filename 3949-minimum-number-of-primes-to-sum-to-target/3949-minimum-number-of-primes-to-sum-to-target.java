class Solution {
    public int minNumberOfPrimes(int n, int m) {
        List<Integer> primeList = findPrimeUnder(n, m);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = primeList.size() - 1; j >= 0; j--){
                int curP = primeList.get(j);
                if(curP > i){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - curP] + 1);
            }
        }

        return dp[n] == 100000 ? -1 : dp[n];
    }

    public List<Integer> findPrimeUnder(int n, int m){
        int upperBound = (int)Math.floor(Math.sqrt(n));
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i <= upperBound; i++){
            if(isPrime[i]){
                int start = i * i;
                while(start <= n){
                    isPrime[start] = false;
                    start += i;
                }
            }
        }
        List<Integer> res = new ArrayList<>();

        for(int i =2; i <= n; i++){
            if(isPrime[i]){
                res.add(i);
            }
            if(res.size() == m){
                break;
            }
        }
        return res;
    }
}