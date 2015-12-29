package cn.iecas.java.testconcurrence;
//显示发射之前的倒计时
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
    		Thread.yield();	//对线程调度器的一种建议。让步。	
    	}
    }
}
