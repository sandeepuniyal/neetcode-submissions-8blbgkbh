class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if((c >= 'A' && c <= 'Z') || (c >= 'a' && c < 'z') || (c >= '0' && c < '9')  ){
                sb.append(String.valueOf(c));
            }
        }
        System.out.println(sb);
        int l=0, r=sb.length() - 1;
        while(l < r){
            if(Character.toLowerCase(sb.charAt(l)) != Character.toLowerCase(sb.charAt(r))){
                return false;
            }
            l++;
            --r;
        }
        return true;
    }
}
