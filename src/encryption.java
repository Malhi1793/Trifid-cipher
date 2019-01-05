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

public class encryption extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					encryption frame = new encryption();
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
	public encryption() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(234, 11, 174, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(234, 101, 174, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(234, 56, 174, 34);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(234, 153, 174, 34);
		contentPane.add(textField_3);
		
		JLabel lblNameOfThe = new JLabel("Name of the file to be encrypted");
		lblNameOfThe.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		lblNameOfThe.setBounds(10, 11, 214, 34);
		contentPane.add(lblNameOfThe);
		
		JLabel lblNameOfThe_1 = new JLabel("Name of the output file");
		lblNameOfThe_1.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		lblNameOfThe_1.setBounds(10, 56, 214, 34);
		contentPane.add(lblNameOfThe_1);
		
		JLabel lblImageWhereThe = new JLabel("Image for key hiding");
		lblImageWhereThe.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		lblImageWhereThe.setBounds(10, 101, 214, 34);
		contentPane.add(lblImageWhereThe);
		
		JLabel lblNameOfEncrypted = new JLabel("Name of encrypted image");
		lblNameOfEncrypted.setFont(new Font("Roboto Condensed", Font.PLAIN, 16));
		lblNameOfEncrypted.setBounds(10, 153, 214, 34);
		contentPane.add(lblNameOfEncrypted);
		
		JButton btnStartEncryption = new JButton("Start Encryption");
		btnStartEncryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				files text = new files();
				text.encryptFile(textField.getText().toString(), textField_2.getText().toString(), textField_1.getText().toString(), textField_3.getText().toString());
				JOptionPane.showMessageDialog(null, "Encryption successful"+"\n"+"Encrypted file is saved to D:\\MALHI\\Design\\Frosh18");
			}
		});
		btnStartEncryption.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		btnStartEncryption.setBounds(253, 214, 137, 36);
		contentPane.add(btnStartEncryption);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				encryptDecrypt ed = new encryptDecrypt();
				ed.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Roboto Condensed", Font.PLAIN, 14));
		btnBack.setBounds(30, 214, 112, 36);
		contentPane.add(btnBack);
	}
}
