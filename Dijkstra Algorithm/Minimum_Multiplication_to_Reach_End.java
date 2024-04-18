import java.util.*;

class Minimum_Multiplication_to_Reach_End {
    int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        int[] dist = new int[100000];
        Arrays.fill(dist, (int) 1e9);
        dist[start] = 0;
        int mod = 100000;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int count = p.count;
            for (int it : arr) {
                int num = (node * it) % mod;
                if (count + 1 < dist[num]) {
                    dist[num] = count + 1;
                    if (num == end)
                        return count + 1;
                    q.add(new Pair(num, count + 1));
                }
            }
        }
        return -1;
    }
}

class Pair {
    int node;
    int count;

    Pair(int node, int count) {
        this.node = node;
        this.count = count;
    }
}