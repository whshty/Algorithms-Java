```java
class LFUCache {
    Map<Integer, Integer> keyToVal;
    Map<Integer, Integer> keyToFreq;
    Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    int SIZE;
    int min = -1;

    public LFUCache(int size) {
        this.SIZE = size;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        freqToKeys.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        if (freq == min && freqToKeys.get(freq).size() == 0) min++;
        freqToKeys.computeIfAbsent(freq + 1, set -> new LinkedHashSet<>()).add(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (SIZE <= 0) return;
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key);
            return;
        }
        if (keyToVal.size() >= SIZE) {
            int minKey = freqToKeys.get(min).iterator().next();
            freqToKeys.get(min).remove(minKey);
            keyToVal.remove(minKey);
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        min = 1;
        freqToKeys.get(1).add(key);
    }
}
s
```