import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import sun.security.action.OpenFileInputStreamAction;

import java.awt.Color;

public class ChooseFile extends JFrame {

	private JPanel contentPane;
	private String path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseFile frame = new ChooseFile();
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
	public ChooseFile() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 700, 500);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = chooser.showOpenDialog(contentPane);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
//		   System.out.println("You chose to open this directory: " + chooser.getSelectedFile().getAbsolutePath());
		   path=chooser.getSelectedFile().getAbsolutePath();
		}
			
		
	}

	public String getPath() {
		return path;
	}


	
}
