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
		
		ImageIcon at1 = new ImageIcon("imagenes\\salir1.png");
		ImageIcon at2 = new ImageIcon("imagenes\\salir2.png");
	    at1 = new ImageIcon(at1.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
	    at2 = new ImageIcon(at2.getImage().getScaledInstance(90,105,Image.SCALE_DEFAULT));
	    ImageIcon at3 = new ImageIcon(at1.getImage().getScaledInstance(90,105,Image.SCALE_DEFAULT));
		JButton bItxi = new JButton();
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
		bItxi.setBounds(496, 242, 150, 127);
		contentPane.add(bItxi);
	}
}