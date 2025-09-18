class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()){
            if(set.contains(s.charAt(right))){
                while(left < right && s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            set.add(s.charAt(right));
            right++;
            length = Math.max(length, right - left);
        }
        return length;
    }
}