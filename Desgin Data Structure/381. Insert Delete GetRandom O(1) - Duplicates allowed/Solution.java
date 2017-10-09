class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isContained = map.containsKey(val);
        map.putIfAbsent(val, new HashSet<>());
        int index = list.size();
        map.get(val).add(index);
        list.add(val);
        return !isContained;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        if(!map.get(val).contains(list.size()-1)) {
            int curIndex = map.get(val).iterator().next(); // get the first one from set 
            int lastVal = list.get(list.size() - 1);
            map.get(lastVal).remove(list.size() - 1);
            map.get(lastVal).add(curIndex);
            map.get(val).remove(curIndex);
            map.get(val).add(list.size() - 1);
            list.set(curIndex, lastVal);          
        } 
        map.get(val).remove(list.size()-1);
        if(map.get(val).isEmpty()) map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

