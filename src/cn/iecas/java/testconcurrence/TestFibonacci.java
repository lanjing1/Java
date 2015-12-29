package cn.iecas.java.testconcurrence;
import java.util.Arrays;
import java.util.concurrent.*;

class Fibonacci implements Runnable{
	private int count = 0;
	private final int n;
	public Fibonacci(int n){
		this.n = n;
	}
	public int next(){
		return fib(count++);	
	}
	public int fib(int n){
		if(n<2)return 1;
		return fib(n-2)+fib(n-1);
	}
	public void run(){
		Integer[] sequence = new Integer[n];
		for(int i=0; i<n; i++){
			sequence[i] = next();	   
		}
		System.out.println("seq of "+n+Arrays.toString(sequence));
	}
}
public class TestFibonacci {
	public static void main(String[] args){
		for(int i=0; i<=5; i++){
			 new Thread(new Fibonacci(i)).start();
		}
	}

}
