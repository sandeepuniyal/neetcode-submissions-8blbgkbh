/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null ) return node;

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<Node>();
        map.put(node, new Node(node.val));
        queue.add(node);
        while(!queue.isEmpty() ){
            Node old = queue.poll();
            Node n = map.get(old);
            map.put(old, n);
            
            for(Node neighbor: old.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor); 
                }
                n.neighbors.add(map.get(neighbor));  
            } 
        }
        return map.get(node); 
    }
}