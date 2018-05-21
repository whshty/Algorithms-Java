import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        int len = words[0].length();
        Trie trie = new Trie();
        trie.buildTrie(words);
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
            generateResult(res, list, trie, len);
            list.remove(list.size() - 1);
        }

        return res;
    }

    private void generateResult(List<List<String>> res, List<String> list, Trie trie, int len) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }

        int pos = list.size();
        StringBuilder sb = new StringBuilder();
        for (String str : list) sb.append(str.charAt(pos));
        List<String> wordsByPrefix = trie.getResultByPrefix(sb.toString());
        for (String words : wordsByPrefix) {
            list.add(words);
            generateResult(res, list, trie, len);
            list.remove(list.size() - 1);
        }
    }

    class TrieNode {
        List<String> wordsByPrefix;
        TrieNode[] nodes;

        TrieNode() {
            wordsByPrefix = new ArrayList<>();
            nodes = new TrieNode[26];
        }

        boolean containsKey(char ch) {
            return nodes[ch - 'a'] != null;
        }

        TrieNode get(char ch) {
            return nodes[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            nodes[ch - 'a'] = node;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void buildTrie(String[] words) {
            for (String word : words) {
                insert(word);
            }
        }

        void insert(String word) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node.nodes[ch - 'a'].wordsByPrefix.add(word);
                node = node.get(ch);
            }
        }


        List<String> getResultByPrefix(String prefix) {
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int value = ch - 'a';
                if (cur.nodes[value] == null) return new ArrayList<>();
                cur = cur.nodes[value];
            }
            return cur.wordsByPrefix;
        }
    }
}