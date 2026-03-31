class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            while(!s.isEmpty() && temperatures[s.peek()] < temperatures[i]){
                result[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);
        }
        
        return result;
    }
}
