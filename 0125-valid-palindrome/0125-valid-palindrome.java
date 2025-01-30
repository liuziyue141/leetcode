class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        s = s.toLowerCase();
        while(l < r){
            while(l < r && !Character.isDigit(s.charAt(l)) && !Character.isLetter(s.charAt(l))){
                l++;
            }
            while(l < r && !Character.isDigit(s.charAt(r)) && !Character.isLetter(s.charAt(r))){
                r--;
            }
            if(l < r && s.charAt(l) != s.charAt(r)){
                // System.out.println();
                return false;
            }else{
                l++;
                r--;
            }
        }
        return true;
    }
}