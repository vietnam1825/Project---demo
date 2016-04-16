package test;

import data.ListPerson;
import file.IOXMLFile;

public class TestIOXMLFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		ListPerson listPerson = new ListPerson();
		//IOXMLFile.readData(listPerson);
		IOXMLFile.readData("C:\\dataInput.xml", listPerson);
		System.out.println(listPerson);
		IOXMLFile.writeData("C:\\dataOutput.xml", listPerson);
		
	}

}
