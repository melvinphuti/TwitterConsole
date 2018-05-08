/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterconsole;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitterconsole.domain.Tweet;
import twitterconsole.factory.FileInputReaderFactory;
import twitterconsole.filereader.FileInputReader;

/**
 *
 * @author User1
 */
public class TwitterConsoleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
        String userInputfilePath = readInputFileNamePath("Enter the full file path of user input file(eg, 'c:\\user.txt'): ");
        String tweetFeedInputfilePath = readInputFileNamePath("Enter the full file path of tweets input file(eg, 'c:\\tweet.txt'): ");
        Map<String,Set<String> > userProfileTable = null;
        List<Tweet> tweetFeedList = null;
        try {
        	FileInputReader fileInputReader = FileInputReaderFactory.buildFileReader();
            userProfileTable = fileInputReader.readUserList(new File(userInputfilePath));
            tweetFeedList = fileInputReader.readTweetFeedList(new File(tweetFeedInputfilePath));
            
            System.out.println("Users:");
            for(@SuppressWarnings("rawtypes") Map.Entry entry :userProfileTable.entrySet()) {
                String user = (String) entry.getKey();
                @SuppressWarnings("unchecked")
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
        } catch (ClassNotFoundException e) {
            String errorMessage = "Could not load fileInputImplementation. Check config file";
            Logger.getLogger(TwitterConsoleMain.class.getName()).log(Level.SEVERE, errorMessage, e);
		} catch (InstantiationException e) {
            String errorMessage = "Unable to instantiate fileInputImplementation. Check config file";
            Logger.getLogger(TwitterConsoleMain.class.getName()).log(Level.SEVERE, errorMessage, e);
		} catch (IllegalAccessException e) {
            String errorMessage = e.getMessage();
            Logger.getLogger(TwitterConsoleMain.class.getName()).log(Level.SEVERE, errorMessage, e);
		}
    }

	private static String readInputFileNamePath(String userPrompt) {
		String filePath = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(userPrompt);
            filePath = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return filePath;
	}
}
