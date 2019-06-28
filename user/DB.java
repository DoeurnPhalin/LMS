package user;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagement?autoReconnect=true&useSSL=false","root","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}

}
