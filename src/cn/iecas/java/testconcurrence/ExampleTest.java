package cn.iecas.java.testconcurrence;

public class ExampleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = 121;
		//char b = (char)c;
		switch(c){
		case 'a':System.out.println("a");break;
		case 'y':System.out.println("b");break;
		default:System.out.println(c);
		}
        if(c == 'y'){
        	System.out.println("true");
        }
	}

}
