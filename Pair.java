public class Pair<K, V>{
    protected K key;
    protected V value;
    
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * @return the value
     */
    public V getValue() {
        return value;
    }
}