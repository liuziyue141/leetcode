class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> curFreq = new HashMap<>();
        Map<Character, Integer> targetFreq = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            int freq = targetFreq.getOrDefault(t.charAt(i), 0);
            targetFreq.put(t.charAt(i), freq + 1);
            curFreq.put(t.charAt(i), 0);
        }

        int need = targetFreq.keySet().size();
        int have = 0;

        //sliding window
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int[] res = new int[2];
        while(right < s.length()){
            Character cur = s.charAt(right);
            if(targetFreq.containsKey(cur)){
                int freq = curFreq.get(cur);
                curFreq.put(cur, freq + 1);
                if(freq + 1 == targetFreq.get(cur)){
                    have++;
                }
            }

            while(have == need){
                if(right - left + 1 < len){
                    res[0] = left;
                    res[1] = right;
                    len = right - left + 1;
                }
                cur = s.charAt(left);
                if(targetFreq.containsKey(cur)){
                    int freq = curFreq.get(cur);
                    curFreq.put(cur, freq - 1);
                    if(targetFreq.get(cur) > curFreq.get(cur)){
                        have--;
                    }
                }
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE? "" : s.substring(res[0], res[1] + 1);
    }
}