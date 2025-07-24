class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] < 0 && stack.isEmpty()){
                res.add(asteroids[i]);
            }else if(asteroids[i] > 0){
                stack.push(asteroids[i]);
            }else{
                while(!stack.isEmpty() && Math.abs(asteroids[i]) > stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res.add(asteroids[i]);
                }else if(stack.peek() == Math.abs(asteroids[i])){
                    stack.pop();
                }
            }
        }

        int[] result = new int[stack.size() + res.size()];

        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }

        for(int i = result.length - 1; i >= res.size(); i--){
            result[i] = stack.pop();
        }
        return result;
    }
}