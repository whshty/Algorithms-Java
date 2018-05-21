## DFS
```java
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Set<Result>> map = new HashMap<>();
        
        for (int i = 0 ; i < equations.length ; i++) {
            String[] equation = equations[i];
            map.computeIfAbsent(equation[0], set -> new HashSet<>()).add(new Result(equation[1],values[i]));
            map.computeIfAbsent(equation[1], set -> new HashSet<>()).add(new Result(equation[0],1/values[i]));
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            double value = dfs(map, new HashSet<>(), queries[i][0], queries[i][1], 1.0);
            res[i] = value == 0.0 ? -1.0 : value;
        }
        return res;
    }
    
    private double dfs(Map<String,Set<Result>> map, Set<String> set, String start, String end, double value) {
        if (set.contains(start) || !map.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        
        set.add(start);
        for (Result res : map.get(start)) {
            double temp = dfs(map, set, res.divident, end, value * res.value);
            if (temp != 0.0) return temp;
        }
        set.remove(start);
        return 0.0;
    }
}

class Result {
    String divident;
    double value;
    
    Result(String divident, double value) {
        this.divident = divident;
        this.value = value;
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