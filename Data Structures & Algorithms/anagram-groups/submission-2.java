class Solution {

    private boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        
        int[] hash = new int[26];
        for(int i=0; i< s1.length(); i++){
            hash[s1.charAt(i) - 'a'] += 1;
            hash[s2.charAt(i) - 'a'] -= 1;
        }
        for(int i= 0; i<26; i++){
            if(hash[i] != 0)
                return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList();
        }
        if(strs.length == 1){
            return Arrays.asList(Arrays.asList(strs));
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        ArrayList<ArrayList<String>> sortedList = new ArrayList<>();
        List<List<String>> finalResults = new ArrayList<>();

        int prevLen = strs[0].length();
        ArrayList<String> result = new ArrayList();
        for(String str: strs){
            if(prevLen == str.length()){
                result.add(str);
            }else{
                if(result.size() > 0){
                    sortedList.add(result); //flush existing list
                }
                prevLen = str.length();
                result = new ArrayList<>();
                result.add(str);
            } 
        }
        if(result != null && result.size() > 0){
            sortedList.add(result);
        }   

        for(ArrayList<String> list: sortedList){
            ArrayList<String> finalSubResult = null;
            boolean[] visited = new boolean[list.size()];
            for(int i = 0; i< list.size(); i++){
                if(visited[i]){
                    continue;
                }
                finalSubResult = new ArrayList();
                visited[i] = true;
                finalSubResult.add(list.get(i));
                for(int j= i+1; j< list.size(); j++){
                    if(!visited[j] && isAnagram(list.get(i), list.get(j))){
                        finalSubResult.add(list.get(j));
                        visited[j] = true;
                    }
                }
                finalResults.add(finalSubResult);
            }
        } 
        return finalResults;
    }
}
