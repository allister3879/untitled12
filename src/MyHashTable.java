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
        checkLF();
    }
    private void checkLF() {
        // check if the load factor exceeds a certain threshold
        if ((1.0 * size) / numBuckets >= 0.7) {
            // if so, resize the array and rehash the key-value pairs
            ArrayList<LinkedList<HashNode<K, V>>> tempBucketArray = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;

            for (int i = 0; i < numBuckets; i++) {
                bucketArray.add(new LinkedList<HashNode<K, V>>());
            }

            for (LinkedList<HashNode<K, V>> bucket : tempBucketArray) {
                for (HashNode<K, V> node : bucket) {
                    put(node.key, node.value);
                }
            }
        }
    }

    public V get(K key) {
        int bucketIndex = hash(key);
        LinkedList<HashNode<K, V>> bucketList = bucketArray.get(bucketIndex);

        // iterate over the linked list in the appropriate bucket
        for (HashNode<K, V> node : bucketList) {
            // if the key is found, return its corresponding value
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        // if the key is not found, return null
        return null;
    }
    public V remove(K key) {
        int bucketIndex = hash(key);
        LinkedList<HashNode<K, V>> bucketList = bucketArray.get(bucketIndex);

        // iterate over the linked list in the appropriate bucket
        for (HashNode<K, V> node : bucketList) {
            // if the key is found, remove the node and return its corresponding value
            if (node.key.equals(key)) {
                bucketList.remove(node);
                size--;
                return node.value;
            }
        }
        // if the key is not found, return null
        return null;
    }
    public boolean contains(V value) {
        for (LinkedList<HashNode<K, V>> bucketList : bucketArray) {
            for (HashNode<K, V> node : bucketList) {
                if (node.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
    public K getKey(V value) {
        for (LinkedList<HashNode<K, V>> bucketList : bucketArray) {
            for (HashNode<K, V> node : bucketList) {
                if (node.value.equals(value)) {
                    return node.key;
                }
            }
        }
        return null;
    }
    public int getNumBuckets(){
        return numBuckets;
    }
}
