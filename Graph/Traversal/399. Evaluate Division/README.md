## DFS
```java
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> valueAToValueB = new HashMap<>();
        Map<String, List<Double>> valueToResult = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];

            valueAToValueB.computeIfAbsent(equation[0], list -> new ArrayList<>()).add(equation[1]);
            valueAToValueB.computeIfAbsent(equation[1], list -> new ArrayList<>()).add(equation[0]);
            valueToResult.computeIfAbsent(equation[0], list -> new ArrayList<>()).add(values[i]);
            valueToResult.computeIfAbsent(equation[1], list -> new ArrayList<>()).add(1 / values[i]);
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            res[i] = dfs(query[0], query[1], valueAToValueB, valueToResult, new HashSet<>(), 1.0);
            if (res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }

    private double dfs(
            String start,
            String end,
            Map<String, List<String>> valueAToValueB,
            Map<String, List<Double>> valueToResult,
            Set<String> set,
            double value) {

        if (set.contains(start) || !valueAToValueB.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);

        List<String> values = valueAToValueB.get(start);
        List<Double> results = valueToResult.get(start);
        double res = 0.0;
        for (int i = 0; i < values.size(); i++) {
            res = dfs(values.get(i), end, valueAToValueB, valueToResult, set, value * results.get(i));
            if (res != 0.0) break;
        }
        // Backtracking
        set.remove(start);
        return res;
    }
}
```

## Union find
```java
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, String> valueMap = new HashMap<>();
        Map<String, Double> valueToResult = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String x1 = equations[i][0], x2 = equations[i][1];
            valueMap.putIfAbsent(x1, x1);
            valueMap.putIfAbsent(x2, x2);
            valueToResult.putIfAbsent(x1, 1.0);
            valueToResult.putIfAbsent(x2, 1.0);

            String root1 = find(valueMap, x1);
            String root2 = find(valueMap, x2);
            valueMap.put(root2, root1);
            valueToResult.put(root2, valueToResult.get(x1) * values[i] / valueToResult.get(x2));
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = -1.0;
            String x1 = queries[i][0], x2 = queries[i][1];
            if (!valueMap.containsKey(x1) || !valueMap.containsKey(x2)) continue;
            String r1 = find(valueMap, x1);
            String r2 = find(valueMap, x2);
            if (r1.equals(r2)) res[i] = get(valueMap, valueToResult, x2) / get(valueMap, valueToResult, x1);
        }
        return res;
    }

    private String find(Map<String, String> valueToValue, String value) {
        if (valueToValue.get(value).equals(value)) return value;
        return find(valueToValue, valueToValue.get(value));
    }

    private double get(Map<String, String> x1ToX2, Map<String, Double> x1ToResult, String var) {
        String root = x1ToX2.get(var);
        double result = x1ToResult.get(var);

        if (root.equals(var)) return result;
        return result * get(x1ToX2, x1ToResult, root);
    }
}
```