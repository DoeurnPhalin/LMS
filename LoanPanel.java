

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class LoanPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LoanPanel() {
		setLayout(null);
		
		JLabel lblBookLoan = new JLabel("   Book Loan");
		lblBookLoan.setBackground(Color.ORANGE);
		lblBookLoan.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblBookLoan.setBounds(0, 0, 450, 50);
		add(lblBookLoan);

	}

}
