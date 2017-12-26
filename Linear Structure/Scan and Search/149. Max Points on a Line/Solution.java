public class Solution{
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        int max = 0;
        for(int i = 0 ; i < points.length - 1 ; i++){
            Map<Double, Integer> map = new HashMap<>();
            int samePoint = 0, localMax = 0;
            for(int j = i+1 ; j < points.length ; j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if( x == 0 && y== 0) {
                    samePoint++;
                    continue;
                }
                double k = getSlope(x,y);
                map.put(k,map.getOrDefault(k,0)+1);
                localMax = Math.max(localMax, map.get(k));
            }
            max = Math.max(max, localMax + samePoint);
        }
        return max + 1;
    }
    private Double getSlope(int x, int y){
        if(y == 0) return Double.MAX_VALUE;
        else return (double)x/(double) y + 0.0;
    }
}