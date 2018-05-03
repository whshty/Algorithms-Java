## Random 6 Digits key

```java
public class Codec {
    Map<String,String> keyToLongUrl = new HashMap<>();
    Map<String,String> longUrlToKey = new HashMap<>();
    private final static String PREFIX_URL = "https://tinyurl.com/";
    private final static String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if( longUrlToKey.containsKey(longUrl)) return PREFIX_URL + longUrlToKey.get(longUrl);
        
        String key = generateRandomKey();
        keyToLongUrl.put(key,longUrl);
        longUrlToKey.put(longUrl,key);
        return PREFIX_URL + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return keyToLongUrl.get(shortUrl.replace(PREFIX_URL,""));
    }
    
    // Generates random key
    private String generateRandomKey(){
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ; i < 6 ; i++ ){
            int rand = (int)(Math.random()*CHARS.length());
            sb.append(CHARS.charAt(rand));
        }
        return sb.toString();
    }
}
```