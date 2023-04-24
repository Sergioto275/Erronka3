package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import DB.*;
import conexioa.conexioa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Saioa extends JDialog {

	private final JPanel panel = new JPanel();
	private JTextField txtErabil;
	private JPasswordField passwordField;
	private Saltzailea s;

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
	    setLocationRelativeTo(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		{
			txtErabil = new JTextField();
			txtErabil.setBounds(100, 112, 249, 26);
			panel.add(txtErabil);
			txtErabil.setColumns(10);
		}
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea :");
		lblErabiltzailea.setBounds(29, 112, 74, 26);
		panel.add(lblErabiltzailea);
		
		JLabel lblPasahitza = new JLabel("Pasahitza :");
		lblPasahitza.setBounds(39, 172, 64, 26);
		panel.add(lblPasahitza);
		
		JLabel lblNewLabel_1_1 = new JLabel("Saioa Ireki");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1_1.setBounds(113, 24, 203, 50);
		panel.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 172, 249, 26);
		panel.add(passwordField);
		
		JButton bLogin = new JButton("Login");
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexioa c = new conexioa("jdbc:oracle:thin:@//localhost:1521/XEPDB1","E2","E2");
				s = c.erabiltzaileKontsulta(txtErabil.getText());
				if(passwordField.getText().equals(s.getPasahitza())) {
					Menua m = new Menua(s);
					dispose();
				}else {
		              JOptionPane.showMessageDialog(null, "Pasahitza okerra","ERROREA",JOptionPane.WARNING_MESSAGE);        
				}
			}
		});
		bLogin.setBounds(165, 236, 89, 23);
		panel.add(bLogin);
	}
}
