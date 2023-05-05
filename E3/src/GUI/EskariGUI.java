package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DB.EskariDB;
import DB.Inbentario;
import DB.ProduktuDB;
import conexioa.conexioa;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;

public class EskariGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modelo;
	private EskariDB edb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EskariGUI dialog = new EskariGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EskariGUI() {
		setTitle("Eskariak");
		setBounds(100, 100, 897, 498);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		ImageIcon insert1 = new ImageIcon("imagenes\\insertar1.png");
		ImageIcon insert2 = new ImageIcon("imagenes\\insertar2.png");
	    insert1 = new ImageIcon(insert1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
	    insert2 = new ImageIcon(insert2.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
	    ImageIcon insert3 = new ImageIcon(insert1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
		JButton bTxertatu = new JButton("");
		bTxertatu.setContentAreaFilled(false);
		bTxertatu.setBorder(new EmptyBorder(0, 0, 0, 0));
		bTxertatu.setBackground(Color.LIGHT_GRAY);
		bTxertatu.setRolloverIcon(insert3);
		bTxertatu.setPressedIcon(insert2);
		bTxertatu.setIcon(insert1);
		bTxertatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eskTxertatuGUI p = new eskTxertatuGUI(modelo);
			}
		});
		bTxertatu.setBounds(10, 341, 118, 107);
		contentPanel.add(bTxertatu);
		
		ImageIcon at1 = new ImageIcon("imagenes\\atras1.png");
		ImageIcon at2 = new ImageIcon("imagenes\\atras2.png");
	    at1 = new ImageIcon(at1.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
	    at2 = new ImageIcon(at2.getImage().getScaledInstance(60,63,Image.SCALE_DEFAULT));
	    ImageIcon at3 = new ImageIcon(at1.getImage().getScaledInstance(60,63,Image.SCALE_DEFAULT));
		JButton bAtzera = new JButton("");
		bAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		bAtzera.setBorder(new EmptyBorder(0, 0, 0, 0));
		bAtzera.setContentAreaFilled(false);
		bAtzera.setRolloverIcon(at3);
		bAtzera.setPressedIcon(at2);
		bAtzera.setIcon(at1);
		bAtzera.setBounds(740, 362, 112, 86);
		contentPanel.add(bAtzera);
		
		JLabel lblEskariak = new JLabel("Eskariak");
		lblEskariak.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblEskariak.setBounds(361, 11, 167, 65);
		contentPanel.add(lblEskariak);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 108, 715, 207);
		contentPanel.add(scrollPane);
		
		modelo = new DefaultTableModel(null,new String[] {"ID", "ID BEZERO", "EGOERA", "ID SALTZAILE", "DATA", "  ", " ", "   "}) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}};
		table = new DTable();
		table.setRowHeight(25);
		taulaInfo();
		table.setModel(modelo);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getColumnName(table.getSelectedColumn()).equals(" ")) {
					try {
						conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
						int id = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 0));
						int id_bez = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 1));
						int id_saltzaile = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 3));
						String data = (String)(table.getValueAt(table.getSelectedRow(), 4).toString());
						String deskribapena = (String)(table.getValueAt(table.getSelectedRow(), 4).toString());
						c.eskariUpdate(id,id_bez,id_saltzaile,data,deskribapena);
			            JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception ex) {
						String mensaje = ""+e;
						System.out.println(mensaje);
			            JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
					}
				}else {
					if(table.getColumnName(table.getSelectedColumn()).equals("   ")) {
						try{
							conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
							int id = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 0));
							c.eskariDelete(id);
							modelo.removeRow(table.getSelectedRow());
				            JOptionPane.showMessageDialog(null,"Hilara ezabatu da","EZABAKETA",JOptionPane.INFORMATION_MESSAGE);
						}catch(Exception ex) {
							String mensaje = ""+e;
				            JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
						}
					}else {
						if(table.getColumnName(table.getSelectedColumn()).equals("  ")) {
							int index = (int)(table.getValueAt(table.getSelectedRow(), 0));
							eskInfoGUI inb = new eskInfoGUI(index);
						}
					}
				}
			}
		});
		setVisible(true);
	}
	
	public void taulaInfo() {
		conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
		edb = c.eskariKontsulta();
		for(int i=0;i<edb.getEskariList().length;i++) {
			modelo.addRow(new Object[] {edb.getEskariList()[i].getId(),edb.getEskariList()[i].getBezero_izena(),edb.getEskariList()[i].getEgoera(),edb.getEskariList()[i].getSaltzaile_izena(),edb.getEskariList()[i].getData(),null,null,null});
		}
	}
	
}
