class Solution {
    int sum = 0;
    int[] w;
    Random r;
    public Solution(int[] w) {
        this.w = new int[w.length];
        this.r = new Random();
        for (int i = 0; i < this.w.length; i++){
            this.sum += w[i];
            this.w[i] = this.sum;
        }
        
    }
    
    public int pickIndex() {
        int pickVal = this.r.nextInt(this.sum);
        int left = 0;
        int right = this.w.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(this.w[mid] > pickVal){
                right = mid;
            }else{
                left = mid + 1; 
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */