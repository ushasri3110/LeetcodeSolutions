class Solution {
    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            adj[u].add(new int[]{v, t});
            adj[v].add(new int[]{u, t});
        }

        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        int[] ways = new int[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        time[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            int node = (int) current[0];
            long currTime = current[1];

            for (int[] neighbor : adj[node]) {
                int nextNode = neighbor[0];
                long edgeTime = neighbor[1];
                long newTime = currTime + edgeTime;

                if (newTime < time[nextNode]) {
                    time[nextNode] = newTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{nextNode, newTime});
                } else if (newTime == time[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
