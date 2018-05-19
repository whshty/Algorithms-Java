public class ValidWordAbbr {
  Map<String, Set<String>> map = new HashMap<>();
  
  public ValidWordAbbr(String[] dictionary) {
    for (int i = 0; i < dictionary.length; i++) {
      String str = getAbbr(dictionary[i]);
      map.computeIfAbsent(str, set -> new HashSet<>()).add(dictionary[i]); 
    }
  }
  
  public boolean isUnique(String word) {
    String str = getAbbr(word);
    return !map.containsKey(str) || (map.get(str).contains(word) && map.get(str).size() == 1);
  }
     
  private String getAbbr(String s) {
    if (s.length() < 3) return s;
    return s.substring(0, 1) + String.valueOf(s.length() - 2) + s.substring(s.length() - 1);
  }
}
