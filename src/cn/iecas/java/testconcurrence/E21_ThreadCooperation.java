package cn.iecas.java.testconcurrence;
import java.util.*;
import java.util.concurrent.*;
class Coop1 implements Runnable{
	public Coop1(){ System.out.println("constructed coop1");}
	public void run(){
		System.out.println("coop1 going into wait");
		synchronized(this){
			try {
				wait();
			} catch (InterruptedException e) {}
				// TODO Auto-generated catch block
				//e.printStackTrace();
			System.out.println("coop1 exited wait");
		}
		
	}
	
}
class Coop2 implements Runnable{
	Runnable otherTask;
	public Coop2(Runnable otherTask){
		this.otherTask = otherTask;
		System.out.println("constructed coop2");
	}
	
	public void run(){
		System.out.println("coop2 pausing 5 seconds");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {}
			// TODO Auto-generated catch block
			//e.printStackTrace();
		System.out.println("coop2 calling notifyAll");
	    synchronized(otherTask){
	        otherTask.notifyAll();	
		    
		}
	}
}
public class E21_ThreadCooperation {
	public static void main(String[] args) throws Exception{
		Runnable coop1 = new Coop1(),
				 coop2 = new Coop2(coop1);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(coop1);
		exec.execute(coop2);
		Thread.yield();
		exec.shutdown();
	}

}
