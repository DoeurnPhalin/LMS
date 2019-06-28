package user;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class HomeScreenStudent extends JFrame {
	
	borrow Borrow = new borrow();
	rerserve Rerserve = new rerserve();
	books BOOKS = new books(patronId);
	JPanel panel = new JPanel();
	
	JTable table = null;

	static int patronId;
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreenStudent frame = new HomeScreenStudent(patronId);
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
	public HomeScreenStudent(int patronId) {
		
//		this.patronId = patronId;
//		
//		int patronId2 = this.patronId;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.BLACK, 2, true));
		setContentPane(contentPane);
		
		JButton btnListBooks = new JButton("List Books");
		btnListBooks.setBackground(Color.WHITE);
		btnListBooks.setBounds(26, 71, 207, 52);
		btnListBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				searchnew.setVisible(false);
				panel.removeAll();
				Borrow.setVisible(false);
				Rerserve.setVisible(false);
				BOOKS.setVisible(true);
				BOOKS.setBounds(0, 0, 638, 537);
				panel.add(BOOKS);

			}
		});
				
		contentPane.setLayout(null);
		btnListBooks.setForeground(Color.BLACK);
		btnListBooks.setFont(new Font(".SF NS Text", btnListBooks.getFont().getStyle() | Font.BOLD, 20));
		contentPane.add(btnListBooks);
		
		JButton btnOpenCart = new JButton("List Reserved");
		btnOpenCart.setBackground(Color.WHITE);
		btnOpenCart.setBounds(26, 135, 207, 52);
		btnOpenCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				searchnew.setVisible(false);
				Borrow.setVisible(false);
				BOOKS.setVisible(false);
				Rerserve.setVisible(true);
				Rerserve.setBounds(0, 0, 638, 537);
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
		btnLogOut.setBounds(26, 560, 207, 47);
		btnLogOut.setForeground(UIManager.getColor("Button.select"));
		btnLogOut.setFont(new Font(".SF NS Text", btnLogOut.getFont().getStyle() | Font.BOLD, 20));
		contentPane.add(btnLogOut);
		
		JButton button = new JButton("List Borrowing");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				searchnew.setVisible(false);
				BOOKS.setVisible(false);
				Rerserve.setVisible(false);
				Borrow.setVisible(true);
				Borrow.setBounds(0, 0, 638, 537);
				panel.add(Borrow);

			}
		});
		
		button.setBounds(26, 199, 207, 52);
		button.setForeground(Color.BLACK);
		button.setFont(new Font(".SF NS Text", button.getFont().getStyle() | Font.BOLD, 20));
		contentPane.add(button);
		
		JLabel lblWelcomeToLibrary = new JLabel("Welcome to Library");
		lblWelcomeToLibrary.setFont(new Font("ZCOOL QingKe HuangYou", Font.BOLD, 24));
		lblWelcomeToLibrary.setBounds(26, 6, 356, 52);
		contentPane.add(lblWelcomeToLibrary);
		
		panel.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(245, 70, 638, 537);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomeScreenStudent refresh = new HomeScreenStudent(patronId);
				refresh.setVisible(true);
			}
		});
		
		btnRefresh.setFont(new Font(".SF NS Text", btnRefresh.getFont().getStyle() | Font.BOLD, 20));
		btnRefresh.setForeground(Color.BLUE);
		btnRefresh.setBounds(729, 18, 117, 38);
		contentPane.add(btnRefresh);
		
		textField = new JTextField();
		textField.setBounds(313, 18, 207, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search;
				
				search = textField.getText();
				System.out.println(search);
				searchbook searchnew = new searchbook(search,patronId);
				
				BOOKS.setVisible(false);
				Rerserve.setVisible(false);
				Borrow.setVisible(false);
				searchnew.setVisible(true);
				searchnew.setBounds(0, 0, 638, 537);
				panel.add(searchnew);
					
			}
		});
		btnSearch.setFont(new Font(".SF NS Text", btnSearch.getFont().getStyle(), 20));
		btnSearch.setBounds(530, 18, 117, 38);
		contentPane.add(btnSearch);

	}
}
