package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import DB.*;
import conexioa.conexioa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Menua klasea
 * @author T1
 * @version 06/05
 * @see conexioa
 * {@link Saltzailea}
 */
public class Menua extends JFrame {

	private JPanel contentPane;
	private Saltzailea s;

	/**
	 * "InbentarioGUI" diseinua ematen dio
	 */
	public Menua(Saltzailea s) {
		setTitle("Menua");
		this.s = s;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 447);
	    setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mBezero = new JMenuItem("Bezeroak");
		mBezero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mBezero.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * BezeroGUI irekitzen du
			 * {@link BezeroGUI}
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				new BezeroGUI();
			}
		});
		menuBar.add(mBezero);
		
		JMenuItem mBiltegi = new JMenuItem("Biltegiak");
		mBiltegi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mBiltegi.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * BiltegiGUI irekitzen du
			 * {@link BiltegiGUI}
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				new BiltegiGUI();
			}
		});
		menuBar.add(mBiltegi);
		
		JMenuItem mBuleari = new JMenuItem("Bulegariak");
		mBuleari.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mBuleari.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * BulegariGUI irekitzen du
			 * {@link BulegariGUI}
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				new BulegariGUI();
			}
		});
		menuBar.add(mBuleari);
		
		JMenuItem mSaltz = new JMenuItem("Saltzaileak");
		mSaltz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mSaltz.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * SaltzaileGUI irekitzen du
			 * {@link SaltzaileGUI}
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				new SaltzaileGUI();
			}
		});
		menuBar.add(mSaltz);
		
		JMenuItem mEsk = new JMenuItem("Eskariak");
		mEsk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mEsk.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * EskariGUI irekitzen du
			 * {@link EskariGUI}
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				new EskariGUI();
			}
		});
		menuBar.add(mEsk);
		
		JMenuItem mProd = new JMenuItem("Produktuak");
		mProd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mProd.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * ProduktuGUI irekitzen du
			 * {@link ProduktuGUI}
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				new ProduktuGUI();
			}
		});
		menuBar.add(mProd);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon at1 = new ImageIcon("imagenes\\salir1.png");
		ImageIcon at2 = new ImageIcon("imagenes\\salir2.png");
	    at1 = new ImageIcon(at1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
	    at2 = new ImageIcon(at2.getImage().getScaledInstance(90,105,Image.SCALE_DEFAULT));
	    ImageIcon at3 = new ImageIcon(at1.getImage().getScaledInstance(90,105,Image.SCALE_DEFAULT));
		JButton bItxi = new JButton();
		bItxi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bItxi.setHorizontalAlignment(SwingConstants.LEFT);
		bItxi.setFocusTraversalPolicyProvider(true);
		bItxi.setHorizontalTextPosition(SwingConstants.RIGHT);
		bItxi.setVerticalTextPosition(SwingConstants.TOP);
		bItxi.setVerticalAlignment(SwingConstants.TOP);
		bItxi.setContentAreaFilled(false);
		bItxi.setRolloverIcon(at3);
		bItxi.setPressedIcon(at2);
		bItxi.setIcon(at1);
		bItxi.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Menua ixten du eta Saioa irekitzen du
			 * {@link Saioa}
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Saioa();
			}
		});
		bItxi.setBorder(new EmptyBorder(0, 0, 0, 0));
		bItxi.setBounds(555, 271, 91, 98);
		contentPane.add(bItxi);
		
		JButton bDeskontua = new JButton("Deskontuak Imprimatu");
		bDeskontua.addActionListener(e -> deskontuak_imprimatu());
		bDeskontua.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		bDeskontua.setBounds(121, 66, 397, 75);
		contentPane.add(bDeskontua);
		
		JButton bPrezioEguneraketa = new JButton("Prezio Eguneraketa");
		bPrezioEguneraketa.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		bPrezioEguneraketa.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * produktuak_Eguneratu irekitzen du
			 * {@link produktuak_Eguneratu}
			 * @param e
			 */
			public void mouseClicked(MouseEvent e) {
				new produktuak_Eguneratu();
			}
		});
		bPrezioEguneraketa.setBounds(121, 180, 400, 87);
		contentPane.add(bPrezioEguneraketa);
		setVisible(true);
	}
	
	/**
	 * Bezeroentzako deskontuak imprimatzen ditu
	 * @see conexioa#deskontuak() 
	 */
	public void deskontuak_imprimatu() {
		int kont =0;
		try {
			conexioa c = new conexioa("jdbc:oracle:thin:@//192.168.101.11:1521/XEPDB1","ERRONKA2","ERRONKA2");
			String[] deskontuak = c.deskontuak();
			for(int i = 0;i < deskontuak.length;i++) {
				FileWriter f = null;
				PrintWriter pw = null;
				String[] aux = deskontuak[i].split("_");
				String aux2 = "Deskontuak//Deskontu_Bezero_"+aux[0]+".txt";
				try {
					f = new FileWriter(aux2);
					pw = new PrintWriter(f);
					String aux3 = String.format("%-10s", aux[1]);
					aux3 = aux3+String.format("%-15s", aux[2]);
					for(int z=0;z<3;z++) {
						for(int j=0;j<aux3.length()+4;j++) {
							if(z==1) {
								pw.print("*  "+aux3+"*");
								break;
							}else {
								pw.print("*");
							}
						}
						pw.println();
					}
					pw.close();
				}catch(Exception ex) {
					System.out.println("ERROREA");
				}
				kont = i;
			}
			String mensaje = kont+" deskontu imprimatu dira";
            JOptionPane.showMessageDialog(null, mensaje,"IMPRIMAKETA",JOptionPane.INFORMATION_MESSAGE);        
		}catch(Exception ex) {
			System.out.println("NO FURRULA ");
		}
	}
}