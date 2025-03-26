class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sCharMap = new HashMap<>();
        HashMap<Character, Character> tCharMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            

            if( (sCharMap.containsKey(s.charAt(i)) && sCharMap.get(s.charAt(i)) != t.charAt(i)) || 
            (tCharMap.containsKey(t.charAt(i)) && tCharMap.get(t.charAt(i)) != s.charAt(i))){
                return false;
            }
            sCharMap.put(s.charAt(i), t.charAt(i));
            tCharMap.put(t.charAt(i), s.charAt(i));
        }

        return true;



    }
}