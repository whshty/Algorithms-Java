public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<String>> pairs = new HashMap<>();
        Map<String, ArrayList<Double>> valuesPair = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            
            pairs.computeIfAbsent(equation[0], list -> new ArrayList<>()).add(equation[1]);
            pairs.computeIfAbsent(equation[1], list -> new ArrayList<>()).add(equation[0]);
            valuesPair.computeIfAbsent(equation[0], list -> new ArrayList<>()).add(values[i]);
            valuesPair.computeIfAbsent(equation[1], list -> new ArrayList<>()).add(1/values[i]);
        }
        
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            res[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<>(), 1.0);
            if (res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }
    
    private double dfs(
        String start, 
        String end, 
        Map<String, ArrayList<String>> pairs, 
        Map<String, ArrayList<Double>> values, 
        HashSet<String> set, 
        double value) {
        
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);
        
        List<String> strList = pairs.get(start);
        List<Double> valueList = values.get(start);
        double res = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            res = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
            if (res != 0.0) break;
        }
        set.remove(start);
        return res;
    }
}