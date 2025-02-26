class Solution {
    public int minimumSum(int n, int k) {
        HashSet<Integer> s = new HashSet<>();
        int cnt = 0;
        int num = 1;
        for(int i = 0; i < n; i++){
            while(s.contains(k-num)){
                num++;
            }
            s.add(num);
            cnt += num;
            num++;
        }
        return cnt;
    }
}