import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> hash = new MyHashTable<>(11);
        Random rand = new Random();
        // adding elements to bucketList
        for (int i = 0; i < 10000; i++) {
            int key = rand.nextInt(100000);
            String value = "value" + i;
            MyTestingClass obj = new MyTestingClass(key);
            hash.put(obj, value);
        }
        // showing num of elements in each bucket
        for (int i = 0; i < hash.getNumBuckets(); i++) {
            System.out.println("Bucket " + i + " contains " + hash.getSize(i) + " elements.");
        }
    }
}