class LRUCache {

    Node head= null, tail = null;
    private int capacity, currCap = 0;

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val, Node prev, Node next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        //System.out.println("capacity: " + this.capacity);
    }
    
    public int get(int key) {
        int value = -1;
        if(map.containsKey(key)){
            value = map.get(key).val;
            markNodeToRecent(map.get(key));
        }
        if(value == -1){
            //System.out.println(key + " not found");
        }
        return value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            markNodeToRecent(node);
        }else{
            Node node = new Node(key, value);
            addNode(node);
            map.put(key,node);
        }  
    }
    private void addNode(Node node){
        //System.out.println("Adding " + node.key);
        if(tail == null){
            tail = node;
            head = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        this.currCap++;
        checkCapacity();
        

    }
    private void checkCapacity(){
        if(this.currCap > this.capacity){
            //System.out.println("Current Cap at " + this.currCap + "  Deleting " + head.key);
            removeHead();
            currCap--;
        }
    }
    private void removeHead(){
        if(head != null){
            Node n = head;
            head = head.next;
            head.prev = null;
            n.next = null; 
            map.remove(n.key);
        }
    }

    private void markNodeToRecent(Node node){
        //System.out.println("Marking recent: " + node.key);
        if(tail == node){
            return;
        }
        if(head == node){
            head = node.next;
            head.prev = null;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
        return;
    }
}
