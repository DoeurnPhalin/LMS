package user;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class books extends JPanel {
	
	JTable table = null;

	/**
	 * Create the panel.
	 */
	public books() {
		setForeground(Color.WHITE);

		setBounds(313, 70, 533, 508);

		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK, 2, true));
		this.setLayout(null);
		
		JLabel lblListBookIn = new JLabel("List All books");
		lblListBookIn.setFont(new Font("ZCOOL QingKe HuangYou", Font.BOLD, 20));
		lblListBookIn.setBounds(31, 6, 222, 31);
		this.add(lblListBookIn);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 49, 521, 404);
		this.add(scrollPane);
		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
		
		
		JButton btnDelectBook = new JButton("Add Reserve");
		btnDelectBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String callno = null;
			    int[] selectedRow = table.getSelectedRows();
			    for (int i = 0; i < selectedRow.length; i++) {
			    	callno = (String) table.getValueAt(selectedRow[i], 1);
			      }
			    System.out.println("Selected: " + callno);
	
				int i = reserveDB.save(callno);			
				if(i!=0){
					JOptionPane.showMessageDialog(books.this,"Books added successfully!");
					
				}else{
					JOptionPane.showMessageDialog(books.this,"Sorry, unable to add!");
				}
				
			}
		});
		btnDelectBook.setFont(new Font(".SF NS Text", btnDelectBook.getFont().getStyle() | Font.BOLD, 20));
		btnDelectBook.setBounds(327, 457, 200, 45);
		this.add(btnDelectBook);

	}

}
