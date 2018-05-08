/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterconsole.domain;

/**
 *
 * @author User1
 */
public class Tweet {
    private final String message;
    private final String user;
    
    public Tweet(String user, String message){
        this.message = message;
        this.user =user;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }
    
    @Override
    public String toString(){
        String tweet = "@" + user + ": " + message;
        return tweet;
    }
}
