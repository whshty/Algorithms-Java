// Regular BFS
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        Map<Integer, Set<Integer>> adList = new HashMap<>();
        int[] degree = new int[n];
        buildAdjList(edges, adList, degree);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.add(i);
        }

        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                degree[cur]--;
                for (int j : adList.get(cur)) {
                    if (degree[j] == 0) continue;
                    if (degree[j] == 2) queue.offer(j);
                    degree[j]--;
                }
            }
        }
        return res;
    }

    private void buildAdjList(int[][] edges, Map<Integer, Set<Integer>> adjList, int[] degree) {
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], set -> new HashSet<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], set -> new HashSet<>()).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
    }
}

// Remove nodes from leave to root
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        Map<Integer,Set<Integer>> map = buildAdjList(edges,res);

        int count = n;
        while (count > 2) {
            count -= res.size();
            List<Integer> newRes= new ArrayList<>();
            for (int i : res) {
                int temp = map.get(i).iterator().next();
                map.get(temp).remove(i);
                if (map.get(temp).size() == 1) {
                    newRes.add(temp);
                }
            }
            res = newRes;
        }
        return res;
    }

    private Map<Integer, Set<Integer>> buildAdjList(int[][] edges, List<Integer> res) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], set -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], set -> new HashSet<>()).add(edge[0]);
        }
        map.forEach((k, v) -> {
            if (v.size() == 1) res.add(k);
        });
        return map;
    }
}