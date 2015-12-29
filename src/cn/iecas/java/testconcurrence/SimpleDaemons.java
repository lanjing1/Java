package cn.iecas.java.testconcurrence;
import java.util.concurrent.*;
//import static net.mindview.util.Print.*;

public class SimpleDaemons implements Runnable{
	public void run(){
		try{
			while(true){
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			}
		}catch(InterruptedException e){
			System.out.println("sleep() interrupted");
		}
	}
	public static void main(String[] args){
//		for(int i=0; i<5; i++){
//			Thread daemon = new Thread(new SimpleDaemons());
//			daemon.setDaemon(true);
//			daemon.start();
//		}
			ExecutorService exec = Executors.newCachedThreadPool();
			for(int i=0; i<5; i++){
				exec.execute(new SimpleDaemons());
			}
		
		System.out.println("all daemons start");
		try {
			TimeUnit.MILLISECONDS.sleep(110);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
