package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.Saltzailea;

import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JProgressBar;

/**
 * welcome klasea
 * @author T1
 * @version 08/05
 */
public class welcome extends JDialog {
	
	private int auxiliar = 0;
	private boolean realizado = false;
	hilo ejecutar = new hilo();
	private final JPanel contentPanel = new JPanel();
	private JLabel text;
	private JProgressBar barra;
	private JLabel logo;
	private int s;

	/**
	 * Klase honekin aplikazioari karga pantalla bet eratzen diogu
	 * @param saltz 
	 */
	public welcome(int saltz) {
		setUndecorated(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		setAlwaysOnTop(true);
		setBounds(100, 100, 480, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		text = new JLabel("");
		text.setForeground(new Color(255, 255, 255));
		text.setBounds(33, 206, 175, 23);
		contentPanel.add(text);
		
		barra = new JProgressBar();
		barra.setBounds(23, 227, 430, 36);
		contentPanel.add(barra);
		ImageIcon log = new ImageIcon("imagenes\\logo.jpg");
		ImageIcon log1 = new ImageIcon(log.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT));
		logo = new JLabel();
		logo.setIcon(log1);
		logo.setBounds(134, 47, 200, 150);
		contentPanel.add(logo);
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
		setVisible(true);
		this.s = saltz;
	}
	
	/**
	 * funtzio honen bidez kargatzen hasten da
	 * @param evt
	 */
	private void formWindowActivated(java.awt.event.WindowEvent evt) {
        if(realizado == false){
	        realizado = true;
	        barra.setMaximum(99);
	        barra.setMinimum(0);
	        barra.setStringPainted(true);
	        ejecutar.start();
        }
    }
	
	/**
	 * hilo klasearekin karga progresua kudeatzen dugu
	 * @author T1
	 * @version 08/05
	 */
	private class hilo extends Thread{
		public void run() {
			int auxiliar=0;
			try {
				while(true) {
					auxiliar++;
					barra.setValue(auxiliar);
					repaint();
					switch(auxiliar) {
					case 1:
						text.setText("Bezeroak kargatzen ...");
						break;
					case 15:
						text.setText("Biltegiak kargatzen ...");
						break;
					case 30:
						text.setText("Bulegariak kargatzen ...");
						break;
					case 45:
						text.setText("Saltzaileak kargatzen ...");
						break;
					case 60:
						text.setText("Eskariak kargatzen ...");
						break;
					case 75:
						text.setText("Produktuak kargatzen ...");
						break;
					case 90:
						text.setText("Saioa Irekitzen ...");
						break;
					case 100:
						dispose();
						new Menua(s);
						break;
					}
					Thread.sleep(100);
				}
			}catch(InterruptedException ex) {
				
			}
		}
	}
}
