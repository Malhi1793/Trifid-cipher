import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class appPane1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appPane1 window = new appPane1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public appPane1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Run");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				encryptDecrypt ed = new encryptDecrypt();
				ed.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Roboto Condensed", Font.PLAIN, 18));
		btnNewButton.setBounds(153, 148, 128, 49);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblClickRunTo = new JLabel("Click Run to begin");
		lblClickRunTo.setFont(new Font("Roboto Condensed", Font.PLAIN, 18));
		lblClickRunTo.setBounds(153, 44, 160, 69);
		frame.getContentPane().add(lblClickRunTo);
	}
}
