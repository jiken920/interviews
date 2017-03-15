import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Generic, thread-safe trie that provides basic Map-like functions. Provides O(k) lookup and O(k)
 * insertion time, where k is the length of the key.
 *
 * @author Kenji Rudio
 */
public final class RBTrie<K extends CharSequence, V> implements TrieMap<K, V> {
    private final TrieNode root;

    private static final String NULL_KEY_MSG = "The key was null";
    private static final String ZERO_LENGTH_KEY_MSG = "Zero-length keys are not allowed";

    public RBTrie() {
        root = new TrieNode();
    }

    /**
     *
     * @param key
     * @return
     */
    public V get(K key) {
        validateInputKey(key);

        ConcurrentMap<Character, TrieNode<V>> children = root.getChildren();
        for(int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            // If the current character doesn't match what's in the trie, then break and return null.
            if(!children.containsKey(c)) {
                break;
            } else if(i == key.length() - 1) {
                return children.get(c).getValue();
            } else {
                children = children.get(c).getChildren();
            }
        }

        return null;
    }

    /**
     * Adds a new value to the trie if the key doesn't exist. If the key does exist, the value is updated and the
     * previous value is returned. The value is always stored in the last element of the key.
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value) {
        validateInputKey(key);

        ConcurrentMap<Character, TrieNode<V>> children = root.getChildren();
        V previousValue = null;
        for(int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            TrieNode<V> child;
            if(children.containsKey(c)) {
                child = children.get(c);
                // We're on the last letter. If a value already exists here, then update the child with our new value
                // and store a reference to the previous value which we'll return later
                if(i == key.length() - 1) {
                    previousValue = child.getValue();
                    child = new TrieNode<>(c, value);
                    children.put(c, child);
                }
            } else {
                // We're on the last letter. Store our value in a TrieNode and return the previous value
                if(i == key.length() - 1) {
                    child = new TrieNode<>(c, value);
                } else { // Otherwise, create a new node with a key, but no value
                    child = new TrieNode<>(c);
                }
                children.put(c, child);
            }

            // Move to the child's set of children
            children = child.getChildren();
        }

        return previousValue;
    }

    /**
     * Throws an exception if the input key is null or empty.
     *
     * @param key The input key to validate
     */
    private void validateInputKey(K key) {
        if(key == null) {
            throw new IllegalArgumentException(NULL_KEY_MSG);
        }
        if(key.length() == 0) {
            throw new IllegalArgumentException(ZERO_LENGTH_KEY_MSG);
        }
    }

    /**
     * A structure that represents nodes in a trie. Designed to be thread-safe. A TrieNode can be used in the
     * following ways:
     *
     * 1. Empty node - Contains neither a character nor a value. Can be used to represent the root node in a trie.
     * 2. Intermediate node - Contains a character within a key, but not the value associated with it.
     * 3. Storage node - This will usually represent the last character in a key, and the value corresponding to that
     *    key will reside here.
     */
    private final class TrieNode<V> {
        private final Character letter;
        private final V value;
        private ConcurrentMap<Character, TrieNode<V>> children;

        public TrieNode() {
            this.letter = null;
            this.value = null;
        }

        public TrieNode(char letter) {
            this.letter = letter;
            this.value = null;
        }

        public TrieNode(char letter, V value) {
            this.letter = letter;
            this.value = value;
        }

        public final Character getLetter() {
            return letter;
        }

        public final V getValue() {
            return value;
        }

        public final ConcurrentMap<Character, TrieNode<V>> getChildren() {
            if(children == null) {
                children = new ConcurrentHashMap<>();
            }
            return children;
        }
    }
}




