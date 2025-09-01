class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            int cnt = freqMap.getOrDefault(t.charAt(i), 0) + 1;
            freqMap.put(t.charAt(i), cnt);
        }
        int size = freqMap.size();

        int left = 0;
        int right = 0;
        String res = "";
        int curSize = Integer.MAX_VALUE;
        while(right < s.length()){
            if(freqMap.containsKey(s.charAt(right))){
                int freq = freqMap.get(s.charAt(right))-1;
                if(freq == 0){
                    size--;
                }
                freqMap.put(s.charAt(right), freq);
            }
            if(size == 0){
                while(size == 0){
                    if(freqMap.containsKey(s.charAt(left))){
                        int freq = freqMap.get(s.charAt(left));
                        if(freq == 0){
                            size++;
                        }
                        freqMap.put(s.charAt(left), freq + 1);
                    }
                    left++;
                }
                if(curSize > right - left + 2){
                    res = s.substring(left - 1, right + 1);
                    curSize = right - left + 2;
                }
            }
            right++;

        }
        return res;
    }
}