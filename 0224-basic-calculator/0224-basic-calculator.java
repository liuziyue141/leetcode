class Solution {
    public int calculate(String s) {
        int cur = 0;
        int sign = 1;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
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
                stack.push(res);
                stack.push(sign);
                cur = 0;
                res = 0;
                sign = 1;
            }else if (c == ')'){
                res = res + sign * cur;
                res = res * stack.pop() + stack.pop();
                cur = 0;
                sign = 1;
            }
        }
        return res + sign * cur;
    }
}