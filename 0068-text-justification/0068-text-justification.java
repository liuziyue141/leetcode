class Solution {
    public String createSpace(int num){
        String space = "";
        for(int i = 0; i < num; i++){
            space += " ";
        }
        return space;
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        int idx = 0;
        int length = 0;
        int wordCnt = 0;
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();

        while(idx < words.length){
            if (length + words[idx].length() + wordCnt > maxWidth){
                int spaceBetween = (maxWidth - length)/Math.max(1, wordCnt - 1);
                int spaceRemainder = (maxWidth - length)%Math.max(1, wordCnt - 1);
                sb.append(words[idx - wordCnt]);
                for(int i = idx - wordCnt + 1; i < idx; i++){
                    int space = spaceBetween;
                    if(spaceRemainder > 0){
                        space++;
                        spaceRemainder--;
                    }
                    sb.append(createSpace(space));
                    sb.append(words[i]);
                }
                if(wordCnt == 1){
                    sb.append(createSpace(spaceBetween));
                }
                res.add(sb.toString());
                sb.setLength(0);
                length = 0;
                wordCnt = 0;
            }
            wordCnt++;
            length += words[idx].length();
            idx++;
        }
        sb.append(words[words.length - wordCnt]);
        for(int i = words.length - wordCnt + 1; i < words.length; i++){
            sb.append(' ');
            sb.append(words[i]);
        }
        int trailingSpace = maxWidth - sb.length();
        sb.append(createSpace(trailingSpace));
        res.add(sb.toString());
        return res;
    }
}