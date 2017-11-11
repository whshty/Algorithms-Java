import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, User> map = new HashMap<>();    // <Email, email node>

        // Build the graph;
        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                if (!map.containsKey(email)) {
                    User user = new User(email, name);
                    map.put(email, user);
                }

                if (j == 1) continue;
                //Connect the current email node to the previous email node;
                String preEmail = list.get(j - 1);
                map.get(preEmail).neighbors.add(map.get(email));
                map.get(email).neighbors.add(map.get(preEmail));
            }
        }

        // DFS search for each components(each account);
        Set<String> isVisited = new HashSet<>();
        for (String str : map.keySet()) {
            if (isVisited.add(str)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                dfs(map.get(str), isVisited, list);
                Collections.sort(list);
                list.add(0, map.get(str).name);
                res.add(list);
            }
        }
        return res;
    }

    public void dfs(User root, Set<String> visited, List<String> list) {
        for (User node : root.neighbors) {
            if (visited.add(node.email)) {
                list.add(node.email);
                dfs(node, visited, list);
            }
        }
    }

    class User {
        String email;
        String name;
        List<User> neighbors;

        User(String val, String name) {
            this.email = val;
            this.name = name;
            neighbors = new ArrayList<>();
        }
    }
}