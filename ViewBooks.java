

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerListModel;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class ViewBooks {

	JFrame frmBook;
	private JTable table;
	private JPanel panel;
	private JTextField textField;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnEdit;
	private JButton btnExport;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBooks window = new ViewBooks();
					window.frmBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewBooks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBook = new JFrame();
		frmBook.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmBook.setTitle("Books");
		frmBook.setBounds(100, 100, 1024, 600);
		frmBook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		table.getTableHeader().setBackground(Color.gray);
//		table.
//		for(int i=0;i<=table.getColumnCount();i++) {
//			System.out.println(table.getColumnCount());
//			if (i%2==0) {
//				DefaultTableCellRenderer rendar1 = new DefaultTableCellRenderer();
////			    rendar1.setForeground(Color.gray);
//			    rendar1.setBackground(Color.GRAY);
//			    table.getColumnModel().getColumn(i).setCellRenderer(rendar1);
//			}
//		}
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		frmBook.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(128, 16, 870, 47);
		frmBook.getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setBounds(65, 3, 275, 30);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(528, 3, 80, 31);
		spinner.setModel(new SpinnerListModel(new String[] {"Tittle", "Author", "ISBN"}));
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(SystemColor.activeCaption);
		btnSearch.setBounds(378, 3, 100, 30);
		panel.setLayout(null);
		panel.add(textField);
		panel.add(spinner);
		panel.add(btnSearch);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setBackground(SystemColor.inactiveCaption);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(128, 62, 870, 499);
		sp.setBackground(SystemColor.inactiveCaption);
		
		frmBook.getContentPane().add(sp);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 74, 130, 487);
		frmBook.getContentPane().add(panel_1);
		
		btnNewButton = new JButton(" Add book");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\icons8-plus-20.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBook book= new AddBook();
				book.frmInsertBook.setVisible(true);
				
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(1, 0, 125, 50);
		
		btnNewButton_1 = new JButton(" Import");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseFile cf = new ChooseFile();
				cf.setVisible(true);
				String path=cf.getPath();
				System.out.println(path);
				cf.dispose();
				
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\export_20px.png"));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(1, 104, 125, 50);
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		panel_1.add(btnNewButton_1);
		
		btnEdit = new JButton(" Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int row = table.getSelectedRow();
//				System.out.println(table.getCellEditor(1, 1).getCellEditorValue().toString());
				String callno = null;
			    int[] selectedRow = table.getSelectedRows();
			    for (int i = 0; i < selectedRow.length; i++) {
			    	callno = (String) table.getValueAt(selectedRow[i], 0);
			      }
			    System.out.println("Selected: " + callno +selectedRow);
			}
		});
		btnEdit.setBackground(SystemColor.activeCaption);
		btnEdit.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\edit_property_20px.png"));
		btnEdit.setHorizontalAlignment(SwingConstants.LEFT);
		btnEdit.setBounds(1, 52, 125, 50);
		panel_1.add(btnEdit);
		
		btnExport = new JButton(" Export");
		btnExport.setHorizontalAlignment(SwingConstants.LEFT);
		btnExport.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\import_20px.png"));
		btnExport.setBackground(SystemColor.activeCaption);
		btnExport.setBounds(0, 156, 126, 50);
		panel_1.add(btnExport);
		
		btnDelete = new JButton(" Delete");
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\delete_sign_20px.png"));
		btnDelete.setBackground(SystemColor.activeCaption);
		btnDelete.setBounds(1, 208, 125, 50);
		panel_1.add(btnDelete);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 118, 106);
		frmBook.getContentPane().add(label);
	}
}
