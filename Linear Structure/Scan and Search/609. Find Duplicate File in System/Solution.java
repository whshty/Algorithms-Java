class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        int len = paths.length;
        if( len == 0 ) return res;
        
        Map<String,Set<String>> map = new HashMap<>();
        for(String path : paths){
            String[] strs = path.split("\\s+");
            for( int i = 1 ; i < strs.length ; i++ ){
                int start = strs[i].indexOf("(");
                String content = strs[i].substring(start);
                String fileName = strs[0] + "/" + strs[i].substring(0, start);
                Set<String> set = map.getOrDefault(content,new HashSet<String>());
                set.add(fileName);
                map.put(content,set);   
            }
        }
        
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(new ArrayList<String>(map.get(key)));
            }
        }
        return res;
        
    }
}