public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return dfs(input, new HashMap<>());
    }

    private List<Integer> dfs(String str, Map<String, List<Integer>> map) {
        if (map.containsKey(str)) return map.get(str);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char curCh = str.charAt(i);
            if (curCh == '+' || curCh == '-' || curCh == '*') {
                String leftStr = str.substring(0, i);
                String rightStr = str.substring(i + 1);
                List<Integer> leftRes = dfs(leftStr, map);
                List<Integer> rightRes = dfs(rightStr, map);
                for (Integer leftVal : leftRes) {
                    for (Integer rightVal : rightRes) {
                        int curRes = 0;
                        if( curCh == '+') curRes = leftVal + rightVal;
                        else if( curCh == '-' ) curRes = leftVal - rightVal;
                        else if( curCh == '*' ) curRes = leftVal * rightVal;
                        res.add(curRes);
                    }
                }
            }
        }

        if (res.size() == 0) res.add(Integer.parseInt(str));
        map.put(str, res);
        return res;
    }
}