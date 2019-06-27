import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adduser extends JFrame {

	private JPanel contentPane;
	private JTextField namef;
	private JTextField usernamef;
	private JTextField patronIdf;
	private JTextField passwordf;
	private JTextField dobf;
	private JTextField addressf;
	private JTextField rolef;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adduser frame = new adduser();
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
	public adduser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAccountUser = new JLabel("Create Account User");
		lblCreateAccountUser.setFont(new Font("ZCOOL QingKe HuangYou", Font.PLAIN, 20));
		lblCreateAccountUser.setBounds(163, 24, 236, 31);
		contentPane.add(lblCreateAccountUser);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(23, 89, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(23, 141, 89, 16);
		contentPane.add(lblUsername);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(23, 197, 61, 16);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(23, 250, 89, 16);
		contentPane.add(lblPassword);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth :");
		lblDateOfBirth.setBounds(23, 302, 117, 16);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(23, 357, 89, 16);
		contentPane.add(lblAddress);
		
		JLabel lblRole = new JLabel("Role :");
		lblRole.setBounds(23, 418, 61, 16);
		contentPane.add(lblRole);
		
		namef = new JTextField();
		namef.setBounds(139, 78, 281, 38);
		contentPane.add(namef);
		namef.setColumns(10);
		
		usernamef = new JTextField();
		usernamef.setBounds(139, 128, 281, 43);
		contentPane.add(usernamef);
		usernamef.setColumns(10);
		
		patronIdf = new JTextField();
		patronIdf.setBounds(139, 183, 281, 44);
		contentPane.add(patronIdf);
		patronIdf.setColumns(10);
		
		passwordf = new JTextField();
		passwordf.setBounds(138, 239, 282, 38);
		contentPane.add(passwordf);
		passwordf.setColumns(10);
		
		dobf = new JTextField();
		dobf.setBounds(139, 289, 281, 43);
		contentPane.add(dobf);
		dobf.setColumns(10);
		
		addressf = new JTextField();
		addressf.setBounds(139, 344, 281, 43);
		contentPane.add(addressf);
		addressf.setColumns(10);
		
		rolef = new JTextField();
		rolef.setBounds(139, 407, 281, 38);
		contentPane.add(rolef);
		rolef.setColumns(10);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = namef.getText();
				String username = usernamef.getText();
				int patronId = Integer.valueOf(patronIdf.getText());
				String password = passwordf.getText();
				String role = rolef.getText();
				String dob = dobf.getText();
				String address = addressf.getText();
				
				int i = adduserDB.saveuser(username, patronId, password, role);
				
				int j = adduserDB.savepatron(patronId, name, dob, address);
				
				if(i!=0 && j!=0) {
					JOptionPane.showMessageDialog(adduser.this,"Account Created");
				}else {
					JOptionPane.showMessageDialog(adduser.this,"Sorry, unable to Create!");
				}
				
				
			}
		});
		btnCreate.setBounds(194, 501, 117, 43);
		contentPane.add(btnCreate);
	}
}
