class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        HashSet<String> visited = new HashSet<>();
        List<String> queue = new ArrayList<>();
        int cnt = 1;
        HashMap<String, List<String>> map = new HashMap<>();
        int wordLength = beginWord.length();

        for(String word : wordList){
            char[] charArr = word.toCharArray();
            for(int i = 0; i < wordLength; i++){
                charArr[i] = '*';
                String newWord = new String(charArr);
                List<String> list = map.getOrDefault(newWord, new ArrayList<>());
                list.add(word);
                map.put(newWord, list);
                charArr[i] = word.charAt(i);
            }
        }
        // System.out.println(map);
        queue.add(beginWord);
        visited.add(beginWord);
        while(! (queue.size() == 0)){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.removeFirst();
                // System.out.println(cur);
                // System.out.println(cnt);
                if(cur.equals(endWord)){
                    return cnt;
                }
                char[] charArr = cur.toCharArray();
                for(int j = 0; j < wordLength; j++){
                    charArr[j] = '*';
                    for(String n : map.getOrDefault(new String(charArr), new ArrayList<>())){
                        if(visited.contains(n)){
                            continue;
                        }
                        queue.add(n);
                        visited.add(n);
                    }
                    charArr[j] = cur.charAt(j);
                }
            }
            cnt++;
        }
        return 0;
    }
}