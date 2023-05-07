package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DB.BezeroDB;
import DB.BiltegiDB;
import conexioa.conexioa;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * BiltegiGUI klasea
 * @author T1
 * @version 06/05
 * @see conexioa
 */
public class BiltegiGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private BiltegiDB bdb;
	private DefaultTableModel modelo;

	/**
	 * "BiltgiGUI" JDialog-aren diseinua egiten du
	 */
	public BiltegiGUI() {
		setTitle("Biltegiak");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
		setBounds(100, 100, 898, 499);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		modelo = new DefaultTableModel(null,new String[] {"ID", "IZENA","ID KOKALEKU", "HELBIDEA", "UDALERRIA", "POSTAKODEA", "PROBINTZIA","ID HERRIALDE", "HERRIALDE",  "ID KONTINENTE", "KONTINENTEA", " ", "   "}) {
				boolean[] columnEditables = new boolean[] {
					false, true, true, true, true, true, true, true, true, true, true, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}};
		taulaInfo();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 63, 705, 283);
		contentPanel.add(scrollPane);
		table = new DTable();
		table.setRowHeight(25);
		table.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Conexioa egiten du datu basearekin taulan sartutako datuak eguneratu edo ezabatuko ditu datu basean.
			 * @param e
			 * @see conexioa#biltegiUpdate(int, String, String, String, String, String, String, String, int, String, int)
			 * @see conexioa#biltegiDelete(int)
			 */
			public void mouseClicked(MouseEvent e) {
				if(table.getColumnName(table.getSelectedColumn()).equals(" ")) {
					try {
					conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
					int id = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 0));
					String izena = (String)(table.getValueAt(table.getSelectedRow(), 1));
					int id_kokaleku = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 2));
					String helbidea = (String)(table.getValueAt(table.getSelectedRow(), 3));
					String udalerria = (String)(table.getValueAt(table.getSelectedRow(), 4));
					String postakodea = (String)(table.getValueAt(table.getSelectedRow(), 5));
					String probintzia = (String)(table.getValueAt(table.getSelectedRow(), 6));
					String id_herrialde = (String)(table.getValueAt(table.getSelectedRow(), 7));
					String herrialde = (String)(table.getValueAt(table.getSelectedRow(), 8));
					int id_kontinente = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 9));
					String kontinentea = (String)(table.getValueAt(table.getSelectedRow(), 10));
					c.biltegiUpdate(id,izena,helbidea,kontinentea,herrialde,probintzia,udalerria,postakodea, id_kontinente, id_herrialde, id_kokaleku);
		            JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception ex) {
						String mensaje = ""+e;
						JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
					}
				}else {
					if(table.getColumnName(table.getSelectedColumn()).equals("   ")) {
						try {
							conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
							int id = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 0));
							c.biltegiDelete(id);
							modelo.removeRow(table.getSelectedRow());
				            JOptionPane.showMessageDialog(null,"Hilara ezabatu da","EZABAKETA",JOptionPane.INFORMATION_MESSAGE);
						}catch(Exception ex) {
							String mensaje = ""+e;
				            JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
						}
					}
				}
			}
		});
		
		
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		JLabel lBiltegi = new JLabel("Biltegiak");
		lBiltegi.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lBiltegi.setBounds(364, 11, 132, 48);
		contentPanel.add(lBiltegi);
		
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
		bAtzera.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * JDialog-a ixten du
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		bAtzera.setBounds(717, 357, 132, 91);
		contentPanel.add(bAtzera);
		ImageIcon insert1 = new ImageIcon("imagenes\\insertar1.png");
		ImageIcon insert2 = new ImageIcon("imagenes\\insertar2.png");
	    insert1 = new ImageIcon(insert1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
	    insert2 = new ImageIcon(insert2.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
	    ImageIcon insert3 = new ImageIcon(insert1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
		JButton bTxertatu = new JButton("");
		bTxertatu.addActionListener(new ActionListener() {
			/**
			 * "biltegiTxertatuGUI" irekitzen du
			 * {@link biltegiTxertatuGUI}
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				biltegiTxertatuGUI bin = new biltegiTxertatuGUI(modelo);
			}
		});
		bTxertatu.setContentAreaFilled(false);
		bTxertatu.setBorder(new EmptyBorder(0, 0, 0, 0));
		bTxertatu.setBackground(Color.LIGHT_GRAY);
		bTxertatu.setRolloverIcon(insert3);
		bTxertatu.setPressedIcon(insert2);
		bTxertatu.setIcon(insert1);
		bTxertatu.setBounds(10, 357, 132, 102);
		contentPanel.add(bTxertatu);
		setVisible(true);
	}
	/**
	 * Taulan biltegien informazioa ateratzeko, datu basearekin conexioa egin eta gero
	 * @see conexioa#biltegiKontsulta()
	 * {@link BiltegiDB}
	 */
	public void taulaInfo() {
		conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
		bdb = c.biltegiKontsulta();
		for(int i=0;i<bdb.getBiltegiList().length;i++) {
			modelo.addRow(new Object[] {bdb.getBiltegiList()[i].getId(),bdb.getBiltegiList()[i].getIzena(),bdb.getBiltegiList()[i].getId_kokaleku(),bdb.getBiltegiList()[i].getHelbidea(),bdb.getBiltegiList()[i].getUdalerria(),bdb.getBiltegiList()[i].getPostakodea(),bdb.getBiltegiList()[i].getProbintzia(),bdb.getBiltegiList()[i].getId_herrialde(),bdb.getBiltegiList()[i].getHerrialde(),bdb.getBiltegiList()[i].getId_kontinente(),bdb.getBiltegiList()[i].getKontinentea(),null,null});
		}
	}																												
}
