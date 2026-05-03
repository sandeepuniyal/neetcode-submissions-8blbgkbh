class Twitter {
    class User{
        private int userId;
        private Set<Integer> follows;

        public User(int userId){
            this.userId = userId;
            follows = new HashSet<>();
        }

        public List<Integer> getFollowees(){
            return new ArrayList(follows);
        }

        public void follow(Integer followeeId){
            if(userId != followeeId){
                this.follows.add(followeeId);
            }   
        }

        public void unfollow(Integer followeeId){
            this.follows.remove(followeeId);
        }
    }
    public Twitter() {
        users = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    int timestamp = 0;
    HashMap<Integer, User> users;
    HashMap<Integer, ArrayList<int[]>> userTweets;
    
    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new User(userId));
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>())
                        .add(new int[]{tweetId, timestamp++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
      if(!users.containsKey(userId)) return new ArrayList<>();

      ArrayList<int[]> feed = new ArrayList<>();

      feed.addAll(userTweets.getOrDefault(userId, new ArrayList<>()));

      for(int followee: users.get(userId).getFollowees()){
        feed.addAll(userTweets.getOrDefault(followee, new ArrayList<>()));
      }  

      feed.sort((a,b) -> (b[1] - a[1]));
      return feed.subList(0,Math.min(10, feed.size()))
                        .stream()
                        .map(k -> k[0])
                        .collect(Collectors.toList());   
      //Collections.reverse(top10);      
      //return top10;            
    }
    
    public void follow(int followerId, int followeeId) {
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId)){
            users.get(followerId).unfollow(followeeId);
        }
    }
}