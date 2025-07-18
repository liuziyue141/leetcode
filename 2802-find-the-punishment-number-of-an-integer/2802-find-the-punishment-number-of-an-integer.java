class Solution {
    public int punishmentNumber(int n) {
        // partition("10000", 100);
        // return 0;
        int sum = 0;
        for(int i = 0; i <= n; i++){
            if(partition(String.valueOf(i*i), i)){
                sum += i * i;
            }
        }
        return sum;
    
    }

    public boolean partition(String n, int target){
        if(target < 0){
            return false;
        }
        // strip zero
        int idx = 0;
        while(idx < n.length() && n.charAt(idx) == 0){
            idx++;
        }
        if(idx == n.length()){
            return target == 0;
        }else{
            n = n.substring(idx);
        }
        // upperbound
        for(int i = 0; i < Math.min(n.length(), 4); i++){
            if(i == n.length() - 1){
                return Integer.valueOf(n) == target;
            }
            int curVal = Integer.valueOf(n.substring(0, i+1));
            if(partition(n.substring(i+1), target - curVal)){
                return true;
            }
        }
        return false;
    }
}