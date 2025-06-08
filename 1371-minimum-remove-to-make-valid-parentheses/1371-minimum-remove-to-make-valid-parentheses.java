class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> toRemove = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                if(stack.empty()){
                    toRemove.add(i);
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.empty()){
            toRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if (!toRemove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}