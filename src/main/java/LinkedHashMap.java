import java.util.ArrayList;

public class LinkedHashMap<K, V> {
    private final int numberBuckets;
    ArrayList<LinkedList<K>> BucketArray;

    public LinkedHashMap() {
        this.numberBuckets = 10;
        this.BucketArray = new ArrayList<>(numberBuckets);
        //Create empty Linked List
        for (int i = 0; i < numberBuckets; i++)
            this.BucketArray.add(null);
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs((key.hashCode()));
        int index = hashCode % numberBuckets;
        return index;
    }

    public V get(K key) {
        int index = this.getBucketIndex(key);
        LinkedList<K> LinkedList = this.BucketArray.get(index);
        if (LinkedList == null) return null;
        MapNode<K, V> MapNode = (MapNode<K, V>) LinkedList.search(key);
        return (MapNode == null) ? null : MapNode.getValue();
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        LinkedList<K> myLinkedList = this.BucketArray.get(index);
        if (myLinkedList == null) {
            myLinkedList = new LinkedList<>();
            this.BucketArray.set(index, myLinkedList);
        }
        MapNode<K, V> MapNode = (MapNode<K, V>) myLinkedList.search(key);
        if (MapNode == null) {
            MapNode = new MapNode<>(key, value);
            myLinkedList.append(MapNode);
        } else {
            MapNode.setValue(value);
        }
    }

    @Override
    public String toString() {
        return "LinkedHashMap List {" + BucketArray + "}";
    }
}
