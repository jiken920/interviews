import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiken920 on 4/20/17.
 */
public class Codec {
    private static final String baseUrl = "http://tinyurl.com/";
    private final Map<String, String> hashCodes = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int code = longUrl.hashCode();
        String shortUrl = baseUrl + String.valueOf(code);
        hashCodes.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hashCodes.get(shortUrl);
    }
}
