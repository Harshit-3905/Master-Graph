class Time_Needed_To_Inform_Employees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<manager.length;i++){
            if(manager[i]!=-1)
                adj.get(manager[i]).add(i);
        } 
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(headID,0));
        int ans = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            ans = Math.max(ans,p.time);
            for(int x : adj.get(p.vertex)){
                q.add(new Pair(x,informTime[p.vertex]+p.time));
            }
        }
        return ans;
    }
}
class Pair{
    int vertex,time;
    Pair(int a, int b){
        vertex = a;
        time = b;
    }
}