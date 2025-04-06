class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();

        while(idx < words.length){
            int cur = idx + 1;
            int curLength = words[idx].length();
            while(cur < words.length && curLength + words[cur].length() + 1 <= maxWidth){
                curLength += 1 + words[cur].length();
                cur++;
            }
            int diff = maxWidth - curLength; 
            int wordCnt = cur - idx;
            int space = 0;
            int spaceRemainder = 0;
            // System.out.println(diff);
            // System.out.println(wordCnt);
            if(wordCnt-1>0){
                space = diff/(wordCnt-1);
                spaceRemainder = diff % (wordCnt-1);
            }else{
                space = diff;
            }
            // System.out.println(spaceRemainder);
            if(cur != words.length){
                sb.append(words[idx]);
                for(int i = idx + 1; i < cur; i++){
                    for(int j = 0; j <= space; j++){
                        sb.append(' ');
                    }
                    if(spaceRemainder>0){
                        spaceRemainder--;
                        sb.append(' ');
                    }
                    sb.append(words[i]);
                }

                if(wordCnt-1==0){
                    for(int j = 0; j < diff; j++){
                        sb.append(' ');
                    }
                }
            }else{
                sb.append(words[idx]);
                for(int i = idx + 1; i < cur; i++){
                    sb.append(' ');
                    sb.append(words[i]);
                }
                for(int i = 0; i < diff; i++){
                    sb.append(' ');
                }
            }
            
            idx = cur;
            res.add(sb.toString());
            sb.setLength(0);
        }
        return res;
    }
}