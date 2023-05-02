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

public class eskTxertatuGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tId;
	private JTextField tId_bezero;
	private JTextField tData;
	private JTextField tId_Saltzaile;
	private String[] kat;
	JComboBox<String> comboBox;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			eskTxertatuGUI dialog = new eskTxertatuGUI(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public eskTxertatuGUI(DefaultTableModel modelo) {
		setBounds(100, 100, 537, 350);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ESKARI BERRIA");
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setBounds(116, 21, 306, 45);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(41, 97, 20, 33);
		contentPanel.add(lblId);
		
		JLabel lblIzena = new JLabel("Id Bezero:");
		lblIzena.setBounds(183, 94, 54, 39);
		contentPanel.add(lblIzena);
		
		JLabel lblBalioa = new JLabel("Egoera:");
		lblBalioa.setBounds(305, 167, 41, 33);
		contentPanel.add(lblBalioa);
		
		JLabel lblSalneurria = new JLabel("Data:");
		lblSalneurria.setBounds(95, 167, 54, 33);
		contentPanel.add(lblSalneurria);
		
		JLabel lblKategoria = new JLabel("Id Saltzaile:");
		lblKategoria.setBounds(360, 97, 68, 33);
		contentPanel.add(lblKategoria);
		
		tId = new JTextField();
		tId.setBounds(62, 103, 86, 20);
		contentPanel.add(tId);
		tId.setColumns(10);
		
		tId_bezero = new JTextField();
		tId_bezero.setColumns(10);
		tId_bezero.setBounds(235, 103, 86, 20);
		contentPanel.add(tId_bezero);
		
		tData = new JTextField();
		tData.setColumns(10);
		tData.setBounds(128, 173, 155, 20);
		contentPanel.add(tData);
		
		tId_Saltzaile = new JTextField();
		tId_Saltzaile.setColumns(10);
		tId_Saltzaile.setBounds(416, 103, 86, 20);
		contentPanel.add(tId_Saltzaile);
		
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
			public void actionPerformed(ActionEvent e) {
				try {
				conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
				String egoera = comboBox.getItemAt(comboBox.getSelectedIndex());
				c.eskariInsert(Integer.parseInt(tId.getText()),Integer.parseInt(tId_bezero.getText()),Integer.parseInt(tId_Saltzaile.getText()),tData.getText(),egoera);
				modelo.addRow(new Object[] {tId.getText(),tId_bezero.getText(),comboBox.getItemAt(comboBox.getSelectedIndex()),tId_Saltzaile.getText(),tData.getText(),null,null});
	            JOptionPane.showMessageDialog(null,"Hilara bat txertatu da","TXERTAKETA",JOptionPane.INFORMATION_MESSAGE);
	            dispose();
				}catch(Exception ex) {
					String mensaje = ""+e;
		            JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
				}
			}
		});
		bGorde.setBounds(373, 202, 148, 109);
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
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bAtzera.setBounds(0, 207, 118, 95);
		contentPanel.add(bAtzera);
		
		try {
			conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
			kat = c.eskariEgKontsulta();
		}catch(Exception e) {}
		comboBox = new JComboBox<>();
		comboBoxKargatu();
	    comboBox.addActionListener(e->System.out.println(comboBox.getItemAt(comboBox.getSelectedIndex())));
		comboBox.setBounds(348, 172, 97, 22);
		contentPanel.add(comboBox);
		setVisible(true);
	}
	
	public void comboBoxKargatu() {
		for(int i=0;i<kat.length;i++) {
			this.comboBox.addItem(kat[i]);
		}
	}
}
