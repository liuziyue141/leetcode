class Solution {
    public String minWindow(String s, String t) {
        int[] curFreq = new int[128];
        int[] targetFreq = new int[128];
        int have = 0;
        int need = 0;
        for(int i = 0; i < t.length(); i++){
            if(targetFreq[t.charAt(i)]==0){
                need++;
            }
            targetFreq[t.charAt(i)]++;
        }

        //sliding window
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int[] res = new int[2];
        while(right < s.length()){
            curFreq[s.charAt(right)]++;
            if(curFreq[s.charAt(right)] == targetFreq[s.charAt(right)]){
                have++;
            }
            while(have == need){
                curFreq[s.charAt(left)]--;
                if(curFreq[s.charAt(left)] < targetFreq[s.charAt(left)]){
                    have--;
                    if(right - left + 1 < len){
                        res[0] = left;
                        res[1] = right;
                        len = right - left + 1;
                    }
                }
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE? "" : s.substring(res[0], res[1] + 1);
    }
}