class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        HashSet<Integer> sourceBus = new HashSet<>();
        HashSet<Integer> targetBus = new HashSet<>();
        HashMap<Integer, List<Integer>> stopBusMap = new HashMap<>();
        HashMap<Integer, Set<Integer>> BusMap = new HashMap<>();
        for(int i = 0; i < routes.length; i++){
            BusMap.put(i, new HashSet<>());
            for(int j = 0; j < routes[i].length; j++){
                stopBusMap.putIfAbsent(routes[i][j], new ArrayList<>());
                List<Integer> buses = stopBusMap.get(routes[i][j]);
                buses.add(i);
                if(source == routes[i][j]){
                    sourceBus.add(i);
                }
                if(target == routes[i][j]){
                    targetBus.add(i);
                }
            }
        }

        for(int stop : stopBusMap.keySet()){
            List<Integer> transfer = stopBusMap.get(stop);
            for(int bus : transfer){
                BusMap.get(bus).addAll(transfer);
            }
        }

        int cnt = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> taken = new HashSet<>();
        queue.addAll(sourceBus);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                if(targetBus.contains(cur)){
                    return cnt;
                }
                for(int n : BusMap.get(cur)){
                    if(!taken.contains(n)){
                        queue.add(n);
                        taken.add(n);
                    }
                }
            }
            cnt++;
        }
        return -1; 

    }
}