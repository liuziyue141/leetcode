class Solution {
    public int myAtoi(String s) {
        long cur = 0;
        int isPositive = 1;
        boolean processedNum = false;
        int upbound = Integer.MAX_VALUE;
        int lowbound = Integer.MIN_VALUE;

        for(int i = 0; i < s.length(); i++){
            if(!processedNum && s.charAt(i) == '+'){
                isPositive = 1;
                processedNum = true;
            }else if(!processedNum && s.charAt(i) == '-'){
                isPositive = -1;
                processedNum = true;
            }else if(!processedNum && s.charAt(i) == ' '){
                continue;
            }else if(Character.isDigit(s.charAt(i))){
                processedNum = true;
                cur = cur * 10 + s.charAt(i) - '0';
                if(isPositive * cur > upbound){
                    return upbound;
                }
                if(isPositive * cur < lowbound){
                    return lowbound; 
                }
            }else{
                break;
            }
        }
        return (int)cur * isPositive;
    }
}