package twitterconsole.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import twitterconsole.filereader.FileInputReader;

public class FileInputReaderFactory {

	public static FileInputReader buildFileReader() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{		
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);
			
		String fileInputImplementationClassName = prop.getProperty("fileInputImplementation");
		FileInputReader fileInputReader = (FileInputReader) Class.forName(fileInputImplementationClassName).newInstance();
		return fileInputReader;
	}
}
