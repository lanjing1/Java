package cn.iecas.java.testconcurrence;
import java.util.concurrent.*;
class ExceptionThread2 implements Runnable{
	public void run(){
		Thread t = Thread.currentThread();
		System.out.println("run by"+t);
		System.out.println(t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}
}
//Thread.UncaughtExceptionHandler.uncaughtException()会在线程因未捕获的异常而临近死亡时被调用
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
	public void uncaughtException(Thread t, Throwable e){
		System.out.println("caught"+e);
	}
}
class HandlerThreadFactory implements ThreadFactory{
	public Thread newThread(Runnable r){
		System.out.println(this + "creating new thread");
		Thread t = new Thread(r);
		System.out.println("created"+t);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println(t.getUncaughtExceptionHandler());
		return t;
	}
}
public class CaptureUncaughtException {
	public static void main(String[] args){
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		
		exec.execute(new ExceptionThread2());
	}
}
