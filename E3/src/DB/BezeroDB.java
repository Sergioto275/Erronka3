package DB;

/**
 * importa
 */

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * BezeroDB klasea
 * @author ikasle
 * @version 05/05
 */

public class BezeroDB {
	private Bezeroa[] bezeroList;
	
	/**
	 * Eraikitzailea
	 */

	public BezeroDB() {
		this.bezeroList = new Bezeroa[0];
	}	
	
	/**
	 * Bezeroen lista bueltatzeko funtzioa
	 * @return
	 */
		
	public Bezeroa[] getBezeroList() {
		return bezeroList;
	}
	
	/**
	 * Bezero lista aldatzeko funtzioa
	 * @param bezeroList
	 */

	public void setBezeroList(Bezeroa[] bezeroList) {
		this.bezeroList = bezeroList;
	}
	
	/**
	 * Bezeroak gehitzeko arrayari funtzioa
	 * @param b
	 */

	public void addBezero(Bezeroa b) {
		this.bezeroList = Arrays.copyOf(this.bezeroList,this.bezeroList.length+1);
		this.bezeroList[this.bezeroList.length-1] = b;
	}		
}
