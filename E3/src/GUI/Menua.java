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

	/**
	 * Create the frame.
	 */
	public Menua(Saltzailea s) {
		this.s = s;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 447);
		setVisible(true);
	    setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mBezero = new JMenuItem("Bezeroak");
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bItxi = new JButton("Saioa Itxi");
		bItxi.setBounds(452, 300, 142, 34);
		contentPane.add(bItxi);
	}
}