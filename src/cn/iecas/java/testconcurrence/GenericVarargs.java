package cn.iecas.java.testconcurrence;
import java.util.*;
//���ͷ�����ɱ�����б��ܺܺõĹ���
public class GenericVarargs {
	public static <T> List<T> makeList(T... args){
		List<T> result = new ArrayList<T>();
		for(T item : args){
			result.add(item);
		}
		return result;
	}
	public static void main(String[] args){
		List<String> ls = makeList("a");
		System.out.println(ls);
		ls = makeList("a","b");
		System.out.println(ls);
		ls =  makeList("abcdefg".split(" "));
		System.out.println(ls);
	}

}
