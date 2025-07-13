class Solution {
    public String reorganizeString(String s) {
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }

        int max = 0;
        for(int i = 0; i < 26; i++){
            max = Math.max(cnt[i], max);
        }

        if (max > (s.length() + 1)/2){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int last = -1; 
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            int maxCnt = 0;
            for(int j = 0; j < 26; j++){
                if(j != last && cnt[j] > maxCnt){
                    maxCnt = Math.max(maxCnt, cnt[j]);
                    idx = j;
                }
            }
            cnt[idx]--;
            last = idx;
            sb.append((char) (idx+ 'a'));
        }

        return sb.toString();
    }
}