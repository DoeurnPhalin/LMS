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
import java.awt.event.ActionEvent;

public class LogInScreenStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 235, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 499, SpringLayout.WEST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 234, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_1, -140, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword, 243, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, -23, SpringLayout.NORTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPassword, 235, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPassword, -187, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("LOG IN");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLogIn, 23, SpringLayout.SOUTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLogIn, 383, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnLogIn, -82, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnLogIn, 0, SpringLayout.EAST, textField);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().compareTo("admin")==0) {
					close();
					admin adminPage =new admin();
					adminPage.setVisible(true);
					
					System.out.println("is addmin");
				}
				else {
					System.out.println("Students");
				}
			}
		});
		btnLogIn.setForeground(SystemColor.text);
		btnLogIn.setFont(btnLogIn.getFont().deriveFont(13f));
		btnLogIn.setBackground(SystemColor.textHighlight);
		contentPane.add(btnLogIn);
		
		JLabel lblLogInYour = new JLabel("Log In Your Student Account");
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 92, SpringLayout.SOUTH, lblLogInYour);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblLogInYour, -241, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLogInYour, 61, SpringLayout.NORTH, contentPane);
		lblLogInYour.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblLogInYour);
		
		JLabel lblEmain = new JLabel("Email");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEmain, 0, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblEmain, -6, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEmain, 67, SpringLayout.WEST, textField);
		contentPane.add(lblEmain);
	}
	
	public void close() {
		this.dispose();
//		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
//		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
