class Solution {
    public String frequencySort(String s) {
        char[] chs = s.toCharArray();
        int[] bucket = new int[256];
        for( char c : chs ) bucket[c]++;
        
        Map<Integer,List<Character>> map = new HashMap<>();
        for( int i = 0 ; i < 256 ; i++ ){
            if( bucket[i] == 0 ) continue;
            int count = bucket[i];
            if(!map.containsKey(count)){
                map.put(count, new ArrayList<Character>());
            }
            map.get(count).add((char)i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = chs.length; i > 0; i--){ 
            if(!map.containsKey(i)) continue;
            List<Character> list = map.get(i);
            for(Character c: list){
                for(int j = 0; j < i; j++) sb.append(c);
            }
        }
        return sb.toString();
    }
}