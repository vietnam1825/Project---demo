package test;

import java.util.Calendar;
import java.util.Date;

import data.Person;

public class TestPerson {
	
	/**
	 * @param args
	 */	
	public static void main(String[] args) {
		//  - TEST with Person
		Person p = new Person();
		System.out.println(p);
		
		// Get and set
		p.setName("Nguyen Trong Phuc");
		p.setBirth(Calendar.getInstance().getTime());
		p.setAdd("HaiPhong");
		System.out.println(p);
		
		// Constructors
		Person q = new Person(p);
		System.out.println("\n" + q);
		System.out.println(p);
		// Get and set
		q.setName("Nguyen Vuong Phong");
		q.setAdd("HaNoi");
		q.setBirth(new Date(1982, 12, 21));
		System.out.println("\n" + q);		
		System.out.println(p);
	}	
}
