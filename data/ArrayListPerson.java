package data;

import java.util.ArrayList;

public class ArrayListPerson{
	// Attributes
	private ArrayList listP;
	
	// Constructors
	public ArrayListPerson(){		
		listP = new ArrayList();
	}
	
	public ArrayListPerson(ArrayListPerson _list){		
		listP = new ArrayList();
		int sizeList = _list.listP.size();
		for (int i=0; i<sizeList; i++){
			//listP.add(_list.listP.get(i));
			listP.add(new Person((Person)_list.listP.get(i)));
		}
	}

	// Getters and Setters
	public ArrayList getListP() {
		return listP;
	}

	public void setListP(ArrayList listP) {
		this.listP = listP;
	}
	
	public String toString(){
		String result = "Number of person in list = " + listP.size() + "\n\t";
		// Loop for all Persons
		for (int i=0; i<listP.size(); i++){
			result = result + listP.get(i).toString() + "\n\t";
		}
		return result;
	}
	
	// Methods - LIST
	public boolean addPerson(Person _person){
		listP.add(_person);
		return true;		
	}
	
	public boolean removePerson(int _index){
		_index = _index - 1;
		if (_index>=0 && _index<listP.size()){
			listP.remove(_index);
			return true;
		}else{
			return false;
		}
	}
	
	public boolean removePerson(String _name){
		int index = searchPerson(_name);
		return removePerson(index);
	}
	
	public Person getPerson(int _index){
		_index = _index - 1;
		return (Person)listP.get(_index);		
	}
	
	public int searchPerson(String _name){
		int result = 0;		
		for (int i=0; i<listP.size(); i++){
			if (((Person)listP.get(i)).getName().equals(_name)){
				result = i + 1;
				return result;
			}
		}		
		return result;
	}
}
