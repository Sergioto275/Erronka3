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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setBounds(100, 100, 859, 452);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		modelo = new DefaultTableModel(null,new String[] {"ID", "IZENA", "ABIZENA", "HELBIDEA", "EMAIL", "TELEFONOA", "Gorde", "Ezabatu"}) {
				boolean[] columnEditables = new boolean[] {
					true, true, true, true, true, true, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}};
		taulaInfo();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 89, 668, 247);
		contentPanel.add(scrollPane);
		table = new DTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getColumnName(table.getSelectedColumn()).equals("Gorde")) {
					System.out.println("Gorde");
				}else {
					if(table.getColumnName(table.getSelectedColumn()).equals("Ezabatu")) {
						System.out.println("Ezabatu");
					}
				}
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(modelo);
		JLabel lBezero = new JLabel("Bezeroak");
		lBezero.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lBezero.setBounds(340, 11, 132, 48);
		contentPanel.add(lBezero);
		
		JButton bAtzera = new JButton("Atzera");
		bAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		bAtzera.setBounds(679, 365, 89, 23);
		contentPanel.add(bAtzera);
		
		JButton bTxertatu = new JButton("Txertatu");
		bTxertatu.setBounds(71, 365, 89, 23);
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
