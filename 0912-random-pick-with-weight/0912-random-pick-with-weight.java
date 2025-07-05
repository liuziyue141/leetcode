class Solution {
    int sum = 0;
    int[] w;
    public Solution(int[] w) {
        this.w = new int[w.length];
        for (int i = 0; i < this.w.length; i++){
            this.sum += w[i];
            this.w[i] = this.sum;
        }
        
    }
    
    public int pickIndex() {
        Random r = new Random();
        int pickVal = r.nextInt(this.sum);
        int left = 0;
        int right = this.w.length;
        while(left < right){
            int mid = (left + right)/2;
            if(this.w[mid] > pickVal){
                right = mid;
            }else if(this.w[mid] < pickVal){
                left = mid + 1; 
            }else{
                return mid + 1; 
            }
        }
        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */