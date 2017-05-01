import java.util.*;

/**
 * Created by jiken920 on 4/17/17.
 */
public class LRUCache {

    private int capacity;
    private Deque<Pair> lru;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lru = new ArrayDeque<>(capacity);
    }

    public int get(int key) {
        for(Pair item : lru) {
            if(item.key == key) {
                lru.remove(item);
                lru.offerFirst(item);
                return item.value;
            }
        }

        return -1;
    }

    public void put(int key, int value) {
        for(Pair item : lru) {
            if(item.key == key) {
                lru.remove(item);
                item.value = value;
                lru.offerFirst(item);
                return;
            }
        }

        if(lru.size() == this.capacity) {
            lru.removeLast();
        }

        lru.offerFirst(new Pair(key, value));
    }

    private class Pair {
        public int key;
        public int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
