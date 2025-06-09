class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while(i < word.length() && j < abbr.length()){
            if(!Character.isDigit(abbr.charAt(j))){
                if(word.charAt(i) != abbr.charAt(j)){
                    return false;
                }
                i++;
                j++;
            }
            int len = 0;
            while(j < abbr.length() && Character.isDigit(abbr.charAt(j))){
                if(len == 0 && abbr.charAt(j) == '0'){
                    return false;
                }
                len = len * 10 + abbr.charAt(j) - '0';
                j++;
            }
            i = i + len;
        }
        return i == word.length() && j == abbr.length();
    }
}