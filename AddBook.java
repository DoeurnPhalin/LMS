
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddBook {

	public JFrame frmInsertBook;
	private JTextField textField_isbn;
	private JTextField textField_tittle;
	private JTextField textField_author;
	private JTextField textField_publisher;
	private JTextField textField_category;
	private JTextField textField_type;
	private JTextField textField_shelf;
	private JTextField textField_amount;
	private int bookID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook window = new AddBook(1);
					window.frmInsertBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInsertBook = new JFrame();
		frmInsertBook.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmInsertBook.setBackground(SystemColor.inactiveCaptionText);
		frmInsertBook.setForeground(Color.GRAY);
		frmInsertBook.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JAVA\\LMS\\img\\icons8-health-book-20.png"));
		frmInsertBook.setTitle("Insert Book");
		frmInsertBook.setBounds(100, 100, 950, 500);
		frmInsertBook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInsertBook.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 934, 461);
		frmInsertBook.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_isbn = new JTextField();
		textField_isbn.setBounds(179, 108, 697, 20);
		panel.add(textField_isbn);
		textField_isbn.setColumns(10);
		
		JLabel lblisbn = new JLabel("ISBN");
		lblisbn.setBounds(54, 111, 75, 14);
		panel.add(lblisbn);
		
		JLabel lblTittle = new JLabel("Tittle");
		lblTittle.setBounds(54, 136, 75, 14);
		panel.add(lblTittle);
		
		textField_tittle = new JTextField();
		textField_tittle.setBounds(179, 133, 697, 20);
		panel.add(textField_tittle);
		textField_tittle.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(54, 161, 75, 14);
		panel.add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(54, 186, 75, 14);
		panel.add(lblPublisher);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(54, 211, 75, 14);
		panel.add(lblCategory);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(54, 237, 75, 14);
		panel.add(lblType);
		
		JLabel lblShelf = new JLabel("Shelf");
		lblShelf.setBounds(54, 262, 75, 14);
		panel.add(lblShelf);
		
		JLabel jlblNumber = new JLabel("Amount");
		jlblNumber.setBounds(54, 287, 75, 14);
		panel.add(jlblNumber);
		
		textField_author = new JTextField();
		textField_author.setBounds(179, 158, 697, 20);
		panel.add(textField_author);
		textField_author.setColumns(10);
		
		textField_publisher = new JTextField();
		textField_publisher.setBounds(179, 183, 697, 20);
		panel.add(textField_publisher);
		textField_publisher.setColumns(10);
		
		textField_category = new JTextField();
		textField_category.setBounds(179, 208, 697, 20);
		panel.add(textField_category);
		textField_category.setColumns(10);
		
		textField_type = new JTextField();
		textField_type.setBounds(179, 234, 697, 20);
		panel.add(textField_type);
		textField_type.setColumns(10);
		
		textField_shelf = new JTextField();
		textField_shelf.setBounds(179, 259, 697, 20);
		panel.add(textField_shelf);
		textField_shelf.setColumns(10);
		
		textField_amount = new JTextField();
		textField_amount.setBounds(179, 284, 697, 20);
		textField_amount.setText("1");
		panel.add(textField_amount);
		textField_amount.setColumns(10);
		
		JLabel lblfeedback = new JLabel("");
		lblfeedback.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfeedback.setBounds(179, 313, 731, 34);
		panel.add(lblfeedback);
		
		JLabel lblStatus = new JLabel("");
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			if(!textField_tittle.getText().isEmpty() && !textField_author.getText().isEmpty()) {
				String isbn = ",'"+textField_isbn.getText()+"'";
				String tittle= ",'"+textField_tittle.getText()+"'";
				String author= ",'"+textField_author.getText()+"'";
				String publisher= ",'"+textField_publisher.getText()+"'";
				String category= ",'"+textField_category.getText()+"'";
				String type= ",'"+textField_type.getText()+"'";
				String shelf= ",'"+textField_shelf.getText()+"'";
				int number = Integer.parseInt(textField_amount.getText());
				
				String sql= "insert into books (number,isbn,tittle,author,publisher,category,type,shelf,insertDate) value ("+number+isbn+tittle+author+publisher+category+type+shelf+",now())";
				try {
					Connection con=DB.getConnection();
					PreparedStatement ps=con.prepareStatement(sql);
					ps.execute();
//					System.out.println(rs.getStatement());
					lblfeedback.setForeground(Color.GREEN);
					lblfeedback.setText("Book has been added!");
					lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\check.png"));

				} catch (SQLException e2) {
					System.out.println(e2.getStackTrace());
					System.out.println(e2.getMessage());
					// TODO: handle exception
				}
				
				
				
				
				}
			else {
				lblfeedback.setForeground(Color.RED);
				lblfeedback.setText("You have to fill in all the field before you can add!");
				lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\cancel_50px.png"));
			}
				
				
			}
		});
		btnAdd.setBackground(SystemColor.activeCaption);
		btnAdd.setBounds(812, 403, 89, 23);
		panel.add(btnAdd);
		
		
		lblStatus.setBounds(844, 346, 48, 45);
		panel.add(lblStatus);
		
		JLabel lblIns = new JLabel("Please input the book information");
		lblIns.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblIns.setBounds(242, 35, 442, 39);
		panel.add(lblIns);
	}
	
	public AddBook(int book) {
		bookID=book;
		frmInsertBook = new JFrame();
		frmInsertBook.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmInsertBook.setBackground(SystemColor.inactiveCaptionText);
		frmInsertBook.setForeground(Color.GRAY);
		frmInsertBook.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JAVA\\LMS\\img\\icons8-health-book-20.png"));
		frmInsertBook.setTitle("Insert Book");
		frmInsertBook.setBounds(100, 100, 950, 500);
		frmInsertBook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInsertBook.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 934, 461);
		frmInsertBook.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField_isbn = new JTextField();
		textField_isbn.setBounds(179, 108, 697, 20);
		panel.add(textField_isbn);
		textField_isbn.setColumns(10);
		
		JLabel lblisbn = new JLabel("ISBN");
		lblisbn.setBounds(54, 111, 75, 14);
		panel.add(lblisbn);
		
		JLabel lblTittle = new JLabel("Tittle");
		lblTittle.setBounds(54, 136, 75, 14);
		panel.add(lblTittle);
		
		textField_tittle = new JTextField();
		textField_tittle.setBounds(179, 133, 697, 20);
		panel.add(textField_tittle);
		textField_tittle.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(54, 161, 75, 14);
		panel.add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(54, 186, 75, 14);
		panel.add(lblPublisher);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(54, 211, 75, 14);
		panel.add(lblCategory);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(54, 237, 75, 14);
		panel.add(lblType);
		
		JLabel lblShelf = new JLabel("Shelf");
		lblShelf.setBounds(54, 262, 75, 14);
		panel.add(lblShelf);
		
		JLabel jlblNumber = new JLabel("Amount");
		jlblNumber.setBounds(54, 287, 75, 14);
		panel.add(jlblNumber);
		
		textField_author = new JTextField();
		textField_author.setBounds(179, 158, 697, 20);
		panel.add(textField_author);
		textField_author.setColumns(10);
		
		textField_publisher = new JTextField();
		textField_publisher.setBounds(179, 183, 697, 20);
		panel.add(textField_publisher);
		textField_publisher.setColumns(10);
		
		textField_category = new JTextField();
		textField_category.setBounds(179, 208, 697, 20);
		panel.add(textField_category);
		textField_category.setColumns(10);
		
		textField_type = new JTextField();
		textField_type.setBounds(179, 234, 697, 20);
		panel.add(textField_type);
		textField_type.setColumns(10);
		
		textField_shelf = new JTextField();
		textField_shelf.setBounds(179, 259, 697, 20);
		panel.add(textField_shelf);
		textField_shelf.setColumns(10);
		
		textField_amount = new JTextField();
		textField_amount.setBounds(179, 284, 697, 20);
		textField_amount.setText("1");
		panel.add(textField_amount);
		textField_amount.setColumns(10);
		
		JLabel lblfeedback = new JLabel("");
		lblfeedback.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfeedback.setBounds(179, 313, 731, 34);
		panel.add(lblfeedback);
		
		JLabel lblStatus = new JLabel("");
		JButton btnAdd = new JButton("Update");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			if(!textField_tittle.getText().isEmpty() && !textField_author.getText().isEmpty()) {
				String isbn = "'"+textField_isbn.getText()+"'";
				String tittle= "'"+textField_tittle.getText()+"'";
				String author= "'"+textField_author.getText()+"'";
				String publisher= "'"+textField_publisher.getText()+"'";
				String category= "'"+textField_category.getText()+"'";
				String type= "'"+textField_type.getText()+"'";
				String shelf= "'"+textField_shelf.getText()+"'";
				int number = Integer.parseInt(textField_amount.getText());
				
				String sql= "update books set tittle="+tittle+",isbn="+isbn+",author="+author+
						",publisher="+publisher+",category="+category+",type="+type+",shelf="+shelf+",number="+number+" where bookId="+book;
				try {
					Connection con=DB.getConnection();
					PreparedStatement ps=con.prepareStatement(sql);
					ps.execute();
//					System.out.println(rs.getStatement());
					lblfeedback.setForeground(Color.GREEN);
					lblfeedback.setText("Book has been updated!");
					lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\check.png"));

				} catch (SQLException e2) {
					System.out.println(e2.getStackTrace());
					System.out.println(e2.getMessage());
					// TODO: handle exception
				}
				
				
				
				
				}
			else {
				lblfeedback.setForeground(Color.RED);
				lblfeedback.setText("Tittle and author cannot be empty!");
				lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\cancel_50px.png"));
			}
				
				
			}
		});
		btnAdd.setBackground(SystemColor.activeCaption);
		btnAdd.setBounds(812, 403, 89, 23);
		panel.add(btnAdd);
		
		
		lblStatus.setBounds(844, 346, 48, 45);
		panel.add(lblStatus);
		
		JLabel lblIns = new JLabel("Please input the book information");
		lblIns.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblIns.setBounds(242, 35, 442, 39);
		panel.add(lblIns);
		
		
		String sql= "select* from books where bookId="+bookID;
		try {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				textField_isbn.setText(rs.getString(2));
				textField_tittle.setText(rs.getString(3));
				textField_author.setText(rs.getString(4));
				textField_publisher.setText(rs.getString(5));
				textField_category.setText(rs.getString(6));
				textField_type.setText(rs.getString(7));
				textField_shelf.setText(rs.getString(8));
				textField_amount.setText(rs.getString(10));
			}
//			System.out.println(rs.getStatement());
//			lblfeedback.setForeground(Color.GREEN);
//			lblfeedback.setText("Book has been added!");
//			lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\check.png"));

		} catch (SQLException e2) {
			System.out.println(e2.getStackTrace());
			System.out.println(e2.getMessage());
			// TODO: handle exception
		}
	}
}
