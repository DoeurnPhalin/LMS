package user;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

public class LogInScreenStudent extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;

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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.BLACK, 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		email = new JTextField();
		email.setBounds(161, 158, 418, 41);
		email.setToolTipText("example@email.com");
		email.setFont(new Font(".SF NS Text", email.getFont().getStyle(), email.getFont().getSize()));
		contentPane.add(email);
		email.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(161, 255, 418, 41);
		contentPane.add(password);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(161, 118, 110, 28);
		lblEmail.setLabelFor(email);
		lblEmail.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(161, 212, 151, 31);
		lblPassword.setFont(new Font(".SF NS Text", Font.PLAIN, 20));
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setBounds(302, 371, 132, 52);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailuser = email.getText();
				String passworduser = String.valueOf(password.getPassword());
				
				if(emailuser.equals("user")&&passworduser.equals("user123")) {
					HomeScreenStudent.main(new String[] {});
					dispose();
				}else {
					JOptionPane.showMessageDialog(LogInScreenStudent.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
					email.setText("");
					password.setText("");
				}
					
			}
		});
		
		btnLogIn.setForeground(Color.BLACK);
		btnLogIn.setFont(new Font(".SF NS Text", btnLogIn.getFont().getStyle() | Font.BOLD, 20));
		btnLogIn.setBackground(new Color(0, 0, 0));
		contentPane.add(btnLogIn);
		
		JLabel lblLogInYour = new JLabel("Log In Your Student Account");
		lblLogInYour.setBounds(143, 28, 439, 44);
		lblLogInYour.setFont(new Font("ZCOOL QingKe HuangYou", Font.BOLD | Font.ITALIC, 43));
		contentPane.add(lblLogInYour);
		
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxShowPassword.isSelected()) {
					password.setEchoChar((char)0);
				}
				else {
					password.setEchoChar('*');
				}
			}
		});
		
		chckbxShowPassword.setFont(new Font(".SF NS Text", chckbxShowPassword.getFont().getStyle(), 13));
		chckbxShowPassword.setBounds(447, 308, 182, 23);
		contentPane.add(chckbxShowPassword);
	}
}
