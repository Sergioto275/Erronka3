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
import DB.Bezeroa;
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
 * BezeroGUI Klasea
 * @author T1
 * @version 06/05
 * @see BezeroDB
 * @see conexioa
 */
public class BezeroGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private BezeroDB bdb;
	private DefaultTableModel modelo;

	/**
	 * "BezeroGUI" JDialog-aren diseinua egiten du
	 */
	public BezeroGUI() {
		setTitle("Bezeroak");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
		setBounds(100, 100, 898, 499);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		modelo = new DefaultTableModel(null,new String[] {"ID", "IZENA", "ABIZENA", "HELBIDEA", "EMAIL", "TELEFONOA", " ", "   "}) {
				boolean[] columnEditables = new boolean[] {
					false, true, true, true, true, true, false, false
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
			 * @see conexioa#bezeroUpdate(int, String, String, String, String, String)
			 * @see conexioa#bezeroDelete(int)
			 */
			public void mouseClicked(MouseEvent e) {
				if(table.getColumnName(table.getSelectedColumn()).equals(" ")) {
					try {
					conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
					int id = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 0));
					String izena = (String)(table.getValueAt(table.getSelectedRow(), 1));
					String abizena = (String)(table.getValueAt(table.getSelectedRow(), 2));
					String helbidea = (String)(table.getValueAt(table.getSelectedRow(), 3));
					String email = (String)(table.getValueAt(table.getSelectedRow(), 4));
					String telefonoa = (String)(table.getValueAt(table.getSelectedRow(), 5));
					c.bezeroUpdate(id,izena,abizena,email,helbidea,telefonoa);
					}catch(Exception ex) {
						String mensaje = ""+e;
						JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
					}
				}else {
					if(table.getColumnName(table.getSelectedColumn()).equals("   ")) {
						try {
							conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
							int id = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 0));
							c.bezeroDelete(id);
							modelo.removeRow(table.getSelectedRow());
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
		JLabel lBezero = new JLabel("Bezeroak");
		lBezero.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lBezero.setBounds(364, 11, 132, 48);
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
			 * "bezeroTxertatuGUI" irekitzen du
			 * {@link bezeroTxertatuGUI}
			 * @param e
			 * @see bezeroTxertatuGUI
			 */
			public void actionPerformed(ActionEvent e) {
				bezeroTxertatuGUI bin = new bezeroTxertatuGUI(modelo);
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
	 * Taulan bezeroen informazioa ateratzeko, datu basearekin conexioa egin eta gero
	 * {@link BezeroDB}
	 * @see conexioa#bezeroKontsulta()
	 */
	public void taulaInfo() {
		conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
		bdb = c.bezeroKontsulta();
		for(int i=0;i<bdb.getBezeroList().length;i++) {
			modelo.addRow(new Object[] {bdb.getBezeroList()[i].getId(),bdb.getBezeroList()[i].getIzena(),bdb.getBezeroList()[i].getAbizena(),bdb.getBezeroList()[i].getHelbidea(),bdb.getBezeroList()[i].getEmail(),bdb.getBezeroList()[i].getTelefonoa(),null,null});
		}
	}
}
