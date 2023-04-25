package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import DB.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mBezero = new JMenuItem("Bezeroak");
		mBezero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BezeroGUI bezeroa = new BezeroGUI();
			}
		});
		menuBar.add(mBezero);
		
		JMenuItem mBiltegi = new JMenuItem("Biltegiak");
		menuBar.add(mBiltegi);
		
		JMenuItem mBuleari = new JMenuItem("Bulegariak");
		menuBar.add(mBuleari);
		
		JMenuItem mSaltz = new JMenuItem("Saltzaileak");
		menuBar.add(mSaltz);
		
		JMenuItem mEsk = new JMenuItem("Eskariak");
		menuBar.add(mEsk);
		
		JMenuItem mKok = new JMenuItem("Kokalekuak");
		menuBar.add(mKok);
		
		JMenuItem mProd = new JMenuItem("Produktuak");
		menuBar.add(mProd);
		
		JMenuItem mInb = new JMenuItem("Inbentario");
		menuBar.add(mInb);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bItxi = new JButton("Saioa Itxi");
		bItxi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Saioa saioa = new Saioa();
			}
		});
		bItxi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		bItxi.setBounds(452, 300, 142, 34);
		contentPane.add(bItxi);
	}
}