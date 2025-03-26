class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> sCharMap = new HashMap<>();
        HashMap<Character, Integer> tCharMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            
            int sLastOccurrence = sCharMap.getOrDefault(s.charAt(i), -1);
            int tLastOccurrence = tCharMap.getOrDefault(t.charAt(i), -1);
            if(sLastOccurrence == tLastOccurrence){
                sCharMap.put(s.charAt(i), i);
                tCharMap.put(t.charAt(i), i);
            }else{
                return false;
            }
        }

        return true;



    }
}