package data;

import java.util.Calendar;
import java.util.Date;

public class Person {
	// CONST
	public static int CURRENT_NUMERO = 1;
	
	// Attributes 
	private	int		numero = 0;
	private	String	name = "";
	private Date	birth = new Date();
	private String	add = "";
	
	// Constructors
	public	Person(){
		numero = CURRENT_NUMERO;
		name = "NONAME";		
		birth = Calendar.getInstance().getTime();
		add = "NOADD";
		CURRENT_NUMERO++;
	}
	
	public	Person(String _name, String _add){
		numero = CURRENT_NUMERO;
		name = _name;
		birth = Calendar.getInstance().getTime();
		add = _add;
		CURRENT_NUMERO++;
	}
	
	public	Person(String _name, Date _birth, String _add){
		numero = CURRENT_NUMERO;
		name = _name;
		birth = _birth;
		add = _add;
		CURRENT_NUMERO++;
	}
	
	public	Person(int _numero, String _name, Date _birth, String _add){
		numero = _numero;
		name = _name;
		birth = _birth;
		add = _add;
		CURRENT_NUMERO = CURRENT_NUMERO > _numero ? CURRENT_NUMERO : _numero + 1;
	}
	
	public	Person(Person _p){
		this.numero = CURRENT_NUMERO;
		this.name = _p.name;
		this.birth = _p.birth;
		this.add = _p.add;
		CURRENT_NUMERO++;
	}
	
	// Methods
	public	String toString(){
		String result = "Numero = " + numero;
		result = result + "\tName = " + name;
		result = result + "\tBirthday = " + birth.getDate() + "/" 
			+ (birth.getMonth() + 1) + "/" + (birth.getYear() + 1900);
		result = result + "\tAddress = " + add;
		return result;
	}
	
	public	String toStringFile(){
		String result = "\t" + numero + "; ";
		result = result + name + "; ";
		result = result + (birth.getMonth() + 1) + "/" 
			+ birth.getDate() + "/" + (birth.getYear() + 1900)
			+ "; ";
		result = result + add + "\n";
		return result;
	}
	
	public	void setData(String _name, Date _birth, String _add){	
		name = _name;
		birth = _birth;
		add = _add;		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String _name) {
		this.name = _name;
	}
	
	public Date getBirth() {
		return birth;
	}
	
	public String getBirthS(int type) {
		String result = "";
		switch (type){
		case 0:
			result += birth.getDate() + "/";
			result += birth.getMonth() + 1 + "/";			
			result += birth.getYear() + 1900;
			break;
		case 1:
			result += birth.getYear() + 1900 + "/";
			result += birth.getMonth() + 1 + "/";
			result += birth.getDate();			
			break;
		}		
		return result;
	}
	
	public void setBirth(Date _birth) {
		this.birth = _birth;
	}
	public String getAdd() {
		return add;
	}
	
	public void setAdd(String _add) {
		this.add = _add;
	}
	
	public int getNumero() {
		return numero;
	}	
}
