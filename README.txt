# TwitterConsole

The implementation is based on Java SE 1.8. The IDE used is eclipse. 
The solution consists of project folders
	TwitterConsoleCommons/  
	TwitterConsoleDomainInterface/  
	TwitterConsoleFileInputReaderImplementation/  
	TwitterConsoleMain/  
	TwitterConsoleUnitTest/. 

The projects can be imported into the eclipse IDE and tested there. Otherwise any other Java IDE, like Netbeans or IntelliJ, can be used.
JUnit is the Java api that has been used for the unit tests in the test project "TwitterConsoleUnitTest/"(JUnit library is already included in this project)
The following assumptions have been made:
-invalid data will be ignored in the console output and logged to a log file
-user will be prompted for file path input through the console


TwitterConsoleMain/  is the main project that contains the Java main program TwitterConsoleMain.java. config.properties in the same project configures the class implementation of the file reader implementation, which can be changed to use any implementation of FileInputReader interface.