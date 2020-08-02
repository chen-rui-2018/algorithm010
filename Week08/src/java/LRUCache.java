import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/8/2 22:40
 * @version： v1.0
 * @modified By:
 */
public class LRUCache  extends LinkedHashMap<Integer,Integer> {
    private int capacity;
    public LRUCache(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }
    public int get (int key){
        return super.getOrDefault(key,-1);
    }
    public void put(int key ,int value){
        super.put(key,value);

    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
