package cn.iecas.java.testconcurrence;
import java.util.concurrent.*;
public class ExceptionThread implements Runnable{
	public void run(){
		throw new RuntimeException();
	}
    public static void main(String[] args){
    	try{
    		ExecutorService exec = Executors.newCachedThreadPool();
        	exec.execute(new ExceptionThread());
    	}catch(RuntimeException e){
    		System.out.println("Exception has been handled");
    	}
    	
    }
}
