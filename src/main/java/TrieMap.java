/**
 * Created by Kenji on 11/30/2016.
 */
public interface TrieMap<K, V> {
    V get(K key);
    V put(K key, V value);
}
