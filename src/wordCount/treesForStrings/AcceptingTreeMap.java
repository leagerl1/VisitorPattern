package wordCount.treesForStrings;

import java.util.TreeMap;
import wordCount.visitors.Visitor;

public class AcceptingTreeMap extends TreeMap<String,Integer>{
    public void accept(Visitor visitor, String line){
	visitor.visit(this, line);
    }
}