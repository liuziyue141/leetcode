class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int i = 0; i < piles.length; i++){
            right = Math.max(right, piles[i]);
        }

        while(left < right){
            int mid = left + (right - left) / 2;
            int time = 0;
            for(int pile : piles){
                time += pile / mid;
                if(pile % mid != 0){
                    time++;
                }
            }

            if(time > h){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}