package file;

import mysql.Utilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import data.ListPerson;
import data.Person;

public class IOSQLPerson {
	/*	 
	 * Read data from database
	 * Input: 
	 * 		no parameters
	 * Output:
	 * 		true: if it is readable
	 * 		list of person
	 */
	public static boolean getListPerson(ListPerson listPerson){
		/*
		 * Open a connection
		 */
		Connection conn = Utilities.createConnection();
		/*
		 * Get all data - list of persons
		 */		
		try{
			if (conn != null){
				/*
				 * Statement
				 */
				Statement st = conn.createStatement();
				/*
				 * SQL Query
				 */
				String sqlQuery = "SELECT * FROM Person";
				/*
				 * Result set
				 */
				ResultSet rs = st.executeQuery(sqlQuery);
				/*
				 * Fill the data to listPerson
				 */
				while (rs.next()){
					int numero = rs.getInt("idPerson");
					String name = rs.getString("Name");
					Date birth = rs.getDate("Birth");
					String addr = rs.getString(4);
					Person p = new Person(numero, name, birth, addr);
					listPerson.addPerson(p);
				}
				
				if (st != null) st.close();
				if (rs != null) rs.close();
			}
		}catch(SQLException ex){
			ex.printStackTrace();
			Utilities.closeConnection(conn);
			return false;
		}
		/*
		 * Close the connection
		 */
		Utilities.closeConnection(conn);
		return true;
	}
	
	/*	 
	 * Insert into database
	 * Input: 
	 * 		Person
	 * Output:
	 * 		true: if it is readable 		
	 */
	public static boolean insertPerson(Person p){
		/*
		 * Open a connection
		 */
		Connection conn = Utilities.createConnection();
		/*
		 * Get all data - list of persons
		 */		
		try{
			if (conn != null){
				/*
				 * Statement
				 */
				Statement st = conn.createStatement();
				/*
				 * SQL Query
				 */
				int numero = p.getNumero();
				String name = p.getName();
				String birth = p.getBirthS(1);
				String addr = p.getAdd();
				String sqlQuery = "INSERT INTO Person VALUES(";
				sqlQuery = sqlQuery + numero + ",'" + name + "'";
				sqlQuery = sqlQuery + ",'" + birth + "'";
				sqlQuery = sqlQuery + ",'" + addr + "')";
				/*
				 * Result set
				 */
				st.execute(sqlQuery);		
				if (st != null) st.close();				
			}
		}catch(SQLException ex){
			ex.printStackTrace();
			Utilities.closeConnection(conn);
			return false;
		}
		/*
		 * Close the connection
		 */
		Utilities.closeConnection(conn);
		return true;
	}
	
	/*	 
	 * Delete rows in database
	 * Input: 
	 * 		No parameters
	 * Output:
	 * 		true: if it is readable 		
	 */
	public static boolean deletePerson(){
		/*
		 * Open a connection
		 */
		Connection conn = Utilities.createConnection();
		/*
		 * Get all data - list of persons
		 */		
		try{
			if (conn != null){
				/*
				 * Statement
				 */
				Statement st = conn.createStatement();
				/*
				 * SQL Query
				 */
				String sqlQuery = "DELETE FROM Person WHERE idPerson>=4";
				/*
				 * Result set
				 */
				st.execute(sqlQuery);		
				if (st != null) st.close();
			}
		}catch(SQLException ex){
			ex.printStackTrace();
			Utilities.closeConnection(conn);
			return false;
		}
		/*
		 * Close the connection
		 */
		Utilities.closeConnection(conn);
		return true;
	}
}
