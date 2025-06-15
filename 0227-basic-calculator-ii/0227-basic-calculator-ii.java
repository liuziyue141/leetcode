class Solution {
    public int calculate(String s) {
        Stack<Integer> nStack = new Stack<>();
        char lastOpt = '+';
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                i++;
                continue;
            }
            else if(!Character.isDigit(s.charAt(i))){
                lastOpt = s.charAt(i);
                i++;
            }else{
                int num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (int)(s.charAt(i) - '0');
                    i++;
                }

                if (lastOpt == '*'){
                    num = nStack.pop() * num;
                }else if(lastOpt == '/'){
                    num = nStack.pop() / num;
                }else if(lastOpt == '-'){
                    num = -num;
                }
                nStack.push(num);
            }
        }
        int res = 0;
        while(!nStack.isEmpty()){
            res += nStack.pop();
        }
        return res;
    }

    public int evaluate(int a, int b, char opt){
        if (opt == '+'){
            return a + b;
        }else if (opt == '-'){
            return a - b;
        }else if (opt == '*'){
            return a * b;
        }else{
            return a / b;
        }
    }
}