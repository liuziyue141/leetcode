class Solution {
    public int calculate(String s) {
        int[] calRes = calculateHelper(s, 0);
        return calRes[0];
    }

    public int[] calculateHelper(String s, int start){
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> optStack = new Stack<>();
        int cur = 0; 
        for(int i = start; i < s.length(); i++){
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || 
            s.charAt(i) == '*' || s.charAt(i) == '/'){
                numStack.push(cur);
                optStack.push(s.charAt(i));
                cur = 0; 
            }else if(s.charAt(i) == '('){
                int[] resVal = calculateHelper(s, i+1);
                cur = resVal[0];
                i = resVal[1];
            }else if(s.charAt(i) == ')'){
                numStack.push(cur);
                return new int[]{calculate(numStack, optStack), i};
            }else{
                cur = cur * 10 + s.charAt(i) - '0';
            }
        }
        numStack.push(cur);
        return new int[]{calculate(numStack, optStack), s.length()};
    }

    public int calculate(Stack<Integer> numStack, Stack<Character> optStack){
        Stack<Integer> rNumStack = new Stack<>();
        Stack<Character> rOptStack = new Stack<>();

        while(!numStack.isEmpty()){
            rNumStack.push(numStack.pop());
        }
        while(!optStack.isEmpty()){
            rOptStack.push(optStack.pop());
        }
        Stack<Integer> res = new Stack<>();
        int sign = 1;
        int cur = rNumStack.pop();
        while(!rOptStack.isEmpty()){
            char opt = rOptStack.pop();
            if(opt == '+'){
                res.push(sign * cur);
                sign = 1;
                cur = rNumStack.pop();
            }else if(opt == '-'){
                res.push(sign * cur);
                sign = -1;
                cur = rNumStack.pop();
            }else if(opt == '*'){
                cur = cur * rNumStack.pop();
            }else if(opt == '/'){
                cur = cur / rNumStack.pop();
            }
        }
        res.push(sign * cur);
        int sum = 0;
        while(!res.isEmpty()){
            int val = res.pop();
            sum += val;
        }
        return sum;
    }
}