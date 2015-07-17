package wordCount.visitors;

import wordCount.visitors.Visitor;
import wordCount.treesForStrings.AcceptingTreeMap;
import wordCount.logger.MyLogger;

public class PopulateTreeVisitor implements Visitor{
    public void visit(AcceptingTreeMap wordMap, String line){
	MyLogger logger = MyLogger.getInstance();
	if(wordMap.containsKey(line)){
	    wordMap.put(line, wordMap.get(line) + 1);
	    logger.printMessage(2,"New instance of existing word found");
	}
	else{
	    wordMap.put(line, 1);
	    logger.printMessage(1, "New word found: Inserting new node");
	}
    }
}
