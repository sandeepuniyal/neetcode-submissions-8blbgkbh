class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for(char task: tasks){
            freq[task - 'A'] += 1;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[1],a[1])
        );
        for(int i=0; i<26; i++){
            if(freq[i] > 0) { maxHeap.add(new int[]{i,freq[i]}); }
        }
        int time = 0;
        Queue<int[]> cooldown = new LinkedList<>();

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            time++;
        
            if(!cooldown.isEmpty() && cooldown.peek()[2] <= time){
                int[] task = cooldown.poll();
                maxHeap.add(new int[]{task[0], task[1]});
            }
            
            if (!maxHeap.isEmpty()){
                int[] task = maxHeap.poll();
                int remainingFreq = --task[1];
                if(remainingFreq > 0){
                    cooldown.add(new int[]{task[0], remainingFreq, time+n+1});
                }
            }          
        }
        return time;

    }
}
