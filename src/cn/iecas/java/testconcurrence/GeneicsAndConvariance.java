package cn.iecas.java.testconcurrence;
//泛型-通配符
import java.util.*;
class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Oriange extends Fruit{}
public class GeneicsAndConvariance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<? extends Fruit> flist = new ArrayList<Apple>();
		//error。一旦执行这种向上转型，将丢失掉向其中传递任何对象的能力，甚至是传递Object也不行
//		flist.add(new Apple());
//		flist.add(new Fruit());
//		flist.add(new Object());
		flist.add(null);//legal but uninteresting
		// TODO Auto-generated method stub

	}

}
