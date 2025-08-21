class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), s, 0, 0);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder sb, String s, int idx, int cnt){
        
        if(cnt == 4){
            if(idx == s.length()){
                sb.deleteCharAt(sb.length()-1);
                res.add(sb.toString());
                sb.append('.');
            }
            return;
        }
        for(int i = idx + 1; i <= s.length() && i <= idx + 3; i++){
            String sub = s.substring(idx, i);
            if( validSubString(sub)){
                int val = Integer.valueOf(sub);
                sb.append(val);
                sb.append('.');
                backtrack(res, sb, s, i, cnt+1);
                sb.delete(sb.length() - i + idx - 1, sb.length());
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