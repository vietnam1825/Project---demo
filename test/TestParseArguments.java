package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import data.Person;

public class TestParseArguments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// -- TEST with Arguments - Parsing
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);		
		try{
			System.out.println("Input the numero: ");
			String inputNumero = br.readLine();
			int numero = Integer.parseInt(inputNumero);
			
			System.out.println("Input the name: ");
			String inputName = br.readLine();
			
			System.out.println("Input the date: ");
			String inputDate = br.readLine();
			Date birth = new Date(inputDate);
			
			System.out.println("Input the address: ");
			String inputAdd = br.readLine();
			
			Person p = new Person(numero, inputName, birth, inputAdd);
			System.out.println(p);
			
		}catch(NumberFormatException e){
			e.printStackTrace();
			return;
		}catch(IllegalArgumentException e){
			e.printStackTrace();
			return;
		}catch(IOException e){
			e.printStackTrace();
			return;
		}
	}

}
