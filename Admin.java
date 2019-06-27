import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
public class Admin extends JFrame {
	private JPanel contentPane;
	JPanel panel = new JPanel();
	JPanel panel_1 = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private static int libraian;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// Set window side
	int x=800;
	int y=500;
	public Admin(int _libraian) {
		//Set bound and set Jframe to stop on close.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Admin.libraian=_libraian;
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(3, 3, 3, 3));
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		
		JMenu mnMenue = new JMenu("   Menu   ");
		mnMenue.setIcon(null);
		menuBar.add(mnMenue);
		
		JMenu mnAdd = new JMenu("   Add        ");
		mnAdd.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\icons8-plus-20.png"));
		mnMenue.add(mnAdd);
		
		JMenuItem mntmLoan = new JMenuItem("   Issus   ");
		mntmLoan.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\icons8-study-20.png"));
		mntmLoan.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0) {
				panel_1.removeAll();
				loan2();
				
			}
			});
			
		
		mnAdd.add(mntmLoan);
		
		JMenuItem mntmReturn = new JMenuItem("   Return   ");
		mntmReturn.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\icons8-book-cartoon-20.png"));
		mnAdd.add(mntmReturn);
		
		JMenuItem mntmBook = new JMenuItem("   Book   ");
		mntmBook.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\icons8-health-book-20.png"));
		mnAdd.add(mntmBook);
		
		JMenuItem mntmUser = new JMenuItem("   User   ");
		mntmUser.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\icons8-add-user-male-20.png"));
		mnAdd.add(mntmUser);
		
		JMenuItem mntmExit = new JMenuItem("   Exit   ");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		
		JMenu mnView = new JMenu("   View     ");
		mnView.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\view_20px.png"));
		mnMenue.add(mnView);
		
		JMenuItem mntmBooks = new JMenuItem("   Books");
		mntmBooks.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\icons8-health-book-20.png"));
		mnView.add(mntmBooks);
		
		JMenuItem mntmUser_1 = new JMenuItem("   User");
		mntmUser_1.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\icons8-add-user-male-20.png"));
		mnView.add(mntmUser_1);
		
		JMenuItem mntmIssus = new JMenuItem("   Issus");
		mntmIssus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\icons8-study-20.png"));
		mnView.add(mntmIssus);
		
		JMenuItem mntmDueDate = new JMenuItem("   Due date");
		mntmDueDate.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\timer_20px.png"));
		mnView.add(mntmDueDate);
		mntmExit.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\close_window_20px.png"));
		mnMenue.add(mntmExit);
		
		JMenu mnHelp = new JMenu("   Help   ");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("   About   ");
		mntmAbout.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\about_20px.png"));
		mnHelp.add(mntmAbout);
		panel.setBackground(SystemColor.inactiveCaption);
		
		panel.setBounds(0, 0, 784, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnIssus = new JButton("       Issus");
		btnIssus.setHorizontalAlignment(SwingConstants.LEFT);
		btnIssus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\icons8-study-20.png"));
		btnIssus.setBackground(SystemColor.activeCaption);
		btnIssus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				loan2();
			}
		});
		btnIssus.setBounds(0, 0, 135, 40);
		panel.add(btnIssus);
		
		JButton btnNewButton = new JButton("              Return");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.removeAll();
				returnBook();
			}
		});
		btnNewButton.setBounds(136, 0, 135, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBooks books= new ViewBooks();
				books.frmBook.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(272, 0, 135, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("User");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(408, 0, 135, 40);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Report");
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		btnNewButton_3.setBounds(544, 0, 135, 40);
		panel.add(btnNewButton_3);
		panel_1.setBackground(SystemColor.inactiveCaption);
		
		panel_1.setBounds(0, 41, 784, 402);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		// Variable declaration 
		
		JLabel label = new JLabel("");
		label.setBounds(441, 16, 0, 0);
		panel_1.add(label);
		JButton btnGg = new JButton("OK");
		btnGg.setBounds(699, 359, 75, 23);
		panel_1.add(btnGg);
		
		
		//Object
		
		
		
		btnGg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				try{
//						loan2();
//					Class.forName("com.mysql.jdbc.Driver");
//
//					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","");
//					String maxSalary="notSet";
//					label.setText("Connected");
//					  PreparedStatement st = con.prepareStatement("select * from student where first_name='Phalin'");
//					    ResultSet r1=st.executeQuery();
//
//					     while(r1.next()) {
//
//					           maxSalary =  r1.getString("first_name")+""+r1.getString("last_name");
//					           System.out.print("The student name is :");
//							   System.out.println( maxSalary);
//					      }
//
//					    
//					    label.setText(maxSalary);
//					con.close();
//
//					}catch(Exception e){ 
//						System.out.println(e);
//					}
//				
				
				
				
			}
		});
		loan2();
		
	}
	
	public static int getLibraian() {
		return libraian;
	}


	//Loan Method
	public void loan2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, x, y);
		//contentPane = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		panel_1.setLayout(null);
		
		//Variable declaration
		
		JLabel lblPatronId = new JLabel("Patron ID");
		JButton btnCancel = new JButton(" Cancel ");
		JButton btnApprove = new JButton("Approve");
		JLabel lblIsbn = new JLabel("ISBN \\ Barcode");
		JButton btnCheck = new JButton("  Check  ");
		JLabel lblStatus = new JLabel("");
		JLabel lblMessage = new JLabel("");
		
		
		
		
		
		textField = new JTextField();
		textField.setBounds(100, 98, 438, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		btnCheck.setBounds(560, 102, 89, 23);
		btnCheck.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String isbn= textField.getText();
				System.out.println(isbn);
				if(isbn.compareTo("true")==0) {
					lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\check.png"));
					lblMessage.setText("The Book is able to borrow.");
				}
				else {
					lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\cancel_50px.png"));
					lblMessage.setText("The book is unable to borrow or has been reserved.");
				}
			}
		});
		panel_1.add(btnCheck);
		
		lblIsbn.setBounds(100, 77, 89, 23);
		panel_1.add(lblIsbn);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 169, 438, 31);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		lblPatronId.setBounds(100, 153, 55, 14);
		panel_1.add(lblPatronId);
		
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String isbn= textField.getText();
				String patron= textField_1.getText();
				if(isbn.isEmpty()) {
					lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\check.png"));
					lblMessage.setForeground(Color.green);
					lblMessage.setText("Please fill in the ISBN or Barcode");
				}
				if(textField_1.getText().isEmpty()){
					lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\cancel_50px.png"));
					lblMessage.setForeground(Color.red);
					lblMessage.setText("Patron ID can't be empty.");
				}
				else {
					 
					try {
						Connection con=DB.getConnection();
						PreparedStatement ps=con.prepareStatement("select number from books where bookId="+ Integer.parseInt(isbn),ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
						ResultSet rs=ps.executeQuery();
						if(rs.next()) {
							int number= Integer.parseInt( rs.getString(1));
							if(number<=1) {
								lblMessage.setText("The book cannot be borrowed.");	
							}
							else {
								try {
									ps=con.prepareStatement("select bookID from charts where bookId="+ Integer.parseInt(isbn)+" and patronId="+textField_1.getText(),ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
									rs=ps.executeQuery();
									if(rs.next()) {
										lblMessage.setText("You already borrow this book.");
									}
									else {
										String sql= "insert into issuses (patronId,bookId,issusDate,expectedReturn) value ("+patron+", "+isbn+", now(),DATE_ADD(CURRENT_DATE(), INTERVAL 7 DAY))";
										ps = con.prepareStatement(sql);
										ps.execute();
											System.out.println("Executed");
											ps=con.prepareStatement("select LAST_INSERT_ID() from issuses");
											rs=ps.executeQuery();
											if(rs.next()) {
												
												System.out.println(rs.getInt(1));
											}
											String issusId= rs.getString(1);
											String sql2= "insert into charts (userId,bookId,issusId,expectedReturn) value ("+patron+", "+isbn+", "+issusId+", DATE_ADD(CURRENT_DATE(), INTERVAL 7 DAY))";
										
										
									}
								} catch (SQLException e2) {
									// TODO: handle exception
									System.out.println(e2.getMessage());
								}
							}
						}
						else {
							lblMessage.setText("The book ID or ISBN you entered does not exist.");
							
						}
					} catch (SQLException e) {
						// TODO: handle exception
						lblMessage.setText("You entered improperly bookId or ISBN");
					}
					
					
					
				}
				
				
				
			}
		});
		btnApprove.setBounds(575, 257, 89, 23);
		panel_1.add(btnApprove);
		
		btnCancel.setBounds(482, 257, 89, 23);
		panel_1.add(btnCancel);
		
		
		lblStatus.setBounds(595, 155, 55, 56);
		panel_1.add(lblStatus);
		
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessage.setBounds(100, 122, 383, 31);
		panel_1.add(lblMessage);
		
		
	}
	
	
	
	//Return Method
		public void returnBook() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//setBounds(100, 100, x, y);
			//contentPane = new JPanel();
			panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			panel_1.setLayout(null);
			
			//Variable declaration
			
			JLabel lblPatronId = new JLabel("Patron ID");
//			JButton btnCancel = new JButton(" Cancel ");
			JButton btnApprove = new JButton("Approve");
			JLabel lblIsbn = new JLabel("ISBN \\ Barcode");
//			JButton btnCheck = new JButton("  Check  ");
			JLabel lblStatus = new JLabel("");
			JLabel lblMessage = new JLabel("");
			
			
			
			
			textField = new JTextField();
			textField.setBounds(100, 98, 438, 31);
			panel_1.add(textField);
			textField.setColumns(10);
			
//			btnCheck.setBounds(560, 102, 89, 23);
//			btnCheck.addActionListener(new ActionListener() {
//				
//				 
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					String isbn= textField.getText();
//					System.out.println(isbn);
//					if(isbn.compareTo("true")==0) {
//						lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\check.png"));
//						lblMessage.setText("The Book is able to borrow.");
//					}
//					else {
//						lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\cancel_50px.png"));
//						lblMessage.setText("The book is unable to borrow or has been reserved.");
//					}
//				}
//			});
//			panel_1.add(btnCheck);
			
			lblIsbn.setBounds(100, 77, 89, 23);
			panel_1.add(lblIsbn);
			
			textField_1 = new JTextField();
			textField_1.setBounds(100, 169, 438, 31);
			panel_1.add(textField_1);
			textField_1.setColumns(10);
			
			lblPatronId.setBounds(100, 153, 55, 14);
			panel_1.add(lblPatronId);
			
			btnApprove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			btnApprove.setBounds(575, 257, 89, 23);
			panel_1.add(btnApprove);
			
//			btnCancel.setBounds(482, 257, 89, 23);
//			panel_1.add(btnCancel);
			
			
			lblStatus.setBounds(595, 155, 55, 56);
			panel_1.add(lblStatus);
			
			lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblMessage.setBounds(100, 122, 383, 31);
			panel_1.add(lblMessage);
			
			
		}

			public void close() {
				WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
			}
}
