/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterconsole.filereader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import twitterconsole.domain.Tweet;

/**
 *
 * @author User1
 */
public interface FileInputReader {
    
    public Map<String,Set<String> > readUserList(File inputFile) throws IOException;
    public List<Tweet> readTweetFeedList(File inputFile) throws IOException;
}
