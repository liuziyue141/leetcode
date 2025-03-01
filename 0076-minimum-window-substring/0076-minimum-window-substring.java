class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> curFreq = new HashMap<>();
        Map<Character, Integer> targetFreq = new HashMap<>();
        Set<Character> need2Visited = new HashSet<>();

        for(int i = 0; i < t.length(); i++){
            int freq = targetFreq.getOrDefault(t.charAt(i), 0);
            targetFreq.put(t.charAt(i), freq + 1);
            need2Visited.add(t.charAt(i));
        }


        //sliding window
        int left = 0;
        int right = 0;
        String res = "";
        int len = Integer.MAX_VALUE;
        while(right < s.length()){
            while(right < s.length() && !need2Visited.isEmpty()){
                Character cur = s.charAt(right);
                if(targetFreq.containsKey(cur)){
                    int freq = curFreq.getOrDefault(cur, 0);
                    curFreq.put(cur, freq + 1);
                    if(freq + 1 == targetFreq.get(cur)){
                        need2Visited.remove(cur);
                    }
                }
                right++;
            }
            if(need2Visited.isEmpty()){
                while(left < right){
                    Character cur = s.charAt(left);
                    if(targetFreq.containsKey(cur)){
                        int freq = curFreq.get(cur);
                        if(freq <= targetFreq.get(cur)){
                            if(need2Visited.isEmpty()){
                                if(right - left < len){
                                    res = s.substring(left, right);
                                    len = right - left;
                                }
                                need2Visited.add(cur);
                            }else{
                                break;
                            }   
                        }
                        curFreq.put(cur, freq - 1); 
                    }
                    left++;
                }
            }
        }
        return res;
    }
}