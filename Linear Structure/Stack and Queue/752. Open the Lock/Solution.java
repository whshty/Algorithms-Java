class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> endSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");
        int level = 0;

        while( !queue.isEmpty() ){
            int size = queue.size();
            while( size > 0 ){
                String str = queue.poll();
                if( endSet.contains(str)){
                    size--;
                    continue;
                }
                if( str.equals(target) ) return level;
                StringBuilder sb = new StringBuilder(str);
                for( int i = 0 ; i < 4 ; i++ ){
                    char ch = sb.charAt(i);
                    String str1 = sb.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1) + sb.substring(i + 1);
                    String str2 = sb.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + sb.substring(i + 1);
                    if( !visited.contains(str1) && !endSet.contains(str1)){
                        queue.offer(str1);
                        visited.add(str1);
                    }
                    if( !visited.contains(str2) && !endSet.contains(str2)){
                        queue.offer(str2);
                        visited.add(str2);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}
