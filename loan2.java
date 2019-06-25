

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class loan2 extends JFrame {

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
					loan2 frame = new loan2();
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
	public loan2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Variable declaration
		
		JLabel lblPatronId = new JLabel("Patron ID");
		JButton btnCancel = new JButton(" Cancel ");
		JButton btnApprove = new JButton("Approve");
		JLabel lblIsbn = new JLabel("ISBN \\ Barcode");
		JButton btnCheck = new JButton("  Check  ");
		JLabel lblStatus = new JLabel("");
		JLabel lblMessage = new JLabel("");
		
		
		
		
		textField = new JTextField();
		textField.setBounds(53, 68, 238, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnCheck.setBounds(318, 72, 89, 23);
		btnCheck.addActionListener(new ActionListener() {
			
			@Override
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
		contentPane.add(btnCheck);
		
		lblIsbn.setBounds(53, 47, 89, 23);
		contentPane.add(lblIsbn);
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 139, 238, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblPatronId.setBounds(52, 123, 55, 14);
		contentPane.add(lblPatronId);
		
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnApprove.setBounds(335, 227, 89, 23);
		contentPane.add(btnApprove);
		
		btnCancel.setBounds(242, 227, 89, 23);
		contentPane.add(btnCancel);
		
		
		lblStatus.setBounds(352, 125, 55, 56);
		contentPane.add(lblStatus);
		
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessage.setBounds(24, 192, 383, 31);
		contentPane.add(lblMessage);
		
		
	}
}
