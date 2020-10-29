package demo;

import java.util.ArrayList;

public class test {

//	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result1= new ArrayList<String>();
		result1.add(" 1 bat thiet bi 1");
		
		/*System.out.println(result1);
		System.out.println(result1.size());
		StringBuffer stb = null;
		for (String s : result1){
          stb.append(s);
          stb.append(" ");
      }*/
		String chuoi = result1.toString();
		chuoi = chuoi.replace("[", " ");
		chuoi = chuoi.replace("]", " ");
		String [] array = chuoi.split(" ");
		Kiemtra tc = new Kiemtra(array);
		tc.kiemtra();
	}	
}