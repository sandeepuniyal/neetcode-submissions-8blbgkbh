class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] result = new int[temperatures.length];
        for(int i=temperatures.length; i>=0; i--){
            for(int j = i+1; j< temperatures.length;){
                if(temperatures[j] > temperatures[i]){
                    result[i] = j-i;
                    break;
                }else if(result[j] > 0){
                    j = j + result[j];
                }else{
                    break;
                }
            }
        }
        
        return result;
    }
}
