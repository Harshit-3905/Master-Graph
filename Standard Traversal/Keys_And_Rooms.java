import java.util.*;

class Keys_And_Rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int p = q.poll();
            vis[p] = true;
            for (int x : rooms.get(p)) {
                if (!vis[x])
                    q.add(x);
            }
        }
        for (boolean x : vis) {
            if (!x)
                return false;
        }
        return true;
    }
}