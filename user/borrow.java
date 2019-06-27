package user;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class borrow extends JPanel {
	
	JTable table = null;

	/**
	 * Create the panel.
	 */
	public borrow() {
		setForeground(Color.WHITE);
		
		setBounds(245, 70, 638, 537);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK, 2, true));
		this.setLayout(null);
		
		JLabel lblListBookIn = new JLabel("List All Borrowing");
		lblListBookIn.setFont(new Font("ZCOOL QingKe HuangYou", Font.BOLD, 20));
		lblListBookIn.setBounds(31, 6, 222, 31);
		this.add(lblListBookIn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 49, 626, 482);
		this.add(scrollPane);
		
		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT issuses.bookId, books.tittle,issuses.issusDate, issuses.expectedReturn FROM issuses INNER JOIN books ON issuses.bookId = books.bookId",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		
		table = new JTable(data,column);
		scrollPane.setViewportView(table);

	}

}
