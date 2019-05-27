import java.util.*;

public class MST2 {
    public static void main(String[] args) {
        MST2 solution = new MST2();
        List<List<Integer>> roads = new ArrayList<>();
        roads.add(Arrays.asList(1, 4));
        roads.add(Arrays.asList(4, 5));
        roads.add(Arrays.asList(2, 3));

        List<List<Integer>> newRoads = new ArrayList<>();
        newRoads.add(Arrays.asList(1, 2, 5));
        newRoads.add(Arrays.asList(1, 3, 10));
        newRoads.add(Arrays.asList(1, 6, 2));
        newRoads.add(Arrays.asList(5, 6, 5));

        System.out.println(solution.getMinimumCostToConstruct(6, 3, roads,
                4, newRoads));


    }

    public int getMinimumCostToConstruct(int numTotalAvailableCities,
                                         int numTotalAvailableRoads,
                                         List<List<Integer>> roadsAvailable,
                                         int numNewRoadsConstruct,
                                         List<List<Integer>> costNewRoadsConstruct) {

        if (numTotalAvailableCities < 2 || numTotalAvailableRoads >= numTotalAvailableCities - 1) return 0;

        UnionFind unionFind = new UnionFind(numTotalAvailableCities);

        int roadCount = 0;

        for (List<Integer> road : roadsAvailable) {
            int node1 = road.get(0);
            int node2 = road.get(1);
            if (!unionFind.isSameUnion(node1, node2)) {
                unionFind.union(node1, node2);
                roadCount++;
            }
        }

        // Sort to-build road
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(numNewRoadsConstruct,
                Comparator.comparingInt(a -> a.value)
        );

        // Build road
        for (List<Integer> road : costNewRoadsConstruct) {
            Edge edge = new Edge(road.get(0), road.get(1), road.get(2));
            minHeap.offer(edge);
        }

        List<Edge> edges = new ArrayList<>();

        while (!minHeap.isEmpty() && edges.size() + roadCount < numTotalAvailableCities - 1) {
            Edge edge = minHeap.poll();
            int city1 = edge.city1;
            int city2 = edge.city2;
            if (!unionFind.isSameUnion(city1, city2)) {
                unionFind.union(city1, city2);
                edges.add(edge);
            }
        }
        // Some cities are still dis-connected
        if (edges.size() + roadCount < numTotalAvailableCities - 1) return -1;
        
        return  edges.stream().mapToInt(o -> o.getValue()).sum();
    }
}

class Edge {
    int city1;
    int city2;
    int value;

    public Edge(int city1, int city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.value = cost;
    }

    public int getValue() {
        return this.value;
    }
}

class UnionFind {

    private int[] ids;

    public UnionFind(int size) {
        this.ids = new int[size + 1];
        for (int i = 0; i < size + 1; i++) {
            this.ids[i] = i;
        }
    }

    public int findRoot(int i) {
        while (ids[i] != i) {
            i = ids[i];
        }
        return i;
    }

    public boolean isSameUnion(int i, int j) {
        return findRoot(i) == findRoot(j);
    }

    public void union(int i, int j) {
        int tempi = findRoot(i);
        int tempj = findRoot(j);
        ids[tempi] = tempj;
    }
}
