package tasktimer;

import static java.lang.System.out;

import java.io.InputStream;
import java.util.Scanner;

public class Task1 implements Runnable{
    /**
     * Process all the words in a file using Scanner to read and parse input.
     * Display summary statistics and elapsed time.
     */

	@Override
	public void run() {
		
        // initialize: open the words file as InputStream
        //InputStream instream = TaskTimer.class.getClassLoader().getResource(Dictionary.getWordsAsStream());
        Scanner in = new Scanner(Dictionary.getWordsAsStream());
        
        
        // perform the task
        int count = 0;
        long totalsize = 0;
        while(in.hasNext()) {
            String word = in.next();
            totalsize += word.length();
            count++;
        }
        double averageLength = ((double)totalsize)/(count>0 ? count : 1);
        out.printf("Average length of %,d words is %.2f\n", count, averageLength);
		
	}
	public String toString(){
		return String.format("Starting task: read words using Scanner and a while loop");
	}
	
}
