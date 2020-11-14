package demo;

import java.util.ArrayList;
import java.lang.NullPointerException;
import java.lang.NumberFormatException;
public class test {

//	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result1= new ArrayList<String>();
		result1.add("bat den");
		String chuoi = result1.toString();
		chuoi = chuoi.replace("[", "");
		chuoi = chuoi.replace("]", "");
		String [] array = chuoi.split(" ");
		Kiemtra kt = new Kiemtrabattat(array, null, null);
		kt.Kiemtrahanhdong();
		RELAY t= kt.Kiemtrathutu();
		if (t==RELAY.RELAY1_ON)
			System.out.println("Da bat den");
	}	
}