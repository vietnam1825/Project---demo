package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {
	
	/*
	 * Constants
	 */
	public static String nameDriver = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://127.0.0.1:3306/demodb";
	public static String user = "root";
	public static String password = "root";
	
	/*
	 * Static function - Open a connection
	 */
	public static Connection createConnection(){
		Connection conn = null;
		try{
			/*
			 * Load the library of JDBC MYSQL Driver into
			 */
			Class.forName(nameDriver);
			/*
			 * Create a connection
			 */
			conn = DriverManager.getConnection(url, user, password);
		}catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
        	ex.printStackTrace();
        	return null;
        }
		return conn;
	}
	
	/*
	 * Static function - Open a connection
	 */
	public static void closeConnection(Connection conn){		
		try{
			if (conn != null){
				conn.close();
				conn = null;
			}			
		}catch (SQLException ex) {
			ex.printStackTrace();
            conn = null;
        }
	}
}
