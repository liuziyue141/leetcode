class Solution {
    int i = 0;
    public int calculate(String s) {
        int cur = 0;
        int sign = 1;
        int res = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                cur = cur * 10 + c - '0';
            }else if(c == '-'){
                res = res + sign * cur;
                cur = 0;
                sign = -1;
            }else if( c == '+'){
                res = res + sign * cur;
                cur = 0;
                sign = 1;
            }else if(c == '('){
                i++;
                cur = calculate(s);
            }else if (c == ')'){
                return res + sign * cur;
            }
            i++;
        }
        return res + sign * cur;
    }
}