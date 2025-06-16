class Solution {
    public int calculate(String s) {
        int res = 0;
        int lastVal = 0;
        char lastOpt = '+';
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                i++;
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
                    res = res - lastVal;
                    lastVal = lastVal * num;
                    res += lastVal;
                }else if(lastOpt == '/'){
                    res = res - lastVal;
                    lastVal = lastVal / num;
                    res += lastVal;
                }else if(lastOpt == '-'){
                    lastVal = -num;
                    res += lastVal;
                }else{
                    lastVal = num;
                    res += num;
                }
            }
        }
        return res;
    }
}