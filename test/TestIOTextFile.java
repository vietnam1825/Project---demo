package test;

import data.ListPerson;
import file.IOTextFile;

public class TestIOTextFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListPerson listPerson = new ListPerson();
		//IOTextFile.readData(listPerson);		
		IOTextFile.readData("C:\\dataInput.txt", listPerson);
		System.out.println(listPerson);
		IOTextFile.writeData("C:\\dataOutput.txt", listPerson);

	}

}
