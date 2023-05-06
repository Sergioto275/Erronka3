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

public class biltegiTxertatuGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tId;
	private JTextField tIzena;
	private JTextField tId_Kok;
	private JTextField tHerrialde;
	private JTextField tKontinentea;
	private JTextField tProbintzia;
	private JTextField tUdalerria;
	private JTextField tPostakodea;
	private JTextField tHelbidea;
	private JTextField tId_Herri;
	private JTextField tId_Kon;

	/**
	 * Create the dialog.
	 */
	public biltegiTxertatuGUI(DefaultTableModel modelo) {
		setTitle("Biltegiak Txertatu");
		setBounds(100, 100, 719, 352);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("BILTEGI BERRIA");
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setBounds(221, 11, 258, 45);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(41, 97, 54, 33);
		contentPanel.add(lblId);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(177, 94, 54, 39);
		contentPanel.add(lblIzena);
		
		JLabel lblHerrialde = new JLabel("Herrialde:");
		lblHerrialde.setBounds(75, 185, 61, 33);
		contentPanel.add(lblHerrialde);
		
		JLabel lblKontinentea = new JLabel("Kontinentea:");
		lblKontinentea.setBounds(444, 185, 68, 33);
		contentPanel.add(lblKontinentea);
		
		JLabel lblId_Kok = new JLabel("Kokaleku Id:");
		lblId_Kok.setBounds(317, 97, 68, 33);
		contentPanel.add(lblId_Kok);
		
		JLabel lblProbintzia = new JLabel("Probintzia:");
		lblProbintzia.setBounds(344, 141, 54, 33);
		contentPanel.add(lblProbintzia);
		
		JLabel lblUdalerria = new JLabel("Udalerria:");
		lblUdalerria.setBounds(177, 141, 54, 33);
		contentPanel.add(lblUdalerria);
		
		JLabel lblPostakodea = new JLabel("Postakodea:");
		lblPostakodea.setBounds(10, 141, 82, 33);
		contentPanel.add(lblPostakodea);
		
		tId = new JTextField();
		tId.setBounds(62, 103, 86, 20);
		contentPanel.add(tId);
		tId.setColumns(10);
		
		tIzena = new JTextField();
		tIzena.setColumns(10);
		tIzena.setBounds(221, 103, 86, 20);
		contentPanel.add(tIzena);
		
		tId_Kok = new JTextField();
		tId_Kok.setColumns(10);
		tId_Kok.setBounds(393, 103, 86, 20);
		contentPanel.add(tId_Kok);
		
		tHerrialde = new JTextField();
		tHerrialde.setColumns(10);
		tHerrialde.setBounds(129, 191, 77, 20);
		contentPanel.add(tHerrialde);
		
		tKontinentea = new JTextField();
		tKontinentea.setColumns(10);
		tKontinentea.setBounds(522, 191, 105, 20);
		contentPanel.add(tKontinentea);
		
		tProbintzia = new JTextField();
		tProbintzia.setColumns(10);
		tProbintzia.setBounds(405, 147, 86, 20);
		contentPanel.add(tProbintzia);
		
		tUdalerria = new JTextField();
		tUdalerria.setBounds(241, 147, 86, 20);
		contentPanel.add(tUdalerria);
		tUdalerria.setColumns(10);
		
		tPostakodea = new JTextField();
		tPostakodea.setColumns(10);
		tPostakodea.setBounds(93, 147, 77, 20);
		contentPanel.add(tPostakodea);
		
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
					c.biltegiInsert(Integer.parseInt(tId.getText()),tIzena.getText(),tHelbidea.getText(),tKontinentea.getText(),tHerrialde.getText(),tProbintzia.getText(),tUdalerria.getText(),tPostakodea.getText(),Integer.parseInt(tId_Kon.getText()),tId_Herri.getText(),Integer.parseInt(tId_Kok.getText()),modelo);
		            dispose();
				}catch(Exception ex) {
					String mensaje = ""+e;
		            JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
				}
			}
		});
		bGorde.setBounds(555, 204, 148, 109);
		contentPanel.add(bGorde);
		
		JButton bAtzera = new JButton("");
		bAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bAtzera.setContentAreaFilled(false);
		bAtzera.setBorder(new EmptyBorder(0, 0, 0, 0));
		bAtzera.setBounds(10, 211, 98, 102);
		contentPanel.add(bAtzera);
		
		ImageIcon at1 = new ImageIcon("imagenes\\atras1.png");
		ImageIcon at2 = new ImageIcon("imagenes\\atras2.png");
	    at1 = new ImageIcon(at1.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
	    at2 = new ImageIcon(at2.getImage().getScaledInstance(60,63,Image.SCALE_DEFAULT));
	    ImageIcon at3 = new ImageIcon(at1.getImage().getScaledInstance(60,63,Image.SCALE_DEFAULT));
		bAtzera.setRolloverIcon(at3);
		bAtzera.setPressedIcon(at2);
		bAtzera.setIcon(at1);
		
		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setBounds(490, 97, 54, 33);
		contentPanel.add(lblHelbidea);
		
		tHelbidea = new JTextField();
		tHelbidea.setColumns(10);
		tHelbidea.setBounds(555, 103, 86, 20);
		contentPanel.add(tHelbidea);
		
		tId_Herri = new JTextField();
		tId_Herri.setColumns(10);
		tId_Herri.setBounds(576, 147, 77, 20);
		contentPanel.add(tId_Herri);
		
		JLabel lblId_Herrialde = new JLabel("Herrialde Id:");
		lblId_Herrialde.setBounds(500, 141, 68, 33);
		contentPanel.add(lblId_Herrialde);
		
		tId_Kon = new JTextField();
		tId_Kon.setColumns(10);
		tId_Kon.setBounds(317, 191, 105, 20);
		contentPanel.add(tId_Kon);
		
		JLabel lblId_Kontinentea = new JLabel("Kontinente Id:");
		lblId_Kontinentea.setBounds(226, 185, 77, 33);
		contentPanel.add(lblId_Kontinentea);
		
		setVisible(true);
	}
}
