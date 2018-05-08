/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterconsole;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitterconsole.domain.Tweet;
import twitterconsole.exception.StringValidationException;
import twitterconsole.validation.StringValidationMessageEnum;
import twitterconsole.validation.UserProfileValidator;

/**
 *
 * @author User1
 */
public class FileInputReader {
    private static final String USER_FILE_LINE_INPUT_SEPARATOR = " follows ";
    private static final String USER_FOLLOWING_FILE_LINE_INPUT_SEPARATOR = ",";
    private static final String TWEET_FEED_FILE_LINE_INPUT_SEPARATOR = ">";
    
    public static Map<String,Set<String> > readUserList(File inputFile) throws IOException{
        Map<String,Set<String> >  userList = new TreeMap<>();
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNext()){
                String userFileInputLine = scanner.nextLine().trim();
                if(!userFileInputLine.isEmpty() ){
                    userList = addToUserList(userList, userFileInputLine);
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return userList;
    }

    public static List<Tweet> readTweetFeedList(File inputFile) throws IOException {
        List<Tweet> tweetFeedList = new ArrayList<>();
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNext()){
                String userFileInputLine = scanner.nextLine().trim();
                if(!userFileInputLine.isEmpty() ){
                    tweetFeedList = addToTweetFeedList(tweetFeedList, userFileInputLine);
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return tweetFeedList;
    }

    private static Map<String,Set<String> > addToUserList(Map<String,Set<String> > userList, String userFileInputLine) {
        try {
            validateUserFileInputLine(userFileInputLine);  
            //no exception thrown if valid
            String[] userLine = userFileInputLine.split(USER_FILE_LINE_INPUT_SEPARATOR);
            String userString = userLine[0].trim();
            Set<String> userFollowingSet = new TreeSet<>();
            String[] userFollowingList = userLine[1].split(USER_FOLLOWING_FILE_LINE_INPUT_SEPARATOR);
            for(String userFollowing :userFollowingList){
                userFollowing = userFollowing.trim();
                userFollowingSet.add(userFollowing);
                if(userList.get(userFollowing) == null){
                    userList.put(userFollowing, new TreeSet<>() );
                }
            }     
            
            Set<String> userSet = userList.get(userString);
            if(userSet != null){
                userSet.addAll(userFollowingSet);
            }else{
                userList.put(userString, userFollowingSet);
            }            
        } catch (StringValidationException ex) {
            String warningMessage = "Invalid user input line: [" + userFileInputLine + "]";
            Logger.getLogger(FileInputReader.class.getName()).log(Level.WARNING, warningMessage, ex);
        }
        return userList;
    }

    private static void validateUserFileInputLine(String userFileInputLine) throws StringValidationException {        
        String[] userLine = userFileInputLine.split(USER_FILE_LINE_INPUT_SEPARATOR);
        if(userLine.length != 2){
            throw new StringValidationException(StringValidationMessageEnum.INVALID_LINE_INPUT);
        }        
        String user = userLine[0];        
        UserProfileValidator.validateUsername(user); 
        String[] userFollowingList = userLine[1].split(USER_FOLLOWING_FILE_LINE_INPUT_SEPARATOR);
        for(String userFollowing :userFollowingList){
            userFollowing = userFollowing.trim();
            if(!userFollowing.isEmpty() ){
                UserProfileValidator.validateUsername(userFollowing.trim() ); 
            }
        }
    }

    private static List<Tweet> addToTweetFeedList(List<Tweet> tweetFeedList, String tweetFeedFileInputLine) {
        try {
            validateTweetFeedFileInputLine(tweetFeedFileInputLine);
            //no exception if valid
            String[] tweetFeedLine = tweetFeedFileInputLine.split(TWEET_FEED_FILE_LINE_INPUT_SEPARATOR);
            //TODO: validate
            String user = tweetFeedLine[0];//TODO: validate user existence
            String tweet = tweetFeedLine[1];//TODO: validate size
            tweetFeedList.add(new Tweet(user, tweet) );
        } catch (StringValidationException ex) {
            String warningMessage = "Invalid tweet feed input line: [" + tweetFeedFileInputLine + "]";
            Logger.getLogger(FileInputReader.class.getName()).log(Level.WARNING, warningMessage, ex);
        }
        return tweetFeedList;
    }

    private static void validateTweetFeedFileInputLine(String tweetFeedFileInputLine) throws StringValidationException {
        String[] tweetFeedLine = tweetFeedFileInputLine.split(TWEET_FEED_FILE_LINE_INPUT_SEPARATOR);
        if(tweetFeedLine.length != 2){
            throw new StringValidationException(StringValidationMessageEnum.INVALID_LINE_INPUT);
        }
    }
}
