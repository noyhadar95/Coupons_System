package pl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener {

	private final int WINDOW_WIDTH = 900, WINDOW_HEIGHT = 700;
	private int x = 5;
	
	public MainFrame() {
		super("Coupons For You");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		 this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		this.setResizable(false);

//		this.getContentPane().add(board, BorderLayout.CENTER);
//		this.getContentPane().add(menu, BorderLayout.NORTH);

		this.setFocusable(true);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	public static void main(String[] args) {

		MainFrame frame = new MainFrame();
	}

}
