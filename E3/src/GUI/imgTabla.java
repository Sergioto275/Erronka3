package GUI;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * imgTabla klasea
 * @author T1
 * @version 06/05
 */
public class imgTabla extends DefaultTableCellRenderer{
	@Override
	/**
	 * JTable-an JButon-ak sartzen saiatzen bada comprobatzen du eta JButon-a bueltatzen du
	 * @return Component
	 */
	public Component getTableCellRendererComponent(JTable jtable,Object o, boolean bln,boolean bln1,int i,int i1){
		if(o instanceof JButton) {
			JButton lbl = (JButton)o;
			return lbl;
		}
		return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
	}
	
}
