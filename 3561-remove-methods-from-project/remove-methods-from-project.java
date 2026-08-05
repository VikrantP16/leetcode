import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : invocations) adj.get(e[0]).add(e[1]);

        boolean[] suspicious = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(k);
        suspicious[k] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : adj.get(cur)) {
                if (!suspicious[nxt]) {
                    suspicious[nxt] = true;
                    queue.add(nxt);
                }
            }
        }

        boolean canRemove = true;
        for (int[] e : invocations) {
            if (!suspicious[e[0]] && suspicious[e[1]]) {
                canRemove = false;
                break;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (!canRemove) {
            for (int i = 0; i < n; i++) result.add(i);
        } else {
            for (int i = 0; i < n; i++) if (!suspicious[i]) result.add(i);
        }

        return result;
    }
}