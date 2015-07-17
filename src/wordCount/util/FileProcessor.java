package wordCount.util;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class FileProcessor{
    private BufferedReader reader;
    private PrintWriter writer;

    public FileProcessor(BufferedReader readerIn){
	reader = readerIn;
    }

    public FileProcessor(PrintWriter writerIn){
	writer = writerIn;
    }

    public void writeALine(int line){
	    writer.println(line);
    }

    public String readALine(){
	String line = null;
	try{
	    line = reader.readLine();
	}catch(IOException e){
	    System.err.println(e.getMessage());
	    System.exit(1);
	}
	return line;
    }
}