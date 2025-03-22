class Solution {
    int i = 0;
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        boolean numStart = false;
        int numStartIdx = 0;
        int numEndIdx = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == ' '){
                i++;
                continue;
            }

            // handle multiple digits
            else if(isDigit(c)){
                if(!numStart){
                    numStartIdx = i;
                    numStart = true;
                }

                if(i==s.length()-1 || !isDigit(s.charAt(i+1))){
                    numEndIdx = i + 1;
                    numStart = false;
                    numStack.push(Integer.valueOf(s.substring(numStartIdx, numEndIdx)));
                    if(!charStack.isEmpty()){
                        char opt = charStack.pop();
                        int b = numStack.pop();
                        int a = numStack.pop();

                        numStack.push(evaluate(a, b, opt));
                    }
                }
            }

            else if(c == '('){
                i++;
                numStack.push(calculate(s));
                if(!charStack.isEmpty()){
                    char opt = charStack.pop();
                    int b = numStack.pop();
                    int a = numStack.pop();
                    numStack.push(evaluate(a, b, opt));
                }
            }else if (c == ')'){
                return numStack.peek();
            }else{
                if(c == '-'){
                    if(numStack.isEmpty()){
                        numStack.push(0);
                    }
                }

                charStack.push(c);
            }
            i++;
        }
        return numStack.peek();
    }
    public boolean isDigit (char c){
        return c <= '9' && c >= '0';
    }

    public int evaluate (int a, int b, char opt){
        if (opt == '-'){
            return a-b;
        }else{
            return a+b;
        }
    }
}