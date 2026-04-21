class Solution {
    private static final char DELIMITER = '\u00A7';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s);
            sb.append(DELIMITER);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decode = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()){
            if(c == DELIMITER){
                decode.add(sb.toString());
                sb = new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        return decode;
    }
}
