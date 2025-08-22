class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            String transformed = transform(s);
            map.putIfAbsent(transformed, new ArrayList<>());
            map.get(transformed).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public String transform(String s){
        int rightShift = 'z' - s.charAt(0) + 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append((char)((s.charAt(i) + rightShift)%26 + 'a'));
        }
        return sb.toString();
    }
}