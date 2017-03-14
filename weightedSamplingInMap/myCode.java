

import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 5);
        
        
        myCode sol = new myCode();
        
        String res = sol.weightedSampling(map);
        
    }
    public String weightedSampling(HashMap<String,Integer> map){
        updateMap(map);
        List<Integer> list = new ArrayList<>();
        map.forEach((key, value) -> System.out.println(key + " : " + value));
        map.forEach((key, value) -> list.add(value));
                    
        System.out.println(list);
        
        // randomNum = minimum + (int)(Math.random() * maximum);
        int value = binarySearch(list,4);
        System.out.println("The value is " + value);
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                System.out.println(entry.getKey());
            }
        }
        
        return "";
        
    }
    public void updateMap(HashMap<String,Integer> map){
        int temp = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            temp += entry.getValue();
            map.put(entry.getKey(),temp);
            
        }
    }
    
    public int binarySearch(List<Integer> list , int target ){
        int low = 0;
        int high = list.size();
        while( low <= high ){
            int mid = low + (high - low ) / 2;
            if( list.get(mid) >=  target && list.get(mid-1) < target ) {
                return list.get(mid);
            } else  if ( list.get(mid) > target ){
                high = mid - 1;
                
            } else {
                low = mid + 1;
            }
        }
        return low;
    }    
}
