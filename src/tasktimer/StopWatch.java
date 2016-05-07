package tasktimer;

public class StopWatch {

    private long starttime ;
    private long stoptime ;
    private boolean running;
    
    public void start(){
    	starttime = System.nanoTime();
    }
    public void stop(){
    	stoptime = System.nanoTime();
    }
    public double getElapsed(){
    	return stoptime - starttime;
    }
}
