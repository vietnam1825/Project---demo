package test;

import java.util.Date;

import data.Person;

public class TestArguments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// -- TEST with Arguments
		if (args.length!=4){
			System.out.println("The number of parameters is wrong: " + args.length);
			return;
		}else{
			try{
				int numero = Integer.parseInt(args[0].trim());
				Date date = new Date(args[2].trim());
				Person p = new Person(numero, args[1].trim(), 
						date, args[3].trim());
				System.out.println(p);
			}catch(NumberFormatException e){
				e.printStackTrace();
				return;
			}catch(IllegalArgumentException e){
				e.printStackTrace();
				return;
			}
		}

	}

}
