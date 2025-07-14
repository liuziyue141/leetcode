class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> taskStack = new Stack<>();
        int lastT = 0; // last timestamp
        for(String log : logs){
            String[] logArr = log.split(":");
            int curT = Integer.valueOf(logArr[2]);
            int id = Integer.valueOf(logArr[0]);
            if("start".equals(logArr[1])){
                if(!taskStack.isEmpty()){
                    res[taskStack.peek()] += curT - lastT;
                }
                taskStack.push(id);
                lastT = curT;
            }else{
                res[taskStack.pop()] += curT - lastT + 1;
                lastT = curT + 1;
            }
        }
        return res;
    }
}