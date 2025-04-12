class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
            freq.put(magazine.charAt(i), freq.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++){
            int cur = freq.getOrDefault(ransomNote.charAt(i), 0);
            if(cur == 0){
                return false;
            }
            freq.put(ransomNote.charAt(i), cur - 1);
        }
        return true;
    }
}