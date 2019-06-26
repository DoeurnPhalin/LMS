
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBook {

	private JFrame frmInsertBook;
	private JTextField textField;
	private JTextField textField_tittle;
	private JTextField textField_author;
	private JTextField textField_publisher;
	private JTextField textField_category;
	private JTextField textField_type;
	private JTextField textField_shelf;
	private JTextField textField_amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook window = new AddBook();
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
		
		textField = new JTextField();
		textField.setBounds(179, 108, 697, 20);
		panel.add(textField);
		textField.setColumns(10);
		
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
		panel.add(textField_amount);
		textField_amount.setColumns(10);
		
		JLabel lblfeedback = new JLabel("Feedback");
		lblfeedback.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblfeedback.setForeground(Color.RED);
		lblfeedback.setBounds(179, 313, 731, 34);
		panel.add(lblfeedback);
		
		JLabel lblStatus = new JLabel("");
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblStatus.setIcon(new ImageIcon("D:\\JAVA\\LMS\\img\\check.png"));
				
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
}
