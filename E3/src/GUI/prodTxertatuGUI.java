package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexioa.conexioa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 * prodTxertatuGUI klasea
 * @author T1
 * @version 06/05
 * @see conexioa
 */
public class prodTxertatuGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tId;
	private JTextField tIzena;
	private JTextField tSalneurria;
	private JTextField tBalioa;
	private JTextField tDeskribapena;
	private String[] kat;
	JComboBox<String> comboBox;
	
	/**
	 * "prodTxertatuGUI" diseinua ematen dio
	 */
	public prodTxertatuGUI(DefaultTableModel modelo) {
		setTitle("Produktuak Txertatu");
		setBounds(100, 100, 719, 352);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("PRODUKTU BERRIA");
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setBounds(187, 11, 306, 45);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(41, 97, 20, 33);
		contentPanel.add(lblId);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(183, 94, 54, 39);
		contentPanel.add(lblIzena);
		
		JLabel lblDeskribapena = new JLabel("Deskribapena:");
		lblDeskribapena.setBounds(333, 167, 74, 33);
		contentPanel.add(lblDeskribapena);
		
		JLabel lblBalioa = new JLabel("Balioa:");
		lblBalioa.setBounds(484, 97, 41, 33);
		contentPanel.add(lblBalioa);
		
		JLabel lblSalneurria = new JLabel("Salneurria:");
		lblSalneurria.setBounds(95, 167, 54, 33);
		contentPanel.add(lblSalneurria);
		
		JLabel lblKategoria = new JLabel("Kategoria:");
		lblKategoria.setBounds(324, 97, 68, 33);
		contentPanel.add(lblKategoria);
		
		tId = new JTextField();
		tId.setBounds(62, 103, 86, 20);
		contentPanel.add(tId);
		tId.setColumns(10);
		
		tIzena = new JTextField();
		tIzena.setColumns(10);
		tIzena.setBounds(221, 103, 86, 20);
		contentPanel.add(tIzena);
		
		tSalneurria = new JTextField();
		tSalneurria.setColumns(10);
		tSalneurria.setBounds(152, 173, 155, 20);
		contentPanel.add(tSalneurria);
		
		tBalioa = new JTextField();
		tBalioa.setColumns(10);
		tBalioa.setBounds(532, 103, 86, 20);
		contentPanel.add(tBalioa);
		
		tDeskribapena = new JTextField();
		tDeskribapena.setColumns(10);
		tDeskribapena.setBounds(407, 173, 176, 20);
		contentPanel.add(tDeskribapena);
		
		ImageIcon insert1 = new ImageIcon("imagenes\\insertar1.png");
		ImageIcon insert2 = new ImageIcon("imagenes\\insertar2.png");
	    insert1 = new ImageIcon(insert1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
	    insert2 = new ImageIcon(insert2.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
	    ImageIcon insert3 = new ImageIcon(insert1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
		JButton bGorde = new JButton("");
		bGorde.setBorder(new EmptyBorder(0, 0, 0, 0));
		bGorde.setContentAreaFilled(false);
		bGorde.setRolloverIcon(insert3);
		bGorde.setPressedIcon(insert2);
		bGorde.setIcon(insert1);
		
		bGorde.addActionListener(new ActionListener() {
			/**
			 * Conexioa egiten du datu basearekin taulan sartutako datuak sartuko ditu datu basean produktu berri bezala
			 * @param e
			 * @see conexioa#produktuInsert(int, String, String, double, double, String, DefaultTableModel)
			 */
			public void actionPerformed(ActionEvent e) {
				try {
				conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
				String kategoria = comboBox.getItemAt(comboBox.getSelectedIndex());
				c.produktuInsert(Integer.parseInt(tId.getText()),tIzena.getText(),tDeskribapena.getText(),Double.parseDouble(tBalioa.getText()),Double.parseDouble(tSalneurria.getText()),kategoria,modelo);
	            dispose();
				}catch(Exception ex) {
					String mensaje = ""+e;
		            JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
				}
			}
		});
		bGorde.setBounds(555, 204, 148, 109);
		contentPanel.add(bGorde);
		
		ImageIcon at1 = new ImageIcon("imagenes\\atras1.png");
		ImageIcon at2 = new ImageIcon("imagenes\\atras2.png");
	    at1 = new ImageIcon(at1.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
	    at2 = new ImageIcon(at2.getImage().getScaledInstance(60,63,Image.SCALE_DEFAULT));
	    ImageIcon at3 = new ImageIcon(at1.getImage().getScaledInstance(60,63,Image.SCALE_DEFAULT));
		JButton bAtzera = new JButton("");
		bAtzera.setBorder(new EmptyBorder(0, 0, 0, 0));
		bAtzera.setContentAreaFilled(false);
		bAtzera.setRolloverIcon(at3);
		bAtzera.setPressedIcon(at2);
		bAtzera.setIcon(at1);
		bAtzera.addActionListener(new ActionListener() {
			/**
			 * JDialog-a ixten du
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bAtzera.setBounds(0, 207, 118, 95);
		contentPanel.add(bAtzera);
		
		try {
			conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
			kat = c.produktuKatKontsulta();
		}catch(Exception e) {}
		comboBox = new JComboBox<>();
		comboBoxKargatu();
	    comboBox.addActionListener(e->System.out.println(comboBox.getItemAt(comboBox.getSelectedIndex())));
		comboBox.setBounds(377, 102, 97, 22);
		contentPanel.add(comboBox);
		setVisible(true);
	}
	
	/**
	 * ComboBox-ean produktuen kategoriak kargatzen ditu
	 */
	public void comboBoxKargatu() {
		for(int i=0;i<kat.length;i++) {
			this.comboBox.addItem(kat[i]);
		}
	}
}
