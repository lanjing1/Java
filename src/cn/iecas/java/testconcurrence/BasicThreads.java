package cn.iecas.java.testconcurrence;
//使用Thread类来驱动liffoff对象
public class BasicThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Thread t = new Thread(new LiffOff());
		//为该线程执行必须的初始化操作
		t.start();*/
		for(int i = 0; i<5; i++){
			new Thread(new LiffOff()).start();
		}
		System.out.println("Waiting for liffoff");
	}
}
