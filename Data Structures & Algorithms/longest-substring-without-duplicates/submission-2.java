class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char [] c = s.toCharArray();
        int l=0, r= 0, max=0;
        while(r < c.length){
            if(!set.contains(c[r])){
                set.add(c[r]);
                r++;
            }else{
                max = Math.max(max, r-l);
                while(c[l] != c[r]){
                    set.remove(c[l++]);
                }
                set.remove(c[l++]);
            }
        }
        return Math.max(max, r-l);
    }
}
