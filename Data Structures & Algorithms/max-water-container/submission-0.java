class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int water = -1;
        while(l < r){
            int w = (r - l) * Math.min(heights[l], heights[r]);
            water = Math.max(water, w);
            if(heights[l] > heights[r]){
                --r;
            }else{
                l++;
            }
        }
        return water;
    }
}
