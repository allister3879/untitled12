import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashTable<K, V> {
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

    public MyHashTable(int num) {
        bucketArray = new ArrayList<>();
        numBuckets = num;
        size = 0;

        // initialize each bucket with an empty LinkedList
        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(new LinkedList<HashNode<K, V>>());
        }
    }

    // methods >>>

    private int hash(K key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode) % numBuckets; // hash algorithm
        return index;
    }
}
