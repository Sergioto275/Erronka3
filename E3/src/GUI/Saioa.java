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
	private boolean vis;
	

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
		setTitle("Saioa Ireki");
		setBounds(100, 100, 433, 321);
		getContentPane().setLayout(new BorderLayout());
	    setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		{
			txtErabil = new JTextField();
			txtErabil.setBounds(120, 97, 229, 26);
			panel.add(txtErabil);
			txtErabil.setColumns(10);
		}
		
		JLabel lblErabiltzailea = new JLabel("Erabiltzailea :");
		lblErabiltzailea.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblErabiltzailea.setBounds(23, 97, 106, 26);
		panel.add(lblErabiltzailea);
		
		JLabel lblPasahitza = new JLabel("Pasahitza :");
		lblPasahitza.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPasahitza.setBounds(43, 156, 86, 26);
		panel.add(lblPasahitza);
		
		JLabel lblNewLabel_1_1 = new JLabel("Saioa Ireki");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1_1.setBounds(113, 24, 203, 50);
		panel.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 157, 229, 26);
    	passwordField.setEchoChar('*');
		panel.add(passwordField);
		ImageIcon ap1 = new ImageIcon("imagenes\\apagar1.png");
		ImageIcon ap2 = new ImageIcon("imagenes\\apagar2.png");
	    ap1 = new ImageIcon(ap1.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
	    ap2 = new ImageIcon(ap2.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
	    ImageIcon ap3 = new ImageIcon(ap1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
	    ImageIcon in1 = new ImageIcon("imagenes\\inicio_sesion1.png");
		ImageIcon in2 = new ImageIcon("imagenes\\inicio_sesion2.png");
	    in1 = new ImageIcon(in1.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
	    in2 = new ImageIcon(in2.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
	    ImageIcon in3 = new ImageIcon(in1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
		JButton bLogin = new JButton("");
		bLogin.setHorizontalTextPosition(SwingConstants.LEFT);
		bLogin.setVerticalTextPosition(SwingConstants.TOP);
		bLogin.setHorizontalAlignment(SwingConstants.LEFT);
		bLogin.setFocusTraversalPolicyProvider(true);
		bLogin.setVerticalAlignment(SwingConstants.TOP);
		bLogin.setContentAreaFilled(false);
		bLogin.setRolloverIcon(in3);
		bLogin.setPressedIcon(in2);
		bLogin.setIcon(in1);
		bLogin.setBorder(new EmptyBorder(0, 0, 0, 0));
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
				s = c.erabiltzaileKontsulta(txtErabil.getText());
				if(passwordField.getText().equals(s.getPasahitza())) {
					Menua m = new Menua(s);
					dispose();
				}else {
		              JOptionPane.showMessageDialog(null, "Pasahitza okerra","ERROREA",JOptionPane.WARNING_MESSAGE);        
				}
			}
		});
		bLogin.setBounds(320, 211, 65, 60);
		panel.add(bLogin);
		
		JButton bAmaitu = new JButton();
		bAmaitu.setVerticalTextPosition(SwingConstants.BOTTOM);
		bAmaitu.setHorizontalTextPosition(SwingConstants.CENTER);
		bAmaitu.setContentAreaFilled(false);
		bAmaitu.setBackground(Color.LIGHT_GRAY);
		bAmaitu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		bAmaitu.setRolloverIcon(ap3);
		bAmaitu.setPressedIcon(ap2);
		bAmaitu.setIcon(ap1);
		bAmaitu.setBorder(new EmptyBorder(0, 0, 0, 0));
		bAmaitu.setBounds(0, 199, 106, 83);
		panel.add(bAmaitu);
		vis = false;
		JButton visible = new JButton("");
		visible.setContentAreaFilled(false);
		visible.setBorder(new EmptyBorder(0, 0, 0, 0));
		ImageIcon vis1 = new ImageIcon("imagenes\\ikusi1.png");
		ImageIcon vis2 = new ImageIcon("imagenes\\ikusi2.png");
		ImageIcon vis3 = new ImageIcon(vis1.getImage().getScaledInstance(35,20,Image.SCALE_DEFAULT));
		ImageIcon vis4 = new ImageIcon(vis2.getImage().getScaledInstance(35,20,Image.SCALE_DEFAULT));
		visible.setIcon(vis3);
		visible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!vis) {
					passwordField.setEchoChar((char) 0);
					vis = true;
					visible.setIcon(vis3);
	            } else {
	            	passwordField.setEchoChar('*');
	            	vis =false;
	        		visible.setIcon(vis4);
	            }
			}
		});
	
		visible.setBounds(359, 156, 48, 26);
		panel.add(visible);
		setVisible(true);
	}
}
