package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * BulegariaDB klasea
 * @author T1
 * @version 05/05
 * @see Bulegaria
 */
public class BulegariaDB {
	private Bulegaria[] bulegariList;
	
	/**
	 * Eraikitzailea
	 */
	
	public BulegariaDB() {
		this.bulegariList = new Bulegaria[0];
	}
	
	/**
	 * Bulegarien arrayaren lista
	 * @return bulegariList
	 */
		
	public Bulegaria[] getBulegariList() {
		return bulegariList;
	}
	
	/**
	 * bulegariList aldatzeko setterra
	 * @param bulegariList
	 */

	public void setBulegariList(Bulegaria[] bulegariList) {
		this.bulegariList = bulegariList;
	}
	
	/**
	 * arrayari bulegariak gehitzeko
	 * @param b
	 * @see Bulegaria
	 */

	public void addBulegaria(Bulegaria b) {
		this.bulegariList = Arrays.copyOf(this.bulegariList,this.bulegariList.length+1);
		this.bulegariList[this.bulegariList.length-1] = b;
	}	
}
