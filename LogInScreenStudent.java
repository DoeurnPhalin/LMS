

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.tools.Tool;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;

public class LogInScreenStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JLabel lblmailErr = new JLabel("");
	JLabel lblpasErr = new JLabel("");
	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInScreenStudent frame = new LogInScreenStudent();
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
	public LogInScreenStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(240, 184, 264, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(239, 275, 265, 41);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(240, 248, 67, 21);
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setBounds(388, 352, 116, 35);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(textField.getText().isEmpty()) {
						lblmailErr.setText("Please enter your user name.");
					}
					else {
						lblmailErr.setText("");
					}
					if (textField_1.getText().isEmpty()) {
						lblpasErr.setText("Please input your password");
					}
					else {
						lblpasErr.setText("");
					}
					if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty()){
						
						try{
							String us=textField.getText();
							String pw=textField_1.getText();
							String sql="select patronId,role from user where username='"+us+"' and password='"+pw+"'";
							Connection con=DB.getConnection();
							PreparedStatement ps=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet rs=ps.executeQuery();
							if(rs.next()) {
								if(rs.getString(2).equals("librarian")) {
									close();
									int patron =rs.getInt(1);
									admin adminPage =new admin(patron);
									adminPage.setVisible(true);
//									System.out.println("is addmin");
									
								}
								else {
									lblmailErr.setText(rs.getString(2));
									System.out.println(rs.getString(1));
									
								}
							}
							else {
								lblmailErr.setText("Username or password is incorrect");
							}		
							
							con.close();
						}catch(Exception e1){
							System.out.println(e1);
						}			
				}
//				else {
//					System.out.println("Students");
//				}
			}
		});
		btnLogIn.setForeground(SystemColor.text);
		btnLogIn.setFont(btnLogIn.getFont().deriveFont(13f));
		btnLogIn.setBackground(SystemColor.textHighlight);
		contentPane.add(btnLogIn);
		
		JLabel lblLogInYour = new JLabel("Please Log In to Your Account");
		lblLogInYour.setBounds(236, 121, 268, 26);
		lblLogInYour.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblLogInYour);
		
		JLabel lblEmain = new JLabel("Email");
		lblEmain.setBounds(240, 164, 67, 14);
		contentPane.add(lblEmain);
		
		JLabel lblWelcomeToLibrary = new JLabel("Welcome to Library Management System");
		lblWelcomeToLibrary.setBounds(123, 35, 510, 34);
		lblWelcomeToLibrary.setFont(new Font("Tahoma", Font.PLAIN, 28));
		contentPane.add(lblWelcomeToLibrary);
		
		lblmailErr.setForeground(Color.RED);
		lblmailErr.setBounds(240, 230, 264, 21);
		contentPane.add(lblmailErr);
		
		lblpasErr.setForeground(Color.RED);
		lblpasErr.setBounds(240, 320, 264, 21);
		contentPane.add(lblpasErr);
	}


	
	
	public void close() {
		this.dispose();
//		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
//		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
}
