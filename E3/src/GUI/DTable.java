package GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class DTable extends JTable{
	public DTable() {
	}
	private String[] d = new String[0];
	public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
        Component comp = super.prepareRenderer(renderer, row, col);
        Object value = getModel().getValueAt(row, col);
        JButton gorde = new JButton("Gorde");
		gorde.setBackground(Color.green);
		gorde.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		JButton ezabatu = new JButton("Ezabatu");
		ezabatu.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black,2,true));
		ezabatu.setBackground(Color.red);
		ezabatu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		JButton info = new JButton();
		ImageIcon infor = new ImageIcon("imagenes\\info.png");
	    infor = new ImageIcon(infor.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));
	    info.setIcon(infor);
		info.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black,2,true));
		info.setBackground(Color.gray);
		info.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        super.setDefaultRenderer(Object.class, new imgTabla());
        if (super.getColumnName(col).equals(" ")) { 
        	super.setValueAt(gorde,row,col);
        } else {
        	if(super.getColumnName(col).equals("   ")) {
            	super.setValueAt(ezabatu,row,col);
        	}else{
        		if(super.getColumnName(col).equals("  ")) {
                	super.setValueAt(info,row,col);
            	}
        	}
        }
        return comp;
    }
}
