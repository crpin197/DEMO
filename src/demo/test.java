package demo;

import java.util.ArrayList;
import java.lang.NullPointerException;
public class test {

//	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result1= new ArrayList<String>();
		result1.add("bat den va den quat");
		String chuoi = result1.toString();
		chuoi = chuoi.replace("[", "");
		chuoi = chuoi.replace("]", "");
		String [] array = chuoi.split(" ");
		Kiemtra kt = new Kiemtra(array);
		RELAY[] status = kt.kiemtra();
		if (status[0] == RELAY.RELAY1_ON) {
			System.out.println("Da bat thiet bi quat");
		}
		if (status[1] == RELAY.RELAY2_ON) {
			System.out.println("Da bat thiet bi den");
		}
		if (status[2] == RELAY.RELAY1_OFF) {
			System.out.println("Da tat thiet bi quat");
		}
		if (status[3] == RELAY.RELAY2_OFF) {
			System.out.println("Da tat thiet bi den");
		}

	}	
}