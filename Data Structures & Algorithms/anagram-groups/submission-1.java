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
        //System.out.println(sortedList);


        for(ArrayList<String> list: sortedList){
            //System.out.println(list);
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
/*
                String s1 = list.get(i);
                boolean anyMatch = false;
                for(int j= i+1; j< list.size(); j++){
                    String s2 = list.get(j);
                
                    boolean match = isAnagram(s1, s2);
                
                    if(match){
                        //System.out.println(s1 + "  and " + s2 + " are anagrams");
                        anyMatch = true;
                        if(finalSubResult == null){
                            finalSubResult = new ArrayList<>();
                        }
                        if(!finalSubResult.contains(s1)){
                            finalSubResult.add(s1);
                        }
                        if(!finalSubResult.contains(s2)){
                            finalSubResult.add(s2);
                        }
                    }
                } 
                
                if(!anyMatch && finalSubResult!= null && !finalSubResult.contains(s1)){
                    //System.out.println("No match for " + s1 + ". Adding to final list");
                    finalResults.add(Arrays.asList(s1)); //If no match for s1, it will be anagram to itself
                }
            }
            if(finalSubResult != null){
                //System.out.println("Adding " + finalSubResult + " to final list");
                finalResults.add(finalSubResult);
            }
            */
        } 
        return finalResults;
    }
}
