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
	private JTextField tHelbidea;
	private JTextField tHerrialde;
	private JTextField tKontinentea;
	private JTextField tProbintzia;
	private JTextField tUdalerria;
	private JTextField tPostakodea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			biltegiTxertatuGUI dialog = new biltegiTxertatuGUI(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public biltegiTxertatuGUI(DefaultTableModel modelo) {
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
		lblIzena.setBounds(184, 91, 54, 39);
		contentPanel.add(lblIzena);
		
		JLabel lblHerrialde = new JLabel("Herrialde:");
		lblHerrialde.setBounds(78, 167, 54, 33);
		contentPanel.add(lblHerrialde);
		
		JLabel lblKontinentea = new JLabel("Kontinentea:");
		lblKontinentea.setBounds(503, 97, 68, 33);
		contentPanel.add(lblKontinentea);
		
		JLabel lblHelbidea = new JLabel("Helbidea:");
		lblHelbidea.setBounds(330, 97, 54, 33);
		contentPanel.add(lblHelbidea);
		
		JLabel lblProbintzia = new JLabel("Probintzia:");
		lblProbintzia.setBounds(346, 167, 68, 33);
		contentPanel.add(lblProbintzia);
		
		JLabel lblUdalerria = new JLabel("Udalerria:");
		lblUdalerria.setBounds(78, 235, 68, 33);
		contentPanel.add(lblUdalerria);
		
		JLabel lblPostakodea = new JLabel("Postakodea:");
		lblPostakodea.setBounds(364, 235, 68, 33);
		contentPanel.add(lblPostakodea);
		
		tId = new JTextField();
		tId.setBounds(62, 103, 86, 20);
		contentPanel.add(tId);
		tId.setColumns(10);
		
		tIzena = new JTextField();
		tIzena.setColumns(10);
		tIzena.setBounds(221, 103, 86, 20);
		contentPanel.add(tIzena);
		
		tHelbidea = new JTextField();
		tHelbidea.setColumns(10);
		tHelbidea.setBounds(379, 103, 114, 20);
		contentPanel.add(tHelbidea);
		
		tHerrialde = new JTextField();
		tHerrialde.setColumns(10);
		tHerrialde.setBounds(152, 173, 155, 20);
		contentPanel.add(tHerrialde);
		
		tKontinentea = new JTextField();
		tKontinentea.setColumns(10);
		tKontinentea.setBounds(576, 103, 105, 20);
		contentPanel.add(tKontinentea);
		
		tProbintzia = new JTextField();
		tProbintzia.setColumns(10);
		tProbintzia.setBounds(407, 173, 176, 20);
		contentPanel.add(tProbintzia);
		
		tUdalerria = new JTextField();
		tUdalerria.setBounds(152, 241, 155, 20);
		contentPanel.add(tUdalerria);
		tUdalerria.setColumns(10);
		
		tPostakodea = new JTextField();
		tPostakodea.setColumns(10);
		tPostakodea.setBounds(442, 239, 155, 20);
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
					c.bezeroInsert(Integer.parseInt(tId.getText()),tIzena.getText(),tHelbidea.getText(),tKontinentea.getText(),tHerrialde.getText(),tProbintzia.getText());
					modelo.addRow(new Object[] {tId.getText(),tIzena.getText(),tHelbidea.getText(),tHerrialde.getText(),tKontinentea.getText(),tProbintzia.getText(),null,null});
		            JOptionPane.showMessageDialog(null,"Hilara bat txertatu da","TXERTAKETA",JOptionPane.INFORMATION_MESSAGE);
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
		
		setVisible(true);
	}
}
