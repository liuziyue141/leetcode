class Solution {
    public String pushDominoes(String dominoes) {
        char[] sequence = dominoes.toCharArray();
        int start = 0;
        for(int i = 0; i < sequence.length; i++){
            if(sequence[i] == 'L'){
                for(int j = start; j < i; j++){
                    sequence[j] = 'L';
                }
                start = i + 1;
            }
            if(sequence[i] == 'R'){
                int idxR = i;
                while(i < sequence.length && sequence[i] != 'L'){
                    if(sequence[i] == 'R'){
                        while(idxR < i){
                            sequence[idxR] = 'R';
                            idxR++;
                        }
                    }
                    i++;
                }
                if(i == sequence.length){
                    while(idxR < i){
                        sequence[idxR] = 'R';
                        idxR++;
                    }
                }else{
                    int idxL = i;
                    start = i + 1;
                    while(idxL > idxR){
                        sequence[idxL] = 'L';
                        sequence[idxR] = 'R';
                        idxL--;
                        idxR++;
                    }
                }
            }
        }
        return new String(sequence);
    }
}