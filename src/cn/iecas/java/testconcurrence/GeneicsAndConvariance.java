package cn.iecas.java.testconcurrence;
//����-ͨ���
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
		//error��һ��ִ����������ת�ͣ�����ʧ�������д����κζ���������������Ǵ���ObjectҲ����
//		flist.add(new Apple());
//		flist.add(new Fruit());
//		flist.add(new Object());
		flist.add(null);//legal but uninteresting
		// TODO Auto-generated method stub

	}

}
