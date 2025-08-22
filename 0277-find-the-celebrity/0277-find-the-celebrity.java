/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int potentialCandidate = findPotentialCelebrity(n);
        return confirmCelebrity(potentialCandidate, n)? potentialCandidate: -1;
    }

    public int findPotentialCelebrity(int n){
        int cur = 0;
        for(int i = 0; i < n; i++){
            if(i == cur){
                continue;
            }
            if(knows(cur, i)){
                cur = i;
            }
        }
        return cur;
    }

    public boolean confirmCelebrity(int cur, int n){
        for(int i = 0; i < n; i++){
            if(i == cur){
                continue;
            }
            if(knows(cur, i) || !knows(i, cur)){
                return false;
            }
        }
        return true;
    }
}