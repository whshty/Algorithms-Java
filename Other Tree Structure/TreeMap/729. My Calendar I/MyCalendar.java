class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floor = map.floorKey(start);
        if( floor != null && map.get(floor) > start ) return false;
        Integer ceiling = map.ceilingKey(start);
        if( ceiling != null && ceiling < end ) return false;
        map.put(start,end);
        return true;
    }
}