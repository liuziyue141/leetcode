/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth(nestedList);
        return calculateScore(nestedList, maxDepth, 1);
    }

    public int getMaxDepth(List<NestedInteger> nestedList){
        int depth = 1;
        for(NestedInteger n : nestedList){
            if(!n.isInteger()){
                depth = Math.max(getMaxDepth(n.getList()) + 1, depth);
            }
        }
        return depth;
    }

    public int calculateScore(List<NestedInteger> nestedList,int maxDepth, int depth){
        int weight = maxDepth - depth + 1;
        int res = 0;
        for(NestedInteger n : nestedList){
            if(n.isInteger()){
                res += n.getInteger() * weight;
            }else{
                res += calculateScore(n.getList(), maxDepth, depth + 1);
            }
        }
        return res;
    }
}