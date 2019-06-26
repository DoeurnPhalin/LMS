package user;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class removeReserveDB {
public static int save(String callno){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from reserve where reserve.callno=?");
		ps.setString(1,callno);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}