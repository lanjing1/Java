package cn.iecas.java.testconcurrence;
import java.util.concurrent.*;
//executor �ڿͻ��˺�����ִ��֮���ṩ��һ����Ӳ㣬����thread����ִ������
//FixExecutor �����̵߳�����������Ϊÿ�����񶼹̶����������̵߳Ŀ�����
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
