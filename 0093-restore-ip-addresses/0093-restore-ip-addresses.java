class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0, 0);
        return res;
    }

    public void backtrack(List<String> res, List<String> cur, String s, int idx, int cnt){
        
        if(cnt == 4){
            if(idx == s.length()){
                res.add(String.join(".", cur));
            }
            return;
        }
        for(int i = idx + 1; i <= s.length() && i <= idx + 3; i++){
            String sub = s.substring(idx, i);
            if( validSubString(sub)){
                cur.add(sub);
                backtrack(res, cur, s, i, cnt+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    public boolean validSubString(String s){
        if(s.charAt(0) == '0'){
            if(s.length() == 1){
                return true;
            }else{
                return false;
            }
        }

        if(Integer.valueOf(s) <= 255){
            return true;
        }
        return false;
    }
}