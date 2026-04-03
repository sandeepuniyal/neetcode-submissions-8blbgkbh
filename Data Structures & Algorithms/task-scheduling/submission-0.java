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
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->
            Integer.compare(a[1],b[1]));

        while(!maxHeap.isEmpty() || !minHeap.isEmpty()){
            time++;
            int[] task;

            if(!minHeap.isEmpty() && minHeap.peek()[1] <= time){
                task = minHeap.poll();
                maxHeap.add(new int[]{task[0], freq[task[0]]});
            }
            
            if (!maxHeap.isEmpty()){
                task = maxHeap.poll();
                int remainingFreq = --freq[task[0]];
                if(remainingFreq > 0){
                    minHeap.add(new int[]{task[0], time+n+1});
                }
            }            
        }
        return time;

    }
}
