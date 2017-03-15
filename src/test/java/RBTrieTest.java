import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kenji on 11/30/2016.
 */
public class RBTrieTest {

    @Test
    public void testSingleLetterKeys() {
        TrieMap<String, Object> trie = new RBTrie<>();
        trie.put("a", "First");
        trie.put("b", "Second");
        trie.put("c", "Third");
        String previousValue = (String) trie.put("c", "Fourth");

        assertEquals("First", trie.get("a"));
        assertEquals("Second", trie.get("b"));
        assertEquals("Fourth", trie.get("c"));
        assertEquals("Third", previousValue);
    }

    @Test
    public void testLongerKeys() {
        TrieMap<String, Object> trie = new RBTrie<>();
        trie.put("abc", "First");
        trie.put("abcdef", "Second");
        trie.put("defghijkl", "Third");
        String previousValue = (String) trie.put("defghijkl", "Fourth");

        assertEquals("First", trie.get("abc"));
        assertEquals("Second", trie.get("abcdef"));
        assertEquals("Fourth", trie.get("defghijkl"));
        assertEquals("Third", previousValue);
    }

    @Test
    public void testGetMissingKey() {
        TrieMap<String, Object> trie = new RBTrie<>();
        trie.put("a", "First");
        trie.put("b", "Second");
        trie.put("c", "Third");

        assertEquals(null, trie.get("Fourth"));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testPutNullKeyThrowsException() {
        TrieMap<String, Object> trie = new RBTrie<>();
        trie.put(null, "Null Key!");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testPutEmptyKeyThrowsException() {
        TrieMap<String, Object> trie = new RBTrie<>();
        trie.put("", "Empty Key!");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetNullKeyThrowsException() {
        TrieMap<String, Object> trie = new RBTrie<>();
        trie.get(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetEmptyKeyThrowsException() {
        TrieMap<String, Object> trie = new RBTrie<>();
        trie.get("");
    }

}