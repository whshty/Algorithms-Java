class LFUCache {
    Map<Integer,Integer> valMap;
    Map<Integer,Integer> freqMap;
    Map<Integer,LinkedHashSet<Integer>> listMap;
    int size;
    int min = -1;

    public LFUCache(int size) {
        this.size = size;
        valMap = new HashMap<>();  // <Key,Value>
        freqMap = new HashMap<>(); // <Key,Freq>
        listMap = new HashMap<>(); // <Freq,keys>
        listMap.put(1,new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!valMap.containsKey(key)) return -1;
        int freq = freqMap.get(key);
        freqMap.put(key,freq+1);
        listMap.get(freq).remove(key);
        if( freq == min && listMap.get(freq).size() == 0) min++;
        listMap.putIfAbsent(freq+1,new LinkedHashSet<>());
        listMap.get(freq+1).add(key);
        return valMap.get(key);
    }
    
    public void put(int key, int value) {
        if( size <= 0 ) return;
        if(valMap.containsKey(key)){
            valMap.put(key,value);
            get(key);
            return;
        }
        // new key
        if(valMap.size() >= size){
            int evit = listMap.get(min).iterator().next();
            listMap.get(min).remove(evit);
            valMap.remove(evit);
        }
        valMap.put(key,value);
        freqMap.put(key,1);
        min = 1;
        listMap.get(1).add(key);
    }
}