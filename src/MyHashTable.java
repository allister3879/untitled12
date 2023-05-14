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
    public void put(K key, V value) {
        int bucketIndex = hash(key);
        LinkedList<HashNode<K, V>> bucketList = bucketArray.get(bucketIndex);

        // check if the key already exists in the hash table
        for (HashNode<K, V> node : bucketList) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // if the key doesn't exist, add a new node to the bucket list
        HashNode<K, V> newNode = new HashNode<>(key, value);
        bucketList.add(newNode);
        size++;

    }
}
