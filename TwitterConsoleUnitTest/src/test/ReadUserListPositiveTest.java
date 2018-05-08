package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import twitterconsole.domain.Tweet;
import twitterconsole.factory.FileInputReaderFactory;
import twitterconsole.filereader.FileInputReader;

public class ReadUserListPositiveTest {

	@Test
	public void test() {
		try {
	        String userInputfilePath = "user.txt";
	        String tweetFeedInputfilePath = "tweet.txt";
			FileInputReader fileInputReader = FileInputReaderFactory.buildFileReader();
			Map<String, Set<String>> userProfileTable = fileInputReader.readUserList(new File(userInputfilePath));
			List<Tweet> tweetFeedList = fileInputReader.readTweetFeedList(new File(tweetFeedInputfilePath));
			
			if(userProfileTable == null || userProfileTable.isEmpty() ){
				fail("user list empty");
			}
			if(tweetFeedList == null || tweetFeedList.isEmpty() ){
				fail("tweetFeedList empty");
			}
		} catch (Exception e) {
			fail(e.getMessage() );
			e.printStackTrace();
		}
	}

}
