package pl;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class tempFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private final int WINDOW_WIDTH = 900, WINDOW_HEIGHT = 700;
	private int x = 5;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					tempFrame frame = new tempFrame();
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
	public tempFrame() {
		super("temp");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		 this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		 AdminEditCoupons v=new AdminEditCoupons();
		 this.getContentPane().add(v, BorderLayout.CENTER);
		 
		this.setResizable(false);

//		this.getContentPane().add(board, BorderLayout.CENTER);
//		this.getContentPane().add(menu, BorderLayout.NORTH);

		this.setFocusable(true);

		this.setVisible(true);
	}

}
