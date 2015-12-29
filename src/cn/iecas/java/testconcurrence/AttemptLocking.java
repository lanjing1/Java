package cn.iecas.java.testconcurrence;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class AttemptLocking {
	private ReentrantLock  lock = new ReentrantLock();
	public void untimed(){
		boolean captured = lock.tryLock();
		try{
			System.out.println("trylock "+captured);
		}finally{
			if(captured)
				lock.unlock();							
		}
	}
	public void timed(){
		boolean captured = false;
		try{
			captured = lock.tryLock(2, TimeUnit.SECONDS);			
		}catch(InterruptedException e){
			throw new RuntimeException(e);
		}
		try{
			System.out.println("tryLock(2,TimeUnit.SECONDS"+captured);
		}finally{
			if(captured)
				lock.unlock();
		}
		
	}
	public static void main(String[] args){
//		int testa = 1;
//		char testb = '2';
//		String testc = "2";
//		System.out.println("_____________________");
//		System.out.println(testa+testc);
//		System.out.println("_____________________");
		final AttemptLocking al =  new AttemptLocking();
		al.untimed();
		al.timed();
		new Thread(){
			{setDaemon(true);}
			public void run(){
				al.lock.lock();
				System.out.println("acquired");
			}
		}.start();
		Thread.yield();
		al.untimed();
		al.timed();
	}

}
