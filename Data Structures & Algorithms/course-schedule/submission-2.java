class Solution {
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> courseMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int[] p: prerequisites){
            if(courseMap.containsKey(p[0])){
                courseMap.get(p[0]).add(p[1]);
            }else{
                courseMap.put(p[0],new ArrayList<>(Arrays.asList(p[1])));
            }
        }
        for(int i=0; i< numCourses; i++){
            if(!dfs(courseMap,visited, i)){
                return false;
            }
        }
        
        return true;
    }

    private boolean dfs(HashMap<Integer,ArrayList<Integer>> courseMap, Set<Integer> visited, Integer node){
        if(visited.contains(node)){
                return false;
        }
        if(!courseMap.containsKey(node)){
            return true;
        }
        visited.add(node);
        for(Integer n: courseMap.get(node)){
            if(!dfs(courseMap,visited,n)){
                return false;
            }
        }
        visited.remove(node);
        courseMap.remove(node);
        return true;  
    }
}