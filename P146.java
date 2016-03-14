import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*146. LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.*/

public class P146 {
	private Map<Integer, Integer> cache;
	
    public P146(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>() {
        	 @Override
             protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
               if(cache.size() > capacity) {
                 return true;
               }
               return false;
             }
        };
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
        	int value = cache.get(key);
        	cache.remove(key);
        	cache.put(key, value);
        	return value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
    	cache.put(key, value);
    	cache.remove(key);
        cache.put(key,value);
    }
    
    public static void main(String[] args) {
    	P146 test = new P146(2);
    	test.set(2, 1);
    	test.set(1, 1);
    	test.set(2, 3);
    	test.set(4, 1);
    	System.out.println(test.get(1));
    	System.out.println(test.get(2));
    }
    
}
