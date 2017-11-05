## 1.Double Linked List + HashMap
```java
class LRUCache {
    HashMap<Integer,Node> map;
    int CAP, count;
    Node head;
    Node tail;

    public LRUCache(int CAP) {
        this.CAP = CAP;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
        
        head.pre = null;
        tail.next = null;
        count = 0;
    }
    
    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    public void addToHead(Node node){
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
    
    public int get(int key) {
        if( map.containsKey(key) ){
            Node node = map.get(key);
            int res = node.value;
            deleteNode(node);
            // least recently used
            addToHead(node);
            return res;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if( map.containsKey(key) ){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
            
        } else {
            Node node = new Node(key,value);
            map.put(key,node);
            if( count < CAP ){
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}

class Node{
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
```
 
## LinkedHashMap
```java

class LRUCache {
    Map<Integer,Integer> map;
    int CAP;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.CAP = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key,value);
        }
        else if(map.size() == CAP) map.remove(map.entrySet().iterator().next().getKey());
        map.put(key,value);
    }
}
```


