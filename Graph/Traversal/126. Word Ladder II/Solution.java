class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordDict = new HashSet<>(wordList);
        Map<String, Integer> distMap = new HashMap<>();
        Map<String, List<String>> pathMap = new HashMap<>();
        distMap.put(beginWord, 1);
        wordDict.add(beginWord);
        bfs(beginWord, endWord, pathMap, distMap, wordDict);
        generatePath(beginWord, endWord, pathMap, distMap, res, new ArrayList<>());
        return res;
    }

    public void bfs(String beginWord, String endWord, Map<String, List<String>> pathMap, Map<String, Integer> distMap, Set<String> wordDict) {
        Queue<String> queue = new LinkedList<>();
        for (String str : wordDict) pathMap.put(str, new ArrayList<>());
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasFound = false;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> next = generateNextWord(cur, wordDict);
                for (String str : next) {
                    pathMap.get(cur).add(str);
                    if (!distMap.containsKey(str)) {
                        distMap.put(str, distMap.get(cur) + 1);
                        if (str.equals(endWord)) {
                            hasFound = true;
                        } else {
                            queue.offer(str);
                        }
                    }
                }

            }
            if (hasFound == true) break;
        }
    }

    public List<String> generateNextWord(String cur, Set<String> wordDict) {
        char[] str = cur.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char pre = str[i];
                str[i] = c;
                String next = String.valueOf(str);
                if (wordDict.contains(next) && !next.equals(cur)) {
                    res.add(next);
                }
                str[i] = pre;
            }
        }
        return res;
    }

    private void generatePath(String cur, String end, Map<String, List<String>> pathMap, Map<String, Integer> distMap, List<List<String>> res, List<String> path) {
        path.add(cur);
        if (cur.equals(end)) {
            List<String> r = new ArrayList<>(path);
            res.add(r);
        } else {
            for (String str : pathMap.get(cur)) {
                if (distMap.get(str) == distMap.get(cur) + 1) {
                    generatePath(str, end, pathMap, distMap, res, path);
                }
            }
        }
        path.remove(path.size() - 1);
    }
}