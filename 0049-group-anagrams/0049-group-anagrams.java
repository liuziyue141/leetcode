class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] strCharArr = strs[i].toCharArray();
            Arrays.sort(strCharArr);
            String sortedStr = new String(strCharArr);
            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramMap.get(sortedStr).add(strs[i]);
        }
        List<List<String>> anagramList = new ArrayList<>();
        for(List<String> anagram : anagramMap.values()){
            anagramList.add(anagram);
        }
        return anagramList;
    }
}