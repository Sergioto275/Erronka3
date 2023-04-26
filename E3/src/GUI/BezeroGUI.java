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
import conexioa.conexioa;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class BezeroGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private BezeroDB bdb;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BezeroGUI dialog = new BezeroGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BezeroGUI() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
		setVisible(true);
		setBounds(100, 100, 896, 498);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		modelo = new DefaultTableModel(null,new String[] {"ID", "IZENA", "ABIZENA", "HELBIDEA", "EMAIL", "TELEFONOA", " ", "  "}) {
				boolean[] columnEditables = new boolean[] {
					true, true, true, true, true, true, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}};
		taulaInfo();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 63, 705, 283);
		contentPanel.add(scrollPane);
		table = new DTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getColumnName(table.getSelectedColumn()).equals(" ")) {
					System.out.println("Gorde");
				}else {
					if(table.getColumnName(table.getSelectedColumn()).equals("  ")) {
						System.out.println("Ezabatu");
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
		bAtzera.setContentAreaFilled(false);
		bAtzera.setRolloverIcon(at3);
		bAtzera.setPressedIcon(at2);
		bAtzera.setIcon(at1);
		bAtzera.addMouseListener(new MouseAdapter() {
			@Override
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
		bTxertatu.setContentAreaFilled(false);
		bTxertatu.setBorder(new EmptyBorder(0, 0, 0, 0));
		bTxertatu.setBackground(Color.LIGHT_GRAY);
		bTxertatu.setRolloverIcon(insert3);
		bTxertatu.setPressedIcon(insert2);
		bTxertatu.setIcon(insert1);
		bTxertatu.setBounds(10, 357, 132, 102);
		contentPanel.add(bTxertatu);
	}
	
	public void taulaInfo() {
		conexioa c = new conexioa("jdbc:oracle:thin:@//localhost:1521/XEPDB1","E2","E2");
		bdb = c.bezeroKontsulta();
		for(int i=0;i<bdb.getBezeroList().length;i++) {
			modelo.addRow(new Object[] {bdb.getBezeroList()[i].getId(),bdb.getBezeroList()[i].getIzena(),bdb.getBezeroList()[i].getAbizena(),bdb.getBezeroList()[i].getHelbidea(),bdb.getBezeroList()[i].getEmail(),bdb.getBezeroList()[i].getTelefonoa(),null,null});
		}
	}
}
