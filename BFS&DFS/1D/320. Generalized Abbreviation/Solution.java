class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), word.toCharArray(), 0, 0);
        return res;
    }
    private void helper (List<String> res, StringBuilder sb, char[] word, int pos, int count) {
        int len = sb.length();
        if( pos == word.length ){
            if (count > 0) sb.append(count);
            res.add(sb.toString());
        } else {
            helper(res, sb, word, pos + 1, count + 1);
            if (count > 0) sb.append(count);
            helper(res, sb.append(word[pos]), word, pos + 1, 0 );
        }
        sb.setLength(len);
    }
}