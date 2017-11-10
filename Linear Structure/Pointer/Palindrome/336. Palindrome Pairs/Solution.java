class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String leftPart = words[i].substring(0, j);
                String rightPart = words[i].substring(j);
                if (isPalindrome(leftPart)) {
                    String reversedStr2 = new StringBuilder(rightPart).reverse().toString();
                    if (map.containsKey(reversedStr2) && map.get(reversedStr2) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(reversedStr2));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (isPalindrome(rightPart)) {
                    String reversedStr1 = new StringBuilder(leftPart).reverse().toString();
                    if (map.containsKey(reversedStr1) && map.get(reversedStr1) != i && rightPart.length() != 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(reversedStr1));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}
