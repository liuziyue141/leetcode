class Solution {
    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] numStrArr = numStr.toCharArray();
        int max = 0;
        int[] count = new int[10];
        Arrays.fill(count, -1);
        for(int i = 0; i < numStr.length(); i++){
            int val = numStr.charAt(numStr.length() - i - 1) - '0';
            if (count[val] == -1){
                count[val] = numStr.length() - i - 1;
            }
            if (val > max){
                max = val;
            }
        }
        for(int i = 0; i < numStr.length(); i++){
            int val = numStrArr[i] - '0';
            if (val != max && i < count[max]){
                char temp = numStrArr[i];
                numStrArr[i] = (char)(max + '0');
                numStrArr[count[max]] = temp;
                return Integer.valueOf(new String(numStrArr));
            }else if (val == max && i == count[max]){
                for(int j = val - 1; j > 0; j--){
                    if(count[j] != -1 && count[j] > i){
                        max = j;
                        break;
                    }
                }
            }
        }
        return num;
    }
}