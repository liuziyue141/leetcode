class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int idx = 0;
        while(idx < v1.length || idx < v2.length){
            int v1Revision = 0;
            int v2Revision = 0;
            if(idx < v1.length){
                int i = 0;
                while(i < v1[idx].length() && v1[idx].charAt(i) == '0'){
                    i++;
                }
                if(i < v1[idx].length())
                v1Revision = Integer.parseInt(v1[idx].substring(i));
            }
            if(idx < v2.length){
                int i = 0;
                while(i < v2[idx].length() && v2[idx].charAt(i) == '0'){
                    i++;
                }
                if(i < v2[idx].length())
                v2Revision = Integer.parseInt(v2[idx].substring(i));
            }
            if(v1Revision > v2Revision){
                return 1;
            }
            if(v1Revision < v2Revision){
                return -1; 
            }
            idx++;
        }
        return 0;
    }
}