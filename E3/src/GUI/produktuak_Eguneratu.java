package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexioa.conexioa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;

public class produktuak_Eguneratu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tInfo;
	private JTextField tDeskontu;
	JComboBox comboBox;
	private String[] kat;
	private String datuak=null;
	JSlider deskontua;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			produktuak_Eguneratu dialog = new produktuak_Eguneratu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public produktuak_Eguneratu() {
		setTitle("Produktu Prezioa Eguneratu");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setLayout(null);
		{
			JButton bGehitu = new JButton("Gehitu");
			bGehitu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(datuak == null) {
						datuak = ""+comboBox.getItemAt(comboBox.getSelectedIndex())+"|"+deskontuaKalkulatu();
						String dat = "Kategoria: "+comboBox.getItemAt(comboBox.getSelectedIndex())+" Deskontua: "+deskontua.getValue();
						tInfo.setText(dat);
					}else {
						datuak = datuak+"_"+comboBox.getItemAt(comboBox.getSelectedIndex())+"|"+deskontuaKalkulatu();
						String dat = "Kategoria: "+comboBox.getItemAt(comboBox.getSelectedIndex())+" Deskontua: "+deskontua.getValue();
						tInfo.setText(tInfo.getText()+"\n"+dat);
					}
				}
			});
			bGehitu.setBounds(318, 92, 89, 23);
			contentPanel.add(bGehitu);
		}
		
		tInfo = new JTextField();
		tInfo.setBounds(10, 121, 414, 95);
		contentPanel.add(tInfo);
		tInfo.setColumns(10);
		
		tDeskontu = new JTextField();
		tDeskontu.setBounds(278, 93, 30, 20);
		contentPanel.add(tDeskontu);
		tDeskontu.setColumns(10);
		
		comboBox = new JComboBox();
		try {
			conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
			kat = c.produktuKatKontsulta();
		}catch(Exception e) {}
		comboBoxKargatu();
		comboBox.setBounds(22, 92, 60, 22);
		contentPanel.add(comboBox);
		
		deskontua = new JSlider();
		
		deskontua.setValue(0);
		deskontua.setMinimum(-100);
		deskontua.setBounds(87, 92, 180, 26);
		contentPanel.add(deskontua);
		
		JLabel lblNewLabel = new JLabel("PRODUKTUAK EGUNERATU");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(97, 27, 226, 36);
		contentPanel.add(lblNewLabel);
		
		JButton bEguneratu = new JButton("Eguneratu");
		bEguneratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
					c.updateProd(datuak);
				}catch(Exception ex) {
					
				}
			}
		});
		bEguneratu.setBounds(335, 227, 89, 23);
		contentPanel.add(bEguneratu);
		setVisible(true);

	}
	
	public void comboBoxKargatu() {
		for(int i=0;i<kat.length;i++) {
			this.comboBox.addItem(kat[i]);
		}
	}
	
	public String deskontuaKalkulatu() {
		String deskontu=null;
		if(deskontua.getValue()>0) {
			deskontu = "1,"+(deskontua.getValue());
		}else {
			if(deskontua.getValue()<0) {
				deskontu = "0,"+(-deskontua.getValue());
			}else {
				deskontu = "1";
			}
		}
		return deskontu;
	}
}
