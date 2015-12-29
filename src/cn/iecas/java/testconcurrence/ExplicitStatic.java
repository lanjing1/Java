package cn.iecas.java.testconcurrence;
import java.util.*;
class Cup{
	Cup(int marker){
		System.out.println("Cup"+marker);
	}
	void f(int marker){
		System.out.println("f"+marker);
	}
}
class Cups{
	static Cup cup1;
	static Cup cup2;
	static{
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	Cups(){
		System.out.println("cups()");
	}
}
public class ExplicitStatic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("inside main()");
		Cups.cup1.f(3);
		int[] a = {1,2,3};
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(a));

	}
	static Cups cc = new Cups();
}
