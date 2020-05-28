package hashes;

public interface IHashTable<K, V> {

    boolean add(K key, V value);

    boolean remove(K key, V value);

}
