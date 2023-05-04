package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import DB.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menua extends JFrame {

	private JPanel contentPane;
	private Saltzailea s;
	
	public static void main(String[] args) {
		Menua m = new Menua(null);
	}

	/**
	 * Create the frame.
	 */
	public Menua(Saltzailea s) {
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
			public void mouseClicked(MouseEvent e) {
				BezeroGUI bezeroa = new BezeroGUI();
			}
		});
		menuBar.add(mBezero);
		
		JMenuItem mBiltegi = new JMenuItem("Biltegiak");
		mBiltegi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mBiltegi);
		
		JMenuItem mBuleari = new JMenuItem("Bulegariak");
		mBuleari.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mBuleari);
		
		JMenuItem mSaltz = new JMenuItem("Saltzaileak");
		mSaltz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mSaltz);
		
		JMenuItem mEsk = new JMenuItem("Eskariak");
		mEsk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mEsk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EskariGUI bezeroa = new EskariGUI();
			}
		});
		menuBar.add(mEsk);
		
		JMenuItem mProd = new JMenuItem("Produktuak");
		mProd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mProd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProduktuGUI bezeroa = new ProduktuGUI();
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
			public void mouseClicked(MouseEvent e) {
				dispose();
				Saioa saioa = new Saioa();
			}
		});
		bItxi.setBorder(new EmptyBorder(0, 0, 0, 0));
		bItxi.setBounds(531, 245, 91, 98);
		contentPane.add(bItxi);
		
		JButton bDeskontua = new JButton("Deskontuak Imprimatu");
		bDeskontua.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 25));
		bDeskontua.setBounds(121, 66, 397, 75);
		contentPane.add(bDeskontua);
		
		JButton bPrezioEguneraketa = new JButton("Prezio Eguneraketa");
		bPrezioEguneraketa.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 25));
		bPrezioEguneraketa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bPrezioEguneraketa.setBounds(121, 180, 400, 87);
		contentPane.add(bPrezioEguneraketa);
		setVisible(true);
	}
}