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