class TimeMap {

    class Node{
        String key;
        String value;
        Integer timestamp;
        Node next;

        public Node(String key, String value, Integer timestamp){
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
            next = null;
        }
    }
    HashMap<String, Node> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Node node = new Node(key, value, timestamp);
        if(store.containsKey(key)){
            //System.out.println(key + " already present .. appending");
            Node head = store.get(key);
            while(head.next != null){
                head = head.next;
            }
            head.next = node;
        }else{
            //System.out.println(key + " not present .. Adding");
            store.put(key, node);
        }
        
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)){
            //System.out.println(key + " not present .. ");
            return "";
        }
        Node head = store.get(key);
        while(head.next != null && head.next.timestamp <= timestamp){
            head = head.next;
        }
        return (head.timestamp <= timestamp) ? head.value : "";
    }
}
