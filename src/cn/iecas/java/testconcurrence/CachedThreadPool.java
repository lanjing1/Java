package cn.iecas.java.testconcurrence;
import java.util.concurrent.*;
//executor 在客户端和任务执行之间提供了一个间接层，管理thread对象，执行任务。
//FixExecutor 限制线程的数量，不用为每个任务都固定付出创建线程的开销。
public class CachedThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ExecutorService exec = Executors.newSingleThreadExecutor();
		//ExecutorService exec = Executors.newFixedThreadPool(5);
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i<5; i++){
			exec.execute(new LiffOff());
		}
		exec.shutdown();
    
	}

}
