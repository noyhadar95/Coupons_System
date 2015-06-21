package client.pl;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

public class EditCouponsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EditCouponsPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTest = new JLabel("TEST!");
		GridBagConstraints gbc_lblTest = new GridBagConstraints();
		gbc_lblTest.gridx = 7;
		gbc_lblTest.gridy = 3;
		add(lblTest, gbc_lblTest);
		
	}

}
