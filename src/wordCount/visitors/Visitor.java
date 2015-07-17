package wordCount.visitors;

import wordCount.treesForStrings.AcceptingTreeMap;

public interface Visitor{
    public void visit(AcceptingTreeMap wordMap, String line);
}