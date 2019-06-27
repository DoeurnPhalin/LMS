import java.sql.Connection;
import java.sql.PreparedStatement;

public class adduserDB {
	
		public static int saveuser(String username, int patronId, String password, String role) {
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user(username, patronId, password, role) values(?,?,?,?)");
			ps.setString(1, username);
			ps.setInt(2, patronId);
			ps.setString(3, password);
			ps.setString(4, role);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
		}
		
		
		public static int savepatron(int patronId, String name, String dob, String address) {
			int status=0;
			try{
				Connection con=DB.getConnection();
				PreparedStatement ps=con.prepareStatement("insert into patrons(patronID, name, dob, address, registerDate) values(?,?,?,?,now())");
				ps.setInt(1, patronId);
				ps.setString(2, name);
				ps.setString(3, dob);
				ps.setString(4, address);
				status=ps.executeUpdate();
				con.close();
			}catch(Exception e){System.out.println(e);}
			return status;
			}

		
}
