package test;

import data.ListPerson;
import data.Person;

public class TestListPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//	- TEST with List
		ListPerson listP = new ListPerson();
		Person p = new Person("Nguyen Trong Phuc", "HaiPhong");
		listP.addPerson(p);
		listP.addPerson(new Person("Nguyen Vuong Phong", "HaNoi"));
		listP.addPerson(new Person("Pham Van Ky", "HaTay"));
		listP.addPerson(new Person("Ta Duong Ngoc", "PhuTho"));
		
		System.out.println(listP.toString());
		listP.removePerson(2);
		System.out.println(listP.toString());
		listP.addPerson(new Person("Nguyen Vuong Phong", "HaNoi"));
		System.out.println(listP.toString());
		
		ListPerson listQ = new ListPerson(listP);
		System.out.println(listQ.toString());
		listQ.getPerson(2).setName("Pham Le Quan");		
		System.out.println("LIST - Q: " + listQ.toString());
		System.out.println("LIST - P: " + listP.toString());
		System.out.println(listQ.searchPerson("Pham Le Quan"));
		System.out.println(listP.searchPerson("Pham Le Quan"));
		listQ.removePerson("Pham Le Quan");
		System.out.println(listQ.toString());
		listP.removePerson("Pham Le Quan");
		System.out.println(listP.toString());
	}
}
