package cn.iecas.java.testconcurrence;
import java.util.concurrent.*;
import java.util.*;
//声明一个泛型，call()函数返回的类型就是传递进来的类型
class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id){
		this.id = id;		
	}
	public String call(){
		return "result:" + id;
	}
	
}
public class CallableDemo{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0;i<5;i++){
			results.add(exec.submit(new TaskWithResult(i)));			
		}
        for(Future<String> rs: results){
        	try{
        		System.out.println(rs.get());
        	}catch(InterruptedException e){
        		System.out.println(e);
        		return;
        	}catch(ExecutionException e){
        		System.out.print(e);
        	}finally{
        		exec.shutdown();
        	}      	
        }
	}

}
