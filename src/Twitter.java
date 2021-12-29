import java.util.*;

class Twitter {

    List<Feed> feeds;
    Map<Integer, User> users;
    public Twitter() {
        feeds = new LinkedList<>();
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        users.computeIfAbsent(userId, k ->new User(userId));
        Feed feed = new Feed(tweetId, userId);
        feeds.add(feed);


    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();
        User user = users.get(userId);
        if(user == null) {
            return result;
        }
        Set<Integer> followingUserFeeds = user.following;
        int count = 10;
        int totalFeeds = feeds.size();
        while(totalFeeds > 0 && count >= 0) {
            Feed feed = feeds.get(totalFeeds-1);
            if(followingUserFeeds.contains(feed.userId)) {
                result.add(feed.id);
                count--;
            }
            totalFeeds--;

        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        User followerUser = users.computeIfAbsent(followerId, k-> new User(followerId));
        followerUser.following.add(followeeId);
        User followeeUser = users.computeIfAbsent(followeeId, k-> new User(followeeId));
        followeeUser.followers.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User followerUser = users.get(followerId);
        followerUser.following.remove(followeeId);
        User followeeUser= users.get(followerId);
        followeeUser.followers.remove(followerId);

    }

    public class User {
        int id;
        Set<Integer> followers;
        Set<Integer> following;

        public User(int id) {
            this.id = id;
            followers = new HashSet<>();
            following = new HashSet<>();
            following.add(id);
        }
    }

    public class Feed {
        int id;
        int userId;
        public Feed(int tweetId, int userId){
            this.id = tweetId;
            this.userId = userId;
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.postTweet(1,3);
        twitter.postTweet(1,101);
        twitter.postTweet(1,13);
        twitter.postTweet(1,10);
        twitter.postTweet(1,2);
        twitter.postTweet(1,94);
        twitter.postTweet(1,505);
        twitter.postTweet(1,333);
        twitter.postTweet(1,22);
        twitter.postTweet(1,11);
        twitter.getNewsFeed(1);

    }
}
