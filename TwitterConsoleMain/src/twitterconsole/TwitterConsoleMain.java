/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterconsole;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitterconsole.domain.Tweet;

/**
 *
 * @author User1
 */
public class TwitterConsoleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userInputfilePath = "C:\\development\\workspace\\TwitterConsole\\user.txt";
        String tweetFeedInputfilePath = "C:\\development\\workspace\\TwitterConsole\\tweet.txt";
        Map<String,Set<String> > userProfileTable = null;
        List<Tweet> tweetFeedList = null;
        try {
            userProfileTable = FileInputReader.readUserList(new File(userInputfilePath));
            tweetFeedList = FileInputReader.readTweetFeedList(new File(tweetFeedInputfilePath));
            
            System.out.println("Users:");
            for(Map.Entry entry :userProfileTable.entrySet()) {
                String user = (String) entry.getKey();
                Set<String> userFollowingSet = (Set<String>)entry.getValue();
                System.out.println(entry.getKey() );                
                for(Tweet tweetFeed: tweetFeedList) {
                    boolean isPrintTweet = false;
                    if(user.equalsIgnoreCase(tweetFeed.getUser().trim()) ){
                        isPrintTweet = true;
                    }else {
                    	for(String userFollowing :userFollowingSet) {
                    		if(userFollowing.trim().equalsIgnoreCase(tweetFeed.getUser().trim()) ) {
                    			isPrintTweet = true;
                    			break;
                    		}
                    	}
                    }
                    if(isPrintTweet){
                        System.out.println(tweetFeed);
                    }
                }
            }
        } catch (IOException ex) {
            String errorMessage = "Could not read input file.";
            Logger.getLogger(TwitterConsoleMain.class.getName()).log(Level.SEVERE, errorMessage, ex);
        }
    }
    
    
}
