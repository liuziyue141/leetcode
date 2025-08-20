class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int max = 0;
        long total = 0;
        for(int i = 0; i < damage.length; i++){
            max = Math.max(damage[i], max);
            total += damage[i];
        }
        total -= Math.min(max, armor);
        return total + 1;
    }
}