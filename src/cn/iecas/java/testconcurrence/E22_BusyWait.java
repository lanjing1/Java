package cn.iecas.java.testconcurrence;
import java.util.*;
import java.util.concurrent.*;



public class E22_BusyWait {
	private static volatile boolean flag ;
	private static int spins;
	public static void main(String[] args) throws Exception{
		Runnable r1 = new Runnable(){
			public void run(){
				for(;;){
					try{
						TimeUnit.SECONDS.sleep(5);
					}catch(InterruptedException e){ return;}
					flag = true;			
				}  	
		    }
		};	 
	    Runnable r2 = new Runnable(){
	    	public void run(){
	    		for(;;){//the busy-wait loop
	    			while(!flag &&
	    					!Thread.currentThread().isInterrupted())
	    				spins++;
	    			System.out.println("spun "+spins+"times");
	    			spins = 0;
	    			flag = false;
	    			if(Thread.interrupted())
	    				return;
	    		}
	    	}
	    };
	    ExecutorService exec = Executors.newCachedThreadPool();
	    exec.execute(r1);
	    exec.execute(r2);
	    TimeUnit.SECONDS.sleep(1);
	    exec.shutdown();  
	
	}
}
