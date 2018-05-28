class Solution {
    public double soupServings(int n) {
        if (n > 5000) return 1.0;
        return dfs(new HashMap<>(), n, n);
    }
    
    private double dfs(Map<SoupInfo,Double> map, int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        
        SoupInfo info = new SoupInfo(a,b);
        if (map.containsKey(info)) return map.get(new SoupInfo(a,b));
        int[] serveA = {100, 75, 50, 25};
        int[] serveB = {0, 25, 50, 75};
        
        map.put(info, 0.0);
        
        for (int i = 0; i < 4; i++) {
            map.put(info, map.get(info) + dfs(map,  a - serveA[i], b - serveB[i]));
        }
        
        return map.get(info) * 0.25;    
    }
    
    class SoupInfo {
        int a;
        int b;
        SoupInfo(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}
