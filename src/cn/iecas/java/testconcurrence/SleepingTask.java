package cn.iecas.java.testconcurrence;
import java.util.Random;
import java.util.concurrent.*;
import java.util.*;
public class SleepingTask extends LiffOff {
	Random r1 = new Random(1);
	
	public void run(){
		/*try{
			while(countDown-- >0){
				System.out.print(status());
				TimeUnit.MILLISECONDS.sleep(100);
			}
		}catch(InterruptedException e){
			System.out.print(e);
		}*/
		
			try {
				int n1 = r1.nextInt(10);				
				TimeUnit.MILLISECONDS.sleep(n1);
				System.out.println(n1);
				return;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i<5; i++){
			exec.execute(new SleepingTask());
		}
		exec.shutdown();
	}

}
