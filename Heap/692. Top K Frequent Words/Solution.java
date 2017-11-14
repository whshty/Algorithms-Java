class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);

        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        while (!maxHeap.isEmpty())
            res.add(0, maxHeap.poll().getKey());

        return res;
    }
}