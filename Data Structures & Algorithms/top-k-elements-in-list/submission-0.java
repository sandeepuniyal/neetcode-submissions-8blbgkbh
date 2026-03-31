class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, (map.get(n) == null) ? 1 : map.get(n) + 1 );
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        //System.out.println(list);
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        //System.out.println(list);
        int[] a = new int[k];
        for(int i=0; i<k; i++){
            a[i]= list.get(i).getKey();
        }
        return a;
    }
}
