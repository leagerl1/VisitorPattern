package wordCount.visitors;

import wordCount.visitors.Visitor;
import wordCount.treesForStrings.AcceptingTreeMap;
import wordCount.util.FileProcessor;
import java.util.Map;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WordCountVisitor implements Visitor{
    public static String outputFile;

    public static void setOutputFile(String outputFileIn){
	outputFile = outputFileIn;
    }

    public void visit(AcceptingTreeMap wordMap, String line){
	int wordCount = 0;
	int charCount = 0;
	int uniqueWordCount = 0;
	for(Map.Entry<String,Integer> entry : wordMap.entrySet()){
	    charCount += entry.getKey().length();
	    wordCount += entry.getValue();
	    uniqueWordCount++;
	}
	try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, false)))) {
	      	FileProcessor p = new FileProcessor(writer);
		p.writeALine(charCount);
		p.writeALine(wordCount);
		p.writeALine(uniqueWordCount);
	    }catch (IOException e) {
            System.err.println("Error printing to file");
            System.err.println(e.getMessage());
            System.exit(1);
	}


    }
}