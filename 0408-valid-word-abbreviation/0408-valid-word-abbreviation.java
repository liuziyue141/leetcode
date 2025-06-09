class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx = 0;
        int curLen = 0;
        for(int i = 0; i < abbr.length(); i++){
            if (abbr.charAt(i)-'0' >= 0 && abbr.charAt(i) - '0' <= 9){
                curLen = curLen * 10 + abbr.charAt(i)- '0';
                if (curLen == 0){
                    return false;
                }
                if (idx + curLen > word.length()){
                    return false;
                }
            }else{
                if(curLen != 0){
                    idx = idx + curLen;
                    curLen = 0;
                }
                if (idx >= word.length()){
                    return false;
                }
                if (abbr.charAt(i) != word.charAt(idx)){
                    return false;
                }
                idx++;
            }
        }
        return idx + curLen == word.length();
    }
}