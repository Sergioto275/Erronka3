package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Saioa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtErabil;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Saioa dialog = new Saioa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Saioa() {
		setBounds(100, 100, 431, 321);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtErabil = new JTextField();
			txtErabil.setBounds(100, 112, 249, 26);
			contentPanel.add(txtErabil);
			txtErabil.setColumns(10);
		}
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea :");
		lblErabiltzailea.setBounds(29, 112, 74, 26);
		contentPanel.add(lblErabiltzailea);
		
		JLabel lblPasahitza = new JLabel("Pasahitza :");
		lblPasahitza.setBounds(39, 172, 64, 26);
		contentPanel.add(lblPasahitza);
		
		JLabel lblNewLabel_1_1 = new JLabel("Saioa Ireki");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1_1.setBounds(113, 24, 203, 50);
		contentPanel.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 172, 249, 26);
		contentPanel.add(passwordField);
		
		JButton bLogin = new JButton("Login");
		bLogin.setBounds(165, 236, 89, 23);
		contentPanel.add(bLogin);
	}
}
