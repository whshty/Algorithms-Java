import java.util.*;

public class MST {

    public static void main(String[] args) {
        Edge c1 = new Edge("A", "D", 1);
        Edge c2 = new Edge("A", "B", 3);
        Edge c3 = new Edge("D", "B", 3);
        Edge c4 = new Edge("B", "C", 1);
        Edge c5 = new Edge("C", "D", 1);
        Edge c6 = new Edge("E", "D", 6);
        Edge c7 = new Edge("C", "E", 5);
        Edge c8 = new Edge("C", "F", 4);
        Edge c9 = new Edge("E", "F", 2);

        List<Edge> input = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9));
        List<Edge> result = getLowCost(input);
        for (Edge conn : result) {
            System.out.println(conn.node1 + "-" + conn.node2 + "-" + conn.value);
        }

    }

    private static int unionGroup;

    public static List<Edge> getLowCost(List<Edge> edges) {
        if (edges == null || edges.size() == 0) return new ArrayList<>();

        List<Edge> result = new ArrayList<>();
        // <Key, Value>: <NodeName, UnionGroupNumber>
        Map<String, Integer> map = new HashMap<>();
        // Sort edge from small to big
        Collections.sort(edges, Comparator.comparingInt(a -> a.value));

        unionGroup = 0;
        for (Edge edge : edges) {
            String temp1 = edge.node1;
            String temp2 = edge.node2;
            if (unionFind(map, temp1, temp2)) {
                result.add(edge);
            }
        }

        // Check if we only have one unionFind here
        String unionGroup = edges.get(0).node1;
        int union = map.get(unionGroup);
        for (String str : map.keySet()) {
            if (map.get(str) != union) {
                return new ArrayList<>();
            }
        }

        // Sort by city name
        Collections.sort(result, (a, b) -> {
            if (a.node1.equals(b.node1)) return a.node2.compareTo(b.node2);
            return a.node1.compareTo(b.node1);
        });
        return result;
    }

    private static boolean unionFind(Map<String, Integer> map, String str1, String str2) {
        if (!map.containsKey(str1) && !map.containsKey(str2)) {
            map.put(str1, unionGroup);
            map.put(str2, unionGroup);
            unionGroup++;
            return true;
        }

        if (map.containsKey(str1) && !map.containsKey(str2)) {
            map.put(str2, map.get(str1));
            return true;
        }
        if (!map.containsKey(str1) && map.containsKey(str2)) {
            map.put(str1, map.get(str2));
            return true;
        }

        int temp1 = map.get(str1);
        int temp2 = map.get(str2);
        if (temp1 == temp2) return false;
        for (String s : map.keySet()) {
            if (map.get(s) == temp2) map.put(s, temp1);
        }
        return true;
    }

}


class Edge {
    String node1;
    String node2;
    int value;

    public Edge(String a, String b, int cost) {
        this.node1 = a;
        this.node2 = b;
        this.value = cost;
    }
}
