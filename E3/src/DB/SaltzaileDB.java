package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Saltzaileen arrayaren klasea
 * @author T1
 * @version 05/05
 * @see Saltzailea
 */

public class SaltzaileDB {
	private Saltzailea[] saltzaileList;
	
	/**
	 * eraikitzailea 0tik abiarazita
	 */
	public SaltzaileDB() {
		this.saltzaileList = new Saltzailea[0];
	}
	
	/**
	 * saltzaileak arrayari gehitzeko funtzioa
	 * @param s
	 */
	
	public void addSaltzailea(Saltzailea s) {
		this.saltzaileList = Arrays.copyOf(this.saltzaileList, this.saltzaileList.length+1);
		this.saltzaileList[this.saltzaileList.length-1] = s;
	}
	
	/**
	 * saltzaileen arrayaren lista bueltatzen duen getterra
	 * @return saltzaileList
	 */
	
	public Saltzailea[] getSaltzaileList() {
		return saltzaileList;
	}
	
	/**
	 * saltzaile lista aldatzeko setterra
	 * @param saltzaileList
	 * @see Saltzailea
	 */

	public void setSaltzaileList(Saltzailea[] saltzaileList) {
		this.saltzaileList = saltzaileList;
	}
}
