package cn.iecas.java.testconcurrence;
//ʹ��Thread��������liffoff����
public class BasicThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Thread t = new Thread(new LiffOff());
		//Ϊ���߳�ִ�б���ĳ�ʼ������
		t.start();*/
		for(int i = 0; i<5; i++){
			new Thread(new LiffOff()).start();
		}
		System.out.println("Waiting for liffoff");
	}
}
