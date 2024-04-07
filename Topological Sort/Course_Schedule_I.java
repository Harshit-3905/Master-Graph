import java.util.*;

class Course_Schedule_I {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int ind = 0;
        while (!q.isEmpty()) {
            int p = q.poll();
            ind++;
            for (int x : adj.get(p)) {
                indegree[x]--;
                if (indegree[x] == 0)
                    q.add(x);
            }
        }
        if (ind == numCourses)
            return true;
        else
            return false;
    }
}