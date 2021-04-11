public class HashMap<K,V> {
    private final LinkedList LinkedList;

    public HashMap() {
        this.LinkedList = new LinkedList();
    }

    public V get(K key) {
        MapNode<K, V> myMapNode = (MapNode<K, V>) this.LinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void add(K key, V value) {
        MapNode<K, V> MapNode = (MapNode<K, V>) this.LinkedList.search(key);
        if (MapNode == null) {
            MapNode = new MapNode<>(key, value);
            this.LinkedList.append(MapNode);
        } else {
            MapNode.setValue(value);
        }
    }

    @Override
    public String toString() {
        return "HashMapNodes{" + LinkedList + "}";
    }
}
