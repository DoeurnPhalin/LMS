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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class rerserve extends JPanel {
	
	JTable table = null;

	/**
	 * Create the panel.
	 */
	public rerserve() {
		setForeground(Color.WHITE);

		setBounds(245, 70, 638, 537);

		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK, 2, true));

		this.setLayout(null);
		
		JLabel lblListBookIn = new JLabel("List All Reserve");
		lblListBookIn.setFont(new Font("ZCOOL QingKe HuangYou", Font.BOLD, 20));
		lblListBookIn.setBounds(31, 6, 222, 31);
		this.add(lblListBookIn);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 49, 626, 436);
		this.add(scrollPane);
		
		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select reserves.bookID, books.tittle from reserves inner join books on reserves.bookID = books.bookID",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
		
		
		
		
		JButton btnDelectBook = new JButton("REMOVE");
		btnDelectBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idreserve1 = null;
			    int[] selectedRow = table.getSelectedRows();
			    for (int i = 0; i < selectedRow.length; i++) {
			    	idreserve1 = (String) table.getValueAt(selectedRow[i], 0);
			      }
			    System.out.println("Selected: " + idreserve1);
			    
			    int bookID = Integer.valueOf(idreserve1);
			    
			    System.out.println(bookID);
	
				int i = reserveDB.remove(bookID);			
				if(i!=0){
					JOptionPane.showMessageDialog(rerserve.this,"Books delete successfully!");
					
				}else{
					JOptionPane.showMessageDialog(rerserve.this,"Sorry, unable to delete!");
				}
			    
		        
			}
		});
		
		btnDelectBook.setFont(new Font(".SF NS Text", btnDelectBook.getFont().getStyle() | Font.BOLD, 20));
		btnDelectBook.setBounds(478, 486, 154, 45);
		this.add(btnDelectBook);

	}

}
