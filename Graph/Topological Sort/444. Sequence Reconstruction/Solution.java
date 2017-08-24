class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) {
                if (!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0), new HashSet<>());
                    indegree.put(seq.get(0), 0);
                }
            } else {
                for (int i = 0; i < seq.size() - 1; i++) {
                    int one = seq.get(i);
                    int two = seq.get(i+1);
                    if (!map.containsKey(one)) {
                        map.put(one, new HashSet<>());
                        indegree.put(one, 0);
                    }

                    if (!map.containsKey(two)) {
                        map.put(two, new HashSet<>());
                        indegree.put(two, 0);
                    }

                    if (map.get(one).add(two)) {
                        indegree.put(two, indegree.get(two) + 1);
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) return false;
            int curr = queue.poll();
            if (index == org.length || curr != org[index++]) return false;
            for (int next : map.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) queue.offer(next);
            }
        }
        return index == org.length && index == map.size();
    }
}