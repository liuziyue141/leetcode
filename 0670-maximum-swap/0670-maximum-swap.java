class Solution {

    // // suboptimal approach
    // public int maximumSwap(int num) {
    //     String numStr = String.valueOf(num);
    //     char[] numStrArr = numStr.toCharArray();
    //     int max = 0;
    //     int[] lastseen = new int[10];
    //     for(int i = 0; i < numStr.length(); i++){
    //         lastseen[(int)(numStrArr[i] - '0')] = i;
    //     }
    //     for(int i = 0; i < numStr.length(); i++){
    //         int val = numStrArr[i] - '0';
    //         if (val != max && i < lastseen[max]){
    //             char temp = numStrArr[i];
    //             numStrArr[i] = (char)(max + '0');
    //             numStrArr[lastseen[max]] = temp;
    //             return Integer.valueOf(new String(numStrArr));
    //         }else if (val == max && i == lastseen[max]){
    //             for(int j = val - 1; j > 0; j--){
    //                 if(lastseen[j] != -1 && lastseen[j] > i){
    //                     max = j;
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     return num;
    // }


    // two-pass approach
    public int maximumSwap(int num) {
        char[] numStrArr = String.valueOf(num).toCharArray();
        int n = numStrArr.length;
        int[] rightMaxIndex = new int[n];
        rightMaxIndex[n - 1] = n - 1;
        for(int i = 1; i < n; i++){
            char cur = numStrArr[n - i - 1];
            if(numStrArr[rightMaxIndex[n - i]] >= cur){
                rightMaxIndex[n - i - 1] = rightMaxIndex[n - i];
            }else{
                rightMaxIndex[n - i - 1] = n - i - 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(numStrArr[i] < numStrArr[rightMaxIndex[i]]){
                char temp = numStrArr[i];
                numStrArr[i] = numStrArr[rightMaxIndex[i]];
                numStrArr[rightMaxIndex[i]] = temp;
                return Integer.valueOf(new String(numStrArr));
            }
        }
        return num;
    }
}