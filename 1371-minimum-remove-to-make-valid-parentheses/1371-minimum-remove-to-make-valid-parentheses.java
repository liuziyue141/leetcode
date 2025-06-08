class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> pStack = new Stack<>();
        Stack<String> wStack = new Stack<>();
        wStack.push("");
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                pStack.push('(');
                wStack.push("");
            }else if (s.charAt(i) == ')'){
                if(!pStack.empty()){
                    pStack.pop();
                    String newStr = "(" + wStack.pop() + ")";
                    String last = "";
                    wStack.push(wStack.pop() + newStr);
                }
            }else{
                String oldStr = wStack.pop();
                wStack.push(oldStr + s.charAt(i));
            }
        }
        String res = "";
        while(!wStack.empty()){
            res = wStack.pop() + res;
        }
        return res;
    }
}