package cn.iecas.java.testconcurrence;
import java.util.*;
class Gerbile{
	int gerbileNumber;
	public Gerbile(int gerbileNu){
		this.gerbileNumber = gerbileNu;
	}
	public String toString(){
		return "gerbil " + gerbileNumber; 
	}
	public void hop(){
		System.out.println(this + "is hopping");
	}
}
public class GerbilWithGenerics {
	public static void main(String[] args){
		ArrayList<Gerbile> gerbile = new ArrayList<Gerbile>();
		for(int i = 0;i<3;i++){
			gerbile.add(new Gerbile(i));
		}
		for(int i = 0;i<gerbile.size();i++){
			gerbile.get(i).hop();
		}
		
//		for(Gerbile g:gerbile){
//			g.hop();
//		}
	}

}
