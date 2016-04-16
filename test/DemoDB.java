/*
 * Created on Mar 7, 2013
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @author ntphuc
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DemoDB {
	
	/*
	 * Const
	 */
	public static String driverName = "com.mysql.jdbc.Driver";
	public static String driverURL = "jdbc:mysql://127.0.0.1:3306/demodb";
	public static String userName = "root";
	public static String password = "root";
	public static String sqlSelectName = "SELECT * FROM person";
	
	public void getName(){
			
		try{
			/*
			 * Nap trinh dieu khien
			 */
			Class.forName(driverName);
			/*
			 * Tao connection
			 */
			Connection c = DriverManager.getConnection(driverURL, userName, password); 
			/*
			 * Thao tac CSDL
			 */
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sqlSelectName);
			while(rs.next()){
				String name = rs.getString("Name");
				int	idPerson = rs.getInt("idPerson");
				Date birth = rs.getDate("Birth");
				String address = rs.getString(4);
				
				System.out.println("Person ID: " + idPerson);
				System.out.println("Name: " + name);
				System.out.println("Date of birth: " + birth);
				System.out.println("Address: " + address);
			}
			/*
			 * Ngat connection
			 */
			rs.close();
			c.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DemoDB demo = new DemoDB();
		demo.getName();
	}
}
