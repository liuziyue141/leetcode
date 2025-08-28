class Solution {
    public String decodeString(String s) {
        int k = 0;
        StringBuilder cur = new StringBuilder();
        Stack<Integer> istack = new Stack<>();
        Stack<String> cstack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                k = k * 10 + s.charAt(i) - '0';
            }
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                cur.append(s.charAt(i));
            }
            if(s.charAt(i) == '['){
                istack.push(k);
                cstack.push(cur.toString());
                cur.setLength(0);
                k = 0;
            }
            if(s.charAt(i) == ']'){
                String toreplicate = cur.toString();
                int cnt = istack.pop();
                for(int j = 1; j < cnt; j++){
                    cur.append(toreplicate);
                }
                cur.insert(0, cstack.pop());
            }
        }

        return cur.toString();
    }
}