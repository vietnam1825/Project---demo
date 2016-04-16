package file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import data.ListPerson;
import data.Person;

public class IOXMLFile {
	// Constant
	public static final String INPUT_FILE = "C:\\dataInput.xml";
	public static final String OUTPUT_FILE = "C:\\dataOutput.xml";
	
	// Static function
	/*
	 * Get each element by name
	 */
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
	/*
	 * Read data from file
	 * Input: 
	 * 		name of input data file
	 * Output:
	 * 		true: if file is readable
	 * 		list of person
	 */
	public static boolean readData(String fileName, ListPerson listPerson){		
		try{
			File xmlFile = new File(fileName);			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			
			// Read data from file - element
			NodeList nList = doc.getElementsByTagName("person");
			int count = 0;
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					try{
						int numero = Integer.parseInt(getTagValue("numero", eElement).trim());
						String name = getTagValue("name", eElement);
						Date birth = new Date(getTagValue("birth", eElement).trim());
						String add = getTagValue("address", eElement).trim();
						Person p = new Person(numero, name, birth, add);									
						listPerson.addPerson(p);
						count++;
					}catch(NumberFormatException e){
						System.out.println("This element is incorrect!");								
					}catch(IllegalArgumentException e){
						System.out.println("This element is incorrect!");
					}					
				}
			}			
		}catch(NullPointerException e){			
			e.printStackTrace();
			return false;
		}catch(ParserConfigurationException e){
			e.printStackTrace();
			return false;
		}catch(SAXException e){
			e.printStackTrace();
			return false;
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * Read data from default file
	 * Input: 
	 * 		default input data file
	 * Output:
	 * 		true: if file is readable
	 * 		list of person
	 */
	public static boolean readData(ListPerson listPerson){
		return readData(INPUT_FILE, listPerson);
	}
	
	/*
	 * Create a new document of XML
	 */
	private static Document createDocument(ListPerson listPerson){
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();		
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();	 
			
			// New a document
			Document doc = docBuilder.newDocument();			
			// List person element
			Element listElement = doc.createElement("listPerson");		
			doc.appendChild(listElement);
			listElement.appendChild(doc.createTextNode("\n\t"));
				 
			if (listPerson!=null){
				for (int i=1; i<=listPerson.getNumPer(); i++){
					Person p = listPerson.getPerson(i);
					// Person elements					
					Element person = doc.createElement("person");
					listElement.appendChild(person);
					person.appendChild(doc.createTextNode("\n\t\t"));
					
					// Number elements
					Element numero = doc.createElement("numero");					
					numero.setTextContent(""+p.getNumero());					
					person.appendChild(numero);
					person.appendChild(doc.createTextNode("\n\t\t"));
					
					// Name elements
					Element name = doc.createElement("name");	
					name.setTextContent(p.getName());
					person.appendChild(name);
					person.appendChild(doc.createTextNode("\n\t\t"));
					
					// Birthday elements
					Element birth = doc.createElement("birth");					
					birth.setTextContent(p.getBirthS(0));
					person.appendChild(birth);
					person.appendChild(doc.createTextNode("\n\t\t"));
					
					// Name elements
					Element adds = doc.createElement("address");					
					adds.setTextContent(p.getAdd());
					person.appendChild(adds);
					person.appendChild(doc.createTextNode("\n\t"));
					
					// New line
					if (i<listPerson.getNumPer())
						listElement.appendChild(doc.createTextNode("\n\t"));
					else
						listElement.appendChild(doc.createTextNode("\n"));
				}
			}			
			return doc;
		}catch(ParserConfigurationException e){
			return null;
		} 		
	}
	
	/*
	 * Write data to file
	 * Input: 
	 * 		name of output data file
	 * 		list of person
	 * Output:
	 * 		true: if file is writable	
	 */
	public static boolean writeData(String fileName, ListPerson listPerson){
		try{
			// Write the content into XML file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			Document doc = createDocument(listPerson);
			DOMSource source = new DOMSource(doc);
			File file = new File(fileName);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		}catch(TransformerConfigurationException e){
			e.printStackTrace();
			return false;
		}catch(TransformerException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*
	 * Write data to default file
	 * Input: 	
	 * 		list of person
	 * Output:
	 * 		true: if file is writable	
	 */
	public static boolean writeData(ListPerson listPerson){
		return writeData(OUTPUT_FILE, listPerson);
	}
}
