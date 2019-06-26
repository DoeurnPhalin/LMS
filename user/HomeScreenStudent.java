package user;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class HomeScreenStudent extends JFrame {
	
	borrow Borrow = new borrow();
	rerserve Rerserve = new rerserve();
	books BOOKS = new books();
	JPanel panel = new JPanel();
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreenStudent frame = new HomeScreenStudent();
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
	public HomeScreenStudent() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.BLACK, 2, true));
		setContentPane(contentPane);
		
		JButton btnListBooks = new JButton("List Books");
		btnListBooks.setBounds(57, 99, 207, 52);
		btnListBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Borrow.setVisible(false);
				Rerserve.setVisible(false);
				BOOKS.setVisible(true);
				BOOKS.setBounds(0, 0, 533, 508);
				panel.add(BOOKS);

				
				
			}
		});
				
		contentPane.setLayout(null);
		btnListBooks.setForeground(Color.BLACK);
		btnListBooks.setFont(new Font(".SF NS Text", btnListBooks.getFont().getStyle() | Font.BOLD, 20));
		contentPane.add(btnListBooks);
		
		JButton btnOpenCart = new JButton("List Reserved");
		btnOpenCart.setBounds(57, 198, 207, 52);
		btnOpenCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Borrow.setVisible(false);
				BOOKS.setVisible(false);
				Rerserve.setVisible(true);
				Rerserve.setBounds(0, 0, 533, 508);
				panel.add(Rerserve);
				
				
			}
		});
		
		btnOpenCart.setForeground(Color.BLACK);
		btnOpenCart.setFont(new Font(".SF NS Text", btnOpenCart.getFont().getStyle() | Font.BOLD, 20));
		contentPane.add(btnOpenCart);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				LogInScreenStudent obj = new LogInScreenStudent();
				obj.setVisible(true);
				obj.setResizable(false);
				
			}
		});
		btnLogOut.setBounds(57, 531, 207, 47);
		btnLogOut.setForeground(UIManager.getColor("Button.select"));
		btnLogOut.setFont(new Font(".SF NS Text", btnLogOut.getFont().getStyle() | Font.BOLD, 20));
		contentPane.add(btnLogOut);
		
		JButton button = new JButton("List Borrowed");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BOOKS.setVisible(false);
				Rerserve.setVisible(false);
				Borrow.setVisible(true);
				Borrow.setBounds(0, 0, 533, 508);
				panel.add(Borrow);

				
			}
		});
		
		button.setBounds(57, 293, 207, 52);
		button.setForeground(Color.BLACK);
		button.setFont(new Font(".SF NS Text", button.getFont().getStyle() | Font.BOLD, 20));
		contentPane.add(button);
		
		JLabel lblWelcomeToLibrary = new JLabel("Welcome to Library Management System");
		lblWelcomeToLibrary.setFont(new Font("ZCOOL QingKe HuangYou", Font.BOLD, 24));
		lblWelcomeToLibrary.setBounds(26, 6, 356, 52);
		contentPane.add(lblWelcomeToLibrary);
		
		
		panel.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(313, 70, 533, 508);
		panel.setLayout(null);
		contentPane.add(panel);
		
	}
}
