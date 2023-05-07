package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * EskariDB klasea
 * @author T1
 * @version 05/05
 * @see Eskari
 */

public class EskariDB {
	private Eskaria[] eskariList;
	
	/**
	 * eraikitzailea
	 */
	
	public EskariDB() {
		this.eskariList = new Eskaria[0];
	}
	
	/**
	 * eskarien lista arrayaren getterra
	 * @return eskariList
	 */
		
	public Eskaria[] getEskariList() {
		return eskariList;
	}
	
	/**
	 * eskari lista aldatzeko setterra
	 * @param eskariList
	 */

	public void setEskariList(Eskaria[] eskariList) {
		this.eskariList = eskariList;
	}
	
	/**
	 * eskariak gehitzeko arrayari
	 * @param eskaria
	 * @see Eskari
	 */

	public void addEskaria (Eskaria e) {
		this.eskariList = Arrays.copyOf(this.eskariList, this.eskariList.length+1);
		this.eskariList[this.eskariList.length-1] = e;
	}	
}
