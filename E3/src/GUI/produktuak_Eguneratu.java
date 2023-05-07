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
import javax.swing.JOptionPane;

import java.awt.Font;

/**
 * produktuak_Eguneratu klasea
 * @author T1
 * @see conexioa
 * @version 06/05
 */
public class produktuak_Eguneratu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tInfo;
	private JTextField tDeskontu;
	JComboBox comboBox;
	private String[] kat;
	private String datuak=null;
	JSlider deskontua;


	/**
	 * "produktuak_Eguneratu" diseinua ematen dio
	 */
	public produktuak_Eguneratu() {
		setTitle("Produktu Prezioa Eguneratu");
		setBounds(100, 100, 517, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setLayout(null);
		{
			JButton bGehitu = new JButton("Gehitu");
			bGehitu.addActionListener(new ActionListener() {
				/**
				 * Zein kategoriak eguneratuko diren eta zenbateko prezio igoera edo jaitsiera izango duen gordetzen du String batean
				 * @param e
				 */
				public void actionPerformed(ActionEvent e) {
					if(datuak == null) {
						datuak = ""+comboBox.getItemAt(comboBox.getSelectedIndex())+"|"+deskontuaKalkulatu();
						String dat = "Kategoria: "+comboBox.getItemAt(comboBox.getSelectedIndex())+" Deskontua: "+deskontua();
						tInfo.setText(dat);
					}else {
						datuak = datuak+"_"+comboBox.getItemAt(comboBox.getSelectedIndex())+"|"+deskontuaKalkulatu();
						String dat = "Kategoria: "+comboBox.getItemAt(comboBox.getSelectedIndex())+" Deskontua: "+deskontua();
						tInfo.setText(tInfo.getText()+"\n"+dat);
					}
				}
			});
			bGehitu.setBounds(409, 92, 82, 23);
			contentPanel.add(bGehitu);
		}
		
		tInfo = new JTextField();
		tInfo.setBounds(10, 126, 481, 126);
		contentPanel.add(tInfo);
		tInfo.setColumns(10);
		
		tDeskontu = new JTextField();
		tDeskontu.setBounds(345, 93, 58, 20);
		contentPanel.add(tDeskontu);
		tDeskontu.setColumns(10);
		
		comboBox = new JComboBox();
		try {
			conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
			kat = c.produktuKatKontsulta();
		}catch(Exception e) {}
		comboBoxKargatu();
		comboBox.setBounds(10, 92, 95, 22);
		contentPanel.add(comboBox);
		
		deskontua = new JSlider();
		deskontua.addChangeListener(e -> tDeskontu.setText(deskontua()));
		deskontua.setValue(0);
		deskontua.setMinimum(-100);
		deskontua.setBounds(115, 92, 220, 26);
		contentPanel.add(deskontua);
		
		JLabel lblNewLabel = new JLabel("PRODUKTUAK EGUNERATU");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(78, 23, 346, 42);
		contentPanel.add(lblNewLabel);
		
		JButton bEguneratu = new JButton("Eguneratu");
		bEguneratu.addActionListener(new ActionListener() {
			/**
			 * Gordetako eguneraketak exekutatzen dira datu basean
			 * @param e
			 * @see conexioa#updateProd(String)
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
					c.updateProd(datuak);
		            JOptionPane.showMessageDialog(null, "Hautatutako kategorien produktuen prezioa eguneratu dira","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);        
					dispose();
				}catch(Exception ex) {
					
				}
			}
		});
		bEguneratu.setBounds(402, 263, 89, 23);
		contentPanel.add(bEguneratu);
		setVisible(true);

	}
	
	/**
	 * Produktuen kategoriak ComboBox-ean kargatzen ditu
	 */
	public void comboBoxKargatu() {
		for(int i=0;i<kat.length;i++) {
			this.comboBox.addItem(kat[i]);
		}
	}
	
	/**
	 * Zenbateko deskontua egin behar den kalkulatzen du
	 * @return deskontu
	 */
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
	
	/**
	 * Zenbateko deskontua pantailaratzeko formatua ematen dio
	 * @return deskontu
	 */
	public String deskontua() {
		String deskontu=null;
		if(deskontua.getValue()>=0) {
			deskontu = "+"+deskontua.getValue()+"%";
		}else {
			if(deskontua.getValue()<0) {
				deskontu = deskontua.getValue()+"%";
			}
		}
		return deskontu;
	}
}
