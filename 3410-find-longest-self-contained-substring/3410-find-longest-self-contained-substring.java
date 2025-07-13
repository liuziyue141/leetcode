class Solution {
    public int maxSubstringLength(String s) {
        int[] start = new int[26];
        int[] end = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        for(int i = 0; i < s.length(); i++){
            if(start[s.charAt(i) - 'a'] == -1){
                start[s.charAt(i) - 'a'] = i;
            }
            end[s.charAt(i) - 'a'] = i;
        }

        int max = -1;
        for(int i = 0; i < 26; i++){
            if(start[i] == -1){
                continue;
            }
            int curEnd = end[i];
            for(int j = start[i]; j < s.length(); j++){
                if(start[s.charAt(j) - 'a'] < start[i]){
                    break;
                }
                if(end[s.charAt(j) - 'a'] > curEnd){
                    curEnd = end[s.charAt(j) - 'a'];
                }
                if(curEnd == j && curEnd - start[i] + 1 != s.length()){
                    max = Math.max(max, curEnd - start[i] + 1);
                }
            }
        }

        return max;
    }
}