class Solution {
    public int compress(char[] chars) {
        int slow = 0;
        int fast = 0;
        Stack<Character> stack = new Stack<>();
        while(fast < chars.length){
            int cnt = 1;
            while(fast + 1 < chars.length && chars[fast + 1] == chars[fast]){
                fast++;
                cnt++;
            }
            chars[slow++] = chars[fast];
            if(cnt > 1){
                while(cnt > 0){
                    stack.push((char)(cnt % 10 + '0'));
                    cnt /= 10;
                }

                while(!stack.isEmpty()){
                    chars[slow++] = stack.pop();
                }
            }
            fast++;
        }
        return slow;
    }
}