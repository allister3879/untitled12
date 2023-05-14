import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashTable {
    private ArrayList<LinkedList<HashNode<K, V>>> bucketArray;
    private int numBuckets;
    private int size;
    private class HashNode<K, V> {
        K key;
        V value;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
