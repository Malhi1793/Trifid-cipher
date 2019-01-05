import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class encryptDecrypt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					encryptDecrypt frame = new encryptDecrypt();
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
	public encryptDecrypt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWhichOperationDo = new JLabel("Which operation do you want to perform?");
		lblWhichOperationDo.setFont(new Font("Roboto Condensed", Font.PLAIN, 18));
		lblWhichOperationDo.setBounds(78, 51, 346, 61);
		contentPane.add(lblWhichOperationDo);
		
		JButton btnEncryption = new JButton("Encryption");
		btnEncryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				encryption enc = new encryption();
				enc.setVisible(true);
			}
		});
		btnEncryption.setFont(new Font("Roboto Condensed", Font.PLAIN, 11));
		btnEncryption.setBounds(110, 150, 89, 23);
		contentPane.add(btnEncryption);
		
		JButton btnDecryption = new JButton("Decryption");
		btnDecryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				decryption dec = new decryption();
				dec.setVisible(true);
			}
		});
		btnDecryption.setFont(new Font("Roboto Condensed", Font.PLAIN, 11));
		btnDecryption.setBounds(236, 150, 89, 23);
		contentPane.add(btnDecryption);
	}

}
