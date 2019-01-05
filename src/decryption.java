import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class decryption extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					decryption frame = new decryption();
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
	public decryption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(230, 44, 174, 34);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(230, 106, 174, 34);
		contentPane.add(textField_1);
		
		JLabel lblNameOfThe = new JLabel("Name of the file to be decrypted");
		lblNameOfThe.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		lblNameOfThe.setBounds(10, 42, 214, 34);
		contentPane.add(lblNameOfThe);
		
		JLabel lblNameOfThe_1 = new JLabel("Name of the image key");
		lblNameOfThe_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		lblNameOfThe_1.setBounds(10, 106, 214, 34);
		contentPane.add(lblNameOfThe_1);
		
		JButton btnStartDecryption = new JButton("Start Decryption");
		btnStartDecryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				files text = new files();
				text.decryptFile(textField.getText().toString(), textField_1.getText().toString());
				JOptionPane.showMessageDialog(null, "Decryption successful"+"\n"+"Decrypted file is saved to D:\\MALHI\\Design\\Frosh18");
			}
		});
		btnStartDecryption.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		btnStartDecryption.setBounds(244, 189, 137, 36);
		contentPane.add(btnStartDecryption);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				encryptDecrypt ed = new encryptDecrypt();
				ed.setVisible(true);
			}
		});
		button.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		button.setBounds(42, 189, 112, 36);
		contentPane.add(button);
	}

}
