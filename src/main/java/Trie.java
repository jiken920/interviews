/**
 * Basic trie implementation.
 */
public final class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        TrieNode cur = root;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            TrieNode[] children = cur.getChildren();

            if(children[index] == null) {
                children[index] = new TrieNode(c);
            }

            cur = children[index];
        }
    }

    public boolean exists(String word) {
        TrieNode cur = root;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            TrieNode[] children = cur.getChildren();

            if(children[index] == null) { return false; }
            if(children[index].getValue() != c) { return false; }

            cur = children[index];
        }
        return true;
    }

    private final class TrieNode {
        private char value;
        private final TrieNode[] children = new TrieNode[26];

        public TrieNode() {}

        public TrieNode(char value) {
            this();
            this.value = value;
        }

        public char getValue() {
            return this.value;
        }

        public TrieNode[] getChildren() {
            return this.children;
        }
    }
}
