package HashMap;

public class HashMap {
    private static int DEFAULT_SIZE = 16;

    private Node table[] = new Node[DEFAULT_SIZE];


    public Node get(String k) {
        int hash = k.hashCode() % DEFAULT_SIZE;
        Node temp = table[hash];

        // Bucket is identified by hashCode and traversed the bucket
        // till element is not found.
        while(temp != null) {
            if(temp.key.equals(k)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void put(String k, String v) {
        int hash = k.hashCode() % DEFAULT_SIZE;
        Node temp = table[hash];

        if(temp != null) {
            // If we will insert duplicate key-value pair,
            // Old value will be replaced by new one.
            if(temp.key.equals(k)) {
                temp.value = v;
            } else {
                // Collision: insert new element at the end of list
                // in the same bucket
                while(temp.next != null) {
                    temp = temp.next;
                }
                Node entryInOldBucket = new Node(k, v);
                temp.next = entryInOldBucket;
            }
        } else {
            // create new bucket for new element in the map.
            Node entryInNewBucket = new Node(k, v);
            table[hash] = entryInNewBucket;
        }
    }


    public static void main(String[] args) {
        HashMap myHashMap = new HashMap();

        myHashMap.put("Awadh", "SsssSE");
        myHashMap.put("Rahul", "SSE");
        myHashMap.put("Sattu", "SE");
        myHashMap.put("Gaurav", "SE");

        Node e = myHashMap.get("Awadh");
        System.out.println(""+e.getValue());
    }
}


// Use linked list to avoid the collisions
class Node{
    final String key;
    String value;
    Node next;
    Node (String key , String value){
        this.key = key;
        this.value = value;
    }
    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getKey(){
        return key;
    }
}

