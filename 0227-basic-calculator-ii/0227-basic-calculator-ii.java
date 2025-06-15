class Solution {
    public int calculate(String s) {
        List<Integer> nStack = new ArrayList<>();
        List<Character> oStack = new ArrayList<>();

        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                i++;
                continue;
            }
            if(!Character.isDigit(s.charAt(i))){
                oStack.add(s.charAt(i));
                i++;
                continue;
            }
            int num = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                num = num * 10 + (int)(s.charAt(i) - '0');
                i++;
            }

            if (!oStack.isEmpty() && (oStack.getLast() == '*' || oStack.getLast() == '/')){
                num = evaluate(nStack.removeLast(), num, oStack.removeLast());
            }
            nStack.add(num);
        }
        int res = nStack.removeFirst();
        while(!oStack.isEmpty()){
            int b = nStack.removeFirst();
            char opt = oStack.removeFirst();

            res = evaluate(res, b, opt);
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