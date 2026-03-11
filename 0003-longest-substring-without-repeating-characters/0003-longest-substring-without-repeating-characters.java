class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < s.length()){
            Character c = s.charAt(right);
            if(set.contains(c)){
                while(left < right){
                    set.remove(s.charAt(left));
                    left++;
                    if(s.charAt(left - 1) == c){
                        break;
                    }
                }
            }
            set.add(s.charAt(right));
            right++;
            res = Math.max(right - left, res);
        }
        return res;
    }
}