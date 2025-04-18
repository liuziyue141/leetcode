class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((Element a, Element b) -> {
            return a.sum - b.sum;
        });
        Set<String> visited = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        visited.add(0+"x"+0);
        pq.offer(new Element(nums1[0] + nums2[0], 0, 0));
        while(res.size()!=k){
            Element cur = pq.poll();
            res.add(List.of(nums1[cur.i], nums2[cur.j]));
            if(cur.i + 1 < nums1.length && !visited.contains((cur.i + 1) + "x" + cur.j)){
                pq.offer(new Element(nums1[cur.i + 1] + nums2[cur.j], cur.i + 1, cur.j));
                visited.add((cur.i + 1) + "x" + cur.j);
            }
            if(cur.j + 1 < nums2.length && !visited.contains(cur.i + "x" + (cur.j+1))){
                pq.offer(new Element(nums1[cur.i] + nums2[cur.j + 1], cur.i, cur.j + 1));
                visited.add(cur.i + "x" + (cur.j + 1));
            }
        }
        return res;
        
    }
}

class Element{
    int sum;
    int i;
    int j;

    public Element (int sum, int i, int j){
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}