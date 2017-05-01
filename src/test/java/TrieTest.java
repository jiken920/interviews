import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 3/8/17.
 */
public class TrieTest {
    @Test
    public void add() throws Exception {
        Trie trie = new Trie();
        trie.add("abc");
        trie.add("abd");

        assertEquals(true, trie.exists("abc"));
        assertEquals(true, trie.exists("abd"));
    }

    @Test
    public void exists() throws Exception {

    }

}