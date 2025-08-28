class Solution {
    public String pushDominoes(String dominoes) {
        char[] sequence = dominoes.toCharArray();
        int lastRight = -1;
        int lastLeft = -1;
        for(int i = 0; i < sequence.length; i++){
            if(sequence[i] == 'R'){
                if(lastRight > lastLeft){
                    for(int j = lastRight + 1; j < i; j++){
                        sequence[j] = 'R';
                    }
                }
                lastRight = i;
            }
            if(sequence[i] == 'L'){
                if(lastLeft >= lastRight){
                    for(int j = lastLeft + 1; j < i; j++){
                        sequence[j] = 'L';
                    }
                }else{
                    int l = lastRight + 1;
                    int r = i - 1;
                    while(l < r){
                        sequence[l++] = 'R';
                        sequence[r--] = 'L';
                    }
                }
                lastLeft = i;
            }
        }

        if(lastRight > lastLeft){
            for(int i = lastRight + 1; i < sequence.length; i++){
                sequence[i] = 'R';
            }
        }
        return new String(sequence);
    }
}