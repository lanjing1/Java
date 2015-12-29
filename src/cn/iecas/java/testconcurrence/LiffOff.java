package cn.iecas.java.testconcurrence;
//��ʾ����֮ǰ�ĵ���ʱ
public class LiffOff implements Runnable{
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiffOff(){};
	public LiffOff(int countDown){
		this.countDown = countDown;
	}
	public String status(){
		return "#"+ id + "(" +(countDown>0 ? countDown : "LiffOff") + ")";
	}
    public void run(){
    	while(countDown-- >0){
    		
    		System.out.print(status());
    		Thread.yield();	//���̵߳�������һ�ֽ��顣�ò���	
    	}
    }
}
