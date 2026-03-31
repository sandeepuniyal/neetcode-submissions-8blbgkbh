class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Pair<Integer,Integer>> arr = new ArrayList<>();
        
        for(int i=0; i< position.length; i++){
            Pair<Integer,Integer> p = new Pair<>(position[i], speed[i]);
            arr.add(p);
        }
        arr.sort((p1, p2) -> Integer.compare(p2.getKey(), p1.getKey()));

        double lastTime = 0;
        int fleets =0;

        for(Pair<Integer,Integer> p : arr){
            double time = (target - p.getKey()) / (double)p.getValue();
            if(time > lastTime){
                fleets++;
                lastTime = time;
            }
        }
        
        return fleets;
    }
}
