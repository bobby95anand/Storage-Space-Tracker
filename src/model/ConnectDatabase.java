package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
	static Connection cn=null;
	static String driver="com.ibm.db2.jcc.DB2Driver";
	static String url="jdbc:db2://localhost:50000/winter";
	static String user="LENOVO";
	static String pass="lenovog550";
	public static Connection getCn()
	{
		try
		{
			Class.forName(driver);
			cn=DriverManager.getConnection(url,user, pass);
			//System.out.println("Database connected");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return cn;
	}
}
