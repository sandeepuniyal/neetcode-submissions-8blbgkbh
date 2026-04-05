class MinStack {
    List<Integer> stack;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        minHeap.offer(val);
    }
    
    public void pop() {
        int val = top();
        minHeap.remove(val);
        stack.remove(stack.size() - 1);

    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}
