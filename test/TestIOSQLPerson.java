package test;

import mysql.IOSQLPerson;
import data.ListPerson;
import data.Person;

public class TestIOSQLPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListPerson listPerson = new ListPerson();
		IOSQLPerson.getListPerson(listPerson);
		System.out.println(listPerson);		
		IOSQLPerson.insertPerson(new Person("Pham Manh Quynh", "Ho Chi Minh"));
	}

}
