package user;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class reserveDB {
	public static int save(int patronId, int bookID) {
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into reserves(patronId, bookID) values(?,?)");
		ps.setInt(1, patronId);
		ps.setInt(2, bookID);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
	
	public static int remove(int bookID){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from `reserves` where `bookID` =?");
			ps.setInt(1,bookID);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
}