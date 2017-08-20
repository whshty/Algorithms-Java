class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();

        initIndegree(words,degree);
                
        for(int i = 0; i < words.length-1; i++){
            String one = words[i];
            String two = words[i+1];
            int length = Math.min(one.length(), two.length());
            for(int j = 0 ; j < length; j++){
                char ch1 = one.charAt(j);
                char ch2 = two.charAt(j);
                if( ch1 != ch2){
                    Set<Character> set = new HashSet<Character>();
                    if(map.containsKey(ch1)) set = map.get(ch1);
                    if(!set.contains(ch2)){
                        set.add(ch2);
                        map.put(ch1, set);
                        degree.put(ch2, degree.get(ch2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue =new LinkedList<Character>();
        for(char ch: degree.keySet()){
            if(degree.get(ch)==0) queue.add(ch);
        }
        while(!queue.isEmpty()){
            char ch = queue.remove();
            //result+=c;
            sb.append(ch);
            if(map.containsKey(ch)){
                for(char ch2: map.get(ch)){
                    degree.put(ch2,degree.get(ch2)-1);
                    if(degree.get(ch2) == 0) queue.add(ch2);
                }
            }
        }
        if( sb.length() != degree.size()) return "";
        return sb.toString();
    }
    
    private void initIndegree(String[] words,Map<Character,Integer> degree){
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
    }
    
    
}