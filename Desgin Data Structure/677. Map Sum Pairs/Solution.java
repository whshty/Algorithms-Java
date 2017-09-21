class MapSum {
    Map<String,Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key,val);        
    }
    
    public int sum(String prefix) {
        int res = 0;
        for(String str : map.keySet()){
            if( str.startsWith(prefix)){
                res += map.get(str);
            }
        }
        return res;
    }
}

