package data;

public class ListPerson {
	// Constants
	public static final int MAX_PER = 100;
	
	// Attributes
	private int numPer = 0;
	private Person[] listP;
	
	// Constructors
	public ListPerson(){
		numPer = 0;
		listP = new Person[MAX_PER];
	}
	
	public ListPerson(ListPerson _list){
		numPer = _list.numPer;
		//listP = _list.listP;
		listP = new Person[MAX_PER];
		for (int i=0; i<numPer; i++){
			listP[i] = new Person(_list.listP[i]);
		}
	}
	
	// Methods
	public String toString(){
		String result = "Number of person in list = " + numPer + "\n\t";
		// Loop for all Persons
		for (int i=0; i<numPer; i++){
			result = result + listP[i].toString() + "\n\t";
		}
		return result;
	}

	public int getNumPer() {
		return numPer;
	}

	public void setNumPer(int numPer) {
		this.numPer = numPer;
	}

	public Person[] getListP() {
		return listP;
	}

	public void setListP(Person[] listP) {
		this.listP = listP;
	}
	
	// Methods - LIST
	public boolean addPerson(Person _person){
		if (numPer >= MAX_PER){
			return false;
		}else{
			if (isExistePerson(_person.getNumero())){
				return false;
			}else{
				listP[numPer] = _person;
				numPer++;
				return true;
			}
		}
	}
	
	public boolean removePerson(int _index){
		_index = _index - 1;
		if (_index >= numPer || _index < 0){
			return false;
		}else{
			for (int i=_index; i<numPer-1; i++){
				listP[i] = listP[i+1];
			}			
			numPer--;
			return true;
		}
	}
	
	public boolean removePerson(String _name){
		int index = searchPerson(_name);
		return removePerson(index);
	}
	
	public Person getPerson(int _index){
		_index = _index - 1;		
		if (_index >= numPer){
			return null;
		}else{			
			return listP[_index];			
		}		
	}
	
	public int searchPerson(String _name){
		int result = 0;
		for (int i=0; i<numPer; i++){
			if (listP[i].getName().equals(_name)){
				result = i + 1;
				return result;
			}
		}		
		return result;
	}
	
	public boolean isExistePerson(int _numero){		
		for (int i=0; i<numPer; i++){
			if (listP[i].getNumero() == _numero){
				return true;
			}
		}		
		return false;
	}
}
