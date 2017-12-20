class MyCalendarTwo {
    List<int[]> list;
    TreeMap<Integer, Integer> treeMap;

    public MyCalendarTwo() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        treeMap = new TreeMap<>();
        for (int[] interval : list) {
            int[] overlap = getOverlap(interval, start, end);
            if (overlap[0] >= 0) {
                if (hasOverlap(treeMap, overlap[0], overlap[1])) return false;
                treeMap.put(overlap[0], overlap[1]);
            }
        }
        list.add(new int[] {start, end});
        return true;
    }

    private int[] getOverlap(int[] interval, int start, int end) {
        int[] res = new int[] {-1, -1};
        if (start >= interval[1] || end <= interval[0]) return res;
        res[0] = Math.max(start, interval[0]);
        res[1] = Math.min(end, interval[1]);
        return res;
    }

    private boolean hasOverlap(TreeMap<Integer, Integer> treeMap, int start, int end) {
        Integer floor = treeMap.floorKey(start);
        if (floor != null && treeMap.get(floor) > start) return true;
        Integer ceiling = treeMap.ceilingKey(start);
        if (ceiling != null && ceiling < end) return true;
        return false;
    }
}