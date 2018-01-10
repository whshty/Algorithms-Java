public class Codec {
    Map<String,String> tinyUrlMap = new HashMap<>();
    Map<String,String> longUrlMap = new HashMap<>();
    static String PREFIXURL = "https://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if( longUrlMap.containsKey(longUrl)) return PREFIXURL + longUrlMap.get(longUrl);
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; i < 6 ; i++ ){
            int rand = (int)(Math.random()*chars.length());
            sb.append(chars.charAt(rand));
        }
        String key = sb.toString();
        
        tinyUrlMap.put(key,longUrl);
        longUrlMap.put(longUrl,key);
        return PREFIXURL+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return tinyUrlMap.get(shortUrl.replace(PREFIXURL,""));
    }
}