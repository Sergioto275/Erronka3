package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import DB.*;
import conexioa.conexioa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Saioa extends JDialog {

	private final JPanel panel = new JPanel();
	private JTextField txtErabil;
	private JPasswordField passwordField;
	private Saltzailea s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			Saioa dialog = new Saioa();
	}

	/**
	 * Create the dialog.
	 */
	public Saioa() {
		setBounds(100, 100, 431, 321);
		getContentPane().setLayout(new BorderLayout());
	    setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		{
			txtErabil = new JTextField();
			txtErabil.setBounds(120, 112, 229, 26);
			panel.add(txtErabil);
			txtErabil.setColumns(10);
		}
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea :");
		lblErabiltzailea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblErabiltzailea.setBounds(23, 112, 106, 26);
		panel.add(lblErabiltzailea);
		
		JLabel lblPasahitza = new JLabel("Pasahitza :");
		lblPasahitza.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPasahitza.setBounds(43, 171, 86, 26);
		panel.add(lblPasahitza);
		
		JLabel lblNewLabel_1_1 = new JLabel("Saioa Ireki");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1_1.setBounds(113, 24, 203, 50);
		panel.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 172, 229, 26);
		panel.add(passwordField);
		
		JButton bLogin = new JButton("Login");
		bLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
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
		bLogin.setBounds(292, 237, 89, 23);
		panel.add(bLogin);
		
		JButton bAmaitu = new JButton("Amaitu");
		bAmaitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		bAmaitu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bAmaitu.setBounds(23, 237, 89, 23);
		panel.add(bAmaitu);
	}
}
