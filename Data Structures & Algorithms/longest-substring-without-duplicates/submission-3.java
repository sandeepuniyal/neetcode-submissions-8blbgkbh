class Solution {
    public int lengthOfLongestSubstring(String s) {
         Set<Character> window = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            // Shrink window until duplicate is removed
            while (window.contains(ch)) {
                window.remove(s.charAt(left));
                left++;
            }

            // Expand window
            window.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
