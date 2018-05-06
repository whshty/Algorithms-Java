class Solution {
 public String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
     
        String[] words = p.replaceAll("\\pP" , "").toLowerCase().split("\\s+");
        String res = "";
        int max = 0;
        for (String word : words) {
            if (!ban.contains(word)) {
                map.put(word, map .getOrDefault(word, 0) + 1);
                if (map.get(word) > max) {
                    res = word;
                    max = map.get(word);
                }
            }
        }
        return res;
    }
}