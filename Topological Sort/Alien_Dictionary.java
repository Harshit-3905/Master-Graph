import java.util.*;

class Solution {
    public String findOrder(String[] dict, int n, int K) {
        int mod = 97;
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            list.add(new ArrayList<Character>());
        }
        for (int i = 0; i < n - 1; i++) {
            int j = 0, k = 0;
            while ((j < dict[i].length() && k < dict[i + 1].length()) && (dict[i].charAt(j) == dict[i + 1].charAt(k))) {
                k++;
                j++;
            }
            if (j == dict[i].length() || k == dict[i + 1].length()) {
                continue;
            }
            list.get(dict[i].charAt(j) % mod).add(dict[i + 1].charAt(k));
        }
        int indeg[] = new int[K];
        for (ArrayList<Character> i : list) {
            for (char j : i) {
                indeg[j % mod] += 1;
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indeg[i] == 0) {
                q.add((char) (i + mod));
            }
        }
        String ans = "";
        while (!q.isEmpty()) {
            char temp = q.remove();
            ans = ans + temp;
            for (char i : list.get(temp % mod)) {
                if (--indeg[i % mod] == 0) {
                    q.add(i);
                }
            }
        }
        return ans;
    }
}