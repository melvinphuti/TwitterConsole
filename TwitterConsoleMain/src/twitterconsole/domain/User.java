package twitterconsole.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class User implements Comparable<User>{

    private final String username;
    private Set<String> userFollwingList;

    public User(String username) {
        this.username = username; 
        userFollwingList = new TreeSet<>();
    }

    /**
    * @return the username
    */
    public String getUsername() {
          return username;
    }
    
    @Override
    public int compareTo(User user){
        return username.toLowerCase().compareToIgnoreCase(user.getUsername() );
    }
    
    @Override
    public String toString(){
        return getUsername();
    }

    public Set<String> getUserFollwingList() {
        return userFollwingList;
    }
    
    public void addUserFollowing(String user){
        userFollwingList.add(user);
    }
}