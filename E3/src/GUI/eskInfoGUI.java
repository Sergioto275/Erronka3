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

public class eskInfoGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modelo;
	private EskariDB edb;
	private int eskId;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public eskInfoGUI(int id) {
		this.eskId = id;
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
		
		JLabel lblProduktu = new JLabel("Produktuak");
		lblProduktu.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblProduktu.setBounds(361, 11, 167, 65);
		contentPanel.add(lblProduktu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 108, 715, 207);
		contentPanel.add(scrollPane);
		
		modelo = new DefaultTableModel(null,new String[] {"ID","ID_PRODUKTU","KOPURUA","SALNEURRIA"," ", "   "}) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}};
		table = new DTable();
		table.setRowHeight(25);
		taulaInfo();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getColumnName(table.getSelectedColumn()).equals(" ")) {
					try {
						conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
						int id = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 0));
						int idProd = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 1));
						int kopurua = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 2));
						Double salneurria = Double.parseDouble(""+table.getValueAt(table.getSelectedRow(), 3));
						c.eskariInfoUpdate(eskId,id, idProd, kopurua, salneurria);
			            JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception ex) {
						String mensaje = ""+e;
			            JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
					}
				}else {
					if(table.getColumnName(table.getSelectedColumn()).equals("   ")) {
						try{
							conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
							int id = Integer.parseInt(""+table.getValueAt(table.getSelectedRow(), 0));
							c.eskariInfoDelete(eskId,id);
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
		setVisible(true);
	}
	
	public void taulaInfo() {
		conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
		edb = c.eskariKontsulta();
		for(int i=0;i<edb.getEskariList()[this.eskId].getProduktu_kop().length;i++) {
			modelo.addRow(new Object[] {edb.getEskariList()[this.eskId].getProduktu_kop()[i].getId(),edb.getEskariList()[this.eskId].getProduktu_kop()[i].getIdProd(),edb.getEskariList()[this.eskId].getProduktu_kop()[i].getKopurua(),edb.getEskariList()[this.eskId].getProduktu_kop()[i].getSalneurria(),null,null});
		}
	}
}
