public class LRUCache {
    private int capacity;
	private LRUCacheEntry<Integer, Integer> head;
	private LRUCacheEntry<Integer, Integer> tail;
	private HashMap<Integer, LRUCacheEntry<Integer, Integer>> map;  
	        
	public LRUCache(int capacity) {
	    if (capacity > 0) {
	        this.capacity = capacity;
	        this.head = null;
	        this.tail = null;
			this.map = new HashMap<Integer, LRUCacheEntry<Integer, Integer>>(this.capacity);
	    }
	}
	        
	public int get(int key) {
	    LRUCacheEntry<Integer, Integer> cacheEntry = refreshKey(key);
	    if(cacheEntry != null) {
	        return cacheEntry.getValue();
	    } else {
	                return -1;
	    }
	}
	        
	public void set(int key, int value) {
	    LRUCacheEntry<Integer, Integer> cacheEntry  = refreshKey(key);
	    if(cacheEntry != null){
	        cacheEntry.setValue(value);
	    } else {
	        if(map.size() == capacity){
	            map.remove(head.getKey());
	            if(head == tail){
	                head = null;
	                tail = null;
	            }else{
	                head = head.getNext();
	                head.setPrev(null);
	            }
	        }
			cacheEntry = new LRUCacheEntry<Integer, Integer>();
			cacheEntry.setKey(key);
	        cacheEntry.setValue(value);
	        if(head == null && tail == null){//0 node
                head = cacheEntry;
                tail = head;
            } else if (head == tail){// 1 node
                head.setNext(cacheEntry);
                cacheEntry.setPrev(head);
                tail = cacheEntry;
            } else { // nodes
                tail.setNext(cacheEntry);
                cacheEntry.setPrev(tail);
                tail = cacheEntry;
            }
            map.put(key, cacheEntry);
	    }
	}
	        
	private LRUCacheEntry<Integer, Integer> refreshKey(int key){
	    LRUCacheEntry<Integer, Integer> cacheEntry = map.get(key);
	    if(cacheEntry != null && cacheEntry.getNext() != null) {
			//matching & not tail
	        LRUCacheEntry<Integer, Integer> prev = cacheEntry.getPrev();
	        LRUCacheEntry<Integer, Integer> next = cacheEntry.getNext();
	        if(prev == null){
				//matching head
	            next.setPrev(null);
	            head = next;
	        }else{
	            prev.setNext(next);
	            next.setPrev(prev);
	        }
	        cacheEntry.setNext(null);
	        cacheEntry.setPrev(tail);
	        tail.setNext(cacheEntry);
	        tail = cacheEntry;
	    }
	    return cacheEntry;
	}


    class LRUCacheEntry<K, V>{
        private K key;
        private V value;
        private LRUCacheEntry<K, V> next;
        private LRUCacheEntry<K, V> prev;

        public void setKey(K key){
            this.key = key;
        }
    
        public void setValue(V value){
            this.value = value;
        }
    
        public void setNext(LRUCacheEntry<K, V> next){
            this.next = next;
        }
    
        public void setPrev(LRUCacheEntry<K, V> prev){
            this.prev = prev;
        }
    
        public K getKey(){
            return key;
        }
    
        public V getValue(){
            return value;
        }
    
        public LRUCacheEntry<K, V> getNext(){
            return this.next;
        }
    
        public LRUCacheEntry<K, V> getPrev(){
            return this.prev;
        }
    }
}