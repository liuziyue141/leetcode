/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = findPotentialCelebrity(0, new HashSet<>(), n);
        if(celebrity == -1){
            return -1;
        }
        for(int i = 0; i < n; i++){
            if(i==celebrity){
                continue;
            }
            if(!knows(i, celebrity)){
                return -1;
            }
        }
        return celebrity;
    }

    public int findPotentialCelebrity(int cur, HashSet<Integer> seen, int n){
        boolean isCelebrity = true;
        seen.add(cur);
        for(int i = 0; i < n; i++){
            if(i == cur){
                continue;
            }
            if(knows(cur, i)){
                isCelebrity = false;
                if(seen.contains(i)){
                    continue;
                }
                int celebrity = findPotentialCelebrity(i, seen, n);
                if(celebrity != -1){
                    return celebrity;
                }
            }
        }

        if(isCelebrity){
            return cur;
        }else{
            return -1;
        }
    }
}