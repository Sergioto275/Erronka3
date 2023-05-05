package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Produktuen arraya klasea
 * @author ikasle
 * @version 05/05
 */

public class ProduktuDB {
	private Produktu [] produktuList;
	
	/**
	 * produktuen lista bueltatzeko getterra
	 * @return produktuList
	 */
	
	public Produktu[] getProduktuList() {
		return produktuList;
	}
	
	/**
	 * produktuen lista aldatzedko setterra
	 * @param produktuList
	 */

	public void setProduktuList(Produktu[] produktuList) {
		this.produktuList = produktuList;
	}
	
	/**
	 * produktuen arraya abiarazteko funtzioa
	 */

	public ProduktuDB() {
		this.produktuList = new Produktu[0];
	}
	
	/**
	 * arrayari produktuak gehitzeko
	 * @param p
	 */
	
	public void addProduktua(Produktu p) {
		this.produktuList = Arrays.copyOf(this.produktuList, this.produktuList.length+1);
		this.produktuList[this.produktuList.length-1] = p;			
	}
}
