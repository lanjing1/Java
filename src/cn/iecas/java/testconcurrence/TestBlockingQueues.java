package cn.iecas.java.testconcurrence;
import java.util.*;
import java.util.concurrent.*;
class LiftOffRunner implements Runnable{
	private BlockingQueue<LiftOff> rockets;
	public LiftOffRunner(BlockingQueue<LiftOff> queue){
		rockets = queue;
	}
	public void add(LiffOff lo){
		try{
			rockets.put(lo);			
		}catch(InterruptedException e){
			System.out.println("Interrupted during put()");
		}
	}
	public void run(){
		try{
			while(!Thread.interrupted())
		}
	}
}
public class TestBlockingQueues {

}
