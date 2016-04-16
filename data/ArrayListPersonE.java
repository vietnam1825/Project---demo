package data;

import java.util.ArrayList;

public class ArrayListPersonE extends ArrayList{
	
	// Constructors
	public ArrayListPersonE(){		
		super();		
	}
	
	public ArrayListPersonE(ArrayListPersonE _list){
		super();		
		int sizeList = _list.size();
		for (int i=0; i<sizeList; i++){
			//listP.add(_list.listP.get(i));
			this.add(new Person((Person)_list.get(i)));
		}
	}

	public String toString(){
		String result = "Number of person in list = " + this.size() + "\n\t";
		// Loop for all Persons
		for (int i=0; i<this.size(); i++){
			result = result + this.get(i).toString() + "\n\t";
		}
		return result;
	}
	
	// Methods - LIST
	public boolean addPerson(Person _person){
		this.add(_person);
		return true;		
	}
	
	public boolean removePerson(int _index){
		_index = _index - 1;
		if (_index>=0 && _index<this.size()){
			this.remove(_index);
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
		return (Person)this.get(_index);		
	}
	
	public int searchPerson(String _name){
		int result = 0;		
		for (int i=0; i<this.size(); i++){
			if (((Person)this.get(i)).getName().equals(_name)){
				result = i + 1;
				return result;
			}
		}		
		return result;
	}
}
