package wordCount.driver;

import wordCount.treesForStrings.AcceptingTreeMap;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.WordCountVisitor;
import wordCount.visitors.Visitor;
import wordCount.util.FileProcessor;
import wordCount.logger.MyLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Driver{
    public static void main(String[] args){

	int iterations = 0;
	int loggerVal = 0;
	try{
	    iterations = Integer.parseInt(args[2]);
	    loggerVal = Integer.parseInt(args[3]);
	}catch(NumberFormatException e){
	    System.err.println(e.getMessage());
	}
	MyLogger logger = MyLogger.getInstance();
	MyLogger.setLoggerVal(loggerVal);
	WordCountVisitor.setOutputFile(args[1]);

	long startTime = System.currentTimeMillis();
	for(int i = 0; i < iterations; i++){
	    
	    AcceptingTreeMap wordTree = new AcceptingTreeMap();
	    Visitor treePopulater = new PopulateTreeVisitor();
	    Visitor wordCounter = new WordCountVisitor();

	    try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
		    FileProcessor p = new FileProcessor(reader);
		    String line;
		    while((line = p.readALine()) != null){
			wordTree.accept(treePopulater, line);
		    }
		    wordTree.accept(wordCounter, line);
		}catch(IOException e){
		System.err.println("Error processing file");
		System.err.println(e.getMessage());
		System.exit(1);
	    }

	    
	    //process file
	    //visit
	}

	long finishTime = System.currentTimeMillis();
	long totalTime = (finishTime-startTime)/iterations;
	System.out.println("Exexcution time: " + totalTime);
    }
}
