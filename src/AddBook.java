import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;

public class AddBook {

	private JFrame frmInsertBook;

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
		frmInsertBook.setBounds(100, 100, 1000, 800);
		frmInsertBook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInsertBook.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 984, 862);
		frmInsertBook.getContentPane().add(panel);
	}
}
