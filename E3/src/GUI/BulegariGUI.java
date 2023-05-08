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
import DB.BulegariaDB;
import DB.SaltzaileDB;
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
 * BulegariGUI klasea
 * @author T1
 * @version 06/05
 * @see conexioa
 */
public class BulegariGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private BulegariaDB bdb;
	private DefaultTableModel modelo;

	/**
	 * "BulegariGUI" JDialog-aren diseinua egiten du
	 */
	public BulegariGUI() {
		setTitle("Bulegariak");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
		setBounds(100, 100, 898, 499);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		modelo = new DefaultTableModel(null,new String[] {"ID", "IZENA", "ABIZENA", "EMAIL", "KONTRATATZE DATA", "TELEFONOA", "ID NAGUSI", "SOLDATA","LANPOSTUA", " ", "   "}) {
				boolean[] columnEditables = new boolean[] {
					false, true, true, true, true, true, true, true, true, false, false
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
			 * @see conexioa#bulegariUpdate(int, String, String, String, String, String, int, double, String)
			 * @see conexioa#bulegariDelete(int)
			 */
			public void mouseClicked(MouseEvent e) {
				if(table.getColumnName(table.getSelectedColumn()).equals(" ")) {
					try {
					conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
					int id = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 0));
					String izena = (String)(table.getValueAt(table.getSelectedRow(), 1));
					String abizena = (String)(table.getValueAt(table.getSelectedRow(), 2));
					String email = (String)(table.getValueAt(table.getSelectedRow(), 3));
					String k_data = (String)(table.getValueAt(table.getSelectedRow(), 4));
					String telefonoa = (String)(table.getValueAt(table.getSelectedRow(), 5));
					int id_nagusi = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 6));
					double soldata = Double.parseDouble(""+table.getValueAt(table.getSelectedRow(), 7));
					String lanpostua = (String)(table.getValueAt(table.getSelectedRow(), 8));
					c.bulegariUpdate(id,izena,abizena,email,k_data,telefonoa,id_nagusi,soldata,lanpostua);
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
							c.bulegariDelete(id);
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
		JLabel lBezero = new JLabel("Bulegariak");
		lBezero.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lBezero.setBounds(349, 11, 178, 48);
		contentPanel.add(lBezero);
		
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
			 * "bulegariTxertatuGUI" irekitzen du
			 * {@link bulegariTxertatuGUI}
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				bulegariTxertatuGUI sin = new bulegariTxertatuGUI(modelo);
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
	 * Taulan bulegarien informazioa ateratzeko, datu basearekin conexioa egin eta gero
	 * @see conexioa#bulegariKontsulta()
	 * {@link BulegariaDB}
	 */
	public void taulaInfo() {
		conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
		bdb = c.bulegariKontsulta();
		for(int i=0;i<bdb.getBulegariList().length;i++) {
			modelo.addRow(new Object[] {bdb.getBulegariList()[i].getId(),bdb.getBulegariList()[i].getIzena(),bdb.getBulegariList()[i].getAbizena(),bdb.getBulegariList()[i].getEmail(),bdb.getBulegariList()[i].getKontratatze_data(),bdb.getBulegariList()[i].getTelefonoa(),bdb.getBulegariList()[i].getIdNagusia(),bdb.getBulegariList()[i].getSoldata(),bdb.getBulegariList()[i].getLanpostua(),null,null});
		}
	}
}
