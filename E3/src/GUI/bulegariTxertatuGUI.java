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
/**
 * bulegariTxertatuGUI klasea
 * @author T1
 * @version 06/05
 * @see conexioa
 */
public class bulegariTxertatuGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tId;
	private JTextField tIzena;
	private JTextField tAbizena;
	private JTextField tKData;
	private JTextField tEmail;
	private JTextField tIdNag;
	private JTextField tTelefono;
	private JTextField tSoldata;
	private JTextField tLanpostu;

	/**
	 * "bulegariTxertatuGUI" JDialog-aren diseinua egiten du
	 * @param modelo
	 */
	public bulegariTxertatuGUI(DefaultTableModel modelo) {
		setTitle("Bulegariak Txertatu");
		setBounds(100, 100, 719, 352);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("BULEGARI BERRIA");
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setBounds(184, 11, 304, 45);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(41, 97, 54, 33);
		contentPanel.add(lblId);
		
		JLabel lblIzena = new JLabel("Izena:");
		lblIzena.setBounds(184, 91, 54, 39);
		contentPanel.add(lblIzena);
		
		JLabel lblAbizena = new JLabel("Abizena:");
		lblAbizena.setBounds(330, 97, 54, 33);
		contentPanel.add(lblAbizena);
		
		JLabel lblEmaila = new JLabel("Emaila:");
		lblEmaila.setBounds(484, 97, 41, 33);
		contentPanel.add(lblEmaila);
		
		JLabel lblKData = new JLabel("Kontratatze Data");
		lblKData.setBounds(27, 141, 91, 33);
		contentPanel.add(lblKData);
		
		JLabel lblTelefonoa = new JLabel("Telefonoa:");
		lblTelefonoa.setBounds(221, 141, 68, 33);
		contentPanel.add(lblTelefonoa);
		
		tId = new JTextField();
		tId.setBounds(62, 103, 86, 20);
		contentPanel.add(tId);
		tId.setColumns(10);
		
		tIzena = new JTextField();
		tIzena.setColumns(10);
		tIzena.setBounds(221, 103, 86, 20);
		contentPanel.add(tIzena);
		
		tAbizena = new JTextField();
		tAbizena.setColumns(10);
		tAbizena.setBounds(380, 103, 86, 20);
		contentPanel.add(tAbizena);
		
		tKData = new JTextField();
		tKData.setColumns(10);
		tKData.setBounds(116, 147, 74, 20);
		contentPanel.add(tKData);
		
		tEmail = new JTextField();
		tEmail.setColumns(10);
		tEmail.setBounds(532, 103, 86, 20);
		contentPanel.add(tEmail);
		
		tIdNag = new JTextField();
		tIdNag.setColumns(10);
		tIdNag.setBounds(425, 147, 68, 20);
		contentPanel.add(tIdNag);
		
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
			 * Conexioa egiten du datu basearekin taulan sartutako datuak sartuko ditu datu basean bulegari berri bezala
			 * @param e
			 * @see conexioa#bulegariInsert(int, String, String, String, String, String, int, double, String, DefaultTableModel)
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
					c.bulegariInsert(Integer.parseInt(tId.getText()),tIzena.getText(),tAbizena.getText(),tEmail.getText(),tKData.getText(),tTelefono.getText(),Integer.parseInt(tIdNag.getText()),Double.parseDouble(tSoldata.getText()),tLanpostu.getText(),modelo);
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
		bAtzera.setBounds(0, 222, 103, 80);
		contentPanel.add(bAtzera);
		
		JLabel lblIdNagusi = new JLabel("Id Nagusi");
		lblIdNagusi.setBounds(365, 141, 54, 33);
		contentPanel.add(lblIdNagusi);
		
		JLabel lblSoldata = new JLabel("Soldata");
		lblSoldata.setBounds(504, 141, 54, 33);
		contentPanel.add(lblSoldata);
		
		JLabel lblErabiltzailea = new JLabel("Lanpostua");
		lblErabiltzailea.setBounds(267, 185, 68, 33);
		contentPanel.add(lblErabiltzailea);
		
		tTelefono = new JTextField();
		tTelefono.setColumns(10);
		tTelefono.setBounds(281, 147, 74, 20);
		contentPanel.add(tTelefono);
		
		tSoldata = new JTextField();
		tSoldata.setColumns(10);
		tSoldata.setBounds(544, 147, 74, 20);
		contentPanel.add(tSoldata);
		
		tLanpostu = new JTextField();
		tLanpostu.setColumns(10);
		tLanpostu.setBounds(345, 191, 74, 20);
		contentPanel.add(tLanpostu);
		setVisible(true);
	}
}
