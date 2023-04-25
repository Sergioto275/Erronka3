package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.TableCellRenderer;

public class DTable extends JTable{
	public DTable() {
	}
	private String[] d = new String[0];
	public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
        Component comp = super.prepareRenderer(renderer, row, col);
        Object value = getModel().getValueAt(row, col);
        JLabel gorde = new JLabel("Gorde");
		gorde.setBackground(Color.green);
		gorde.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		JLabel ezabatu = new JLabel("Ezabatu");
		ezabatu.setBorder(new BevelBorder(3));
		ezabatu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		ezabatu.setBackground(Color.red);
        super.setDefaultRenderer(Object.class, new imgTabla());
        if (super.getColumnName(col).equals("Gorde")) { 
        	super.setValueAt(gorde,row,col);
        	comp.setBackground(Color.green);
        } else {
        	if(super.getColumnName(col).equals("Ezabatu")) {
            	super.setValueAt(ezabatu,row,col);
            	comp.setBackground(Color.red);
        	}
        }
        return comp;
    }
}
