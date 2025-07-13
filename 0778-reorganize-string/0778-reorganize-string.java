class Solution {
    public String reorganizeString(String s) {
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }

        int max = 0;
        int maxIdx = 0;
        for(int i = 0; i < 26; i++){
            if (max < cnt[i]){
                max = cnt[i];
                maxIdx = i;
            }
        }

        if (max > (s.length() + 1)/2){
            return "";
        }

        int idx = 0;
        char[] array = new char[s.length()];
        for(int i = 0; i < cnt[maxIdx]; i++){
            array[idx] = (char)(maxIdx + 'a');
            idx += 2;
        }
        cnt[maxIdx] = 0;
        int writeCnt = max;
        int i = 0;
        while(writeCnt < s.length()){
            while(cnt[i] == 0){
                i++;
            }
            if(idx >= s.length()){
                idx = 1;
            }
            array[idx] = (char)(i + 'a');
            idx += 2;
            cnt[i]--;
            writeCnt++;
        }
        return new String(array);
    }
}