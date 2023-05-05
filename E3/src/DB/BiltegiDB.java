package DB;

import java.io.*;
import java.util.*;

/**
 * BiltegiDB klasea
 * @author ikasle
 * @version 05/05
 */

public class BiltegiDB {
	private Biltegi [] biltegiList;
	
	/**
	 * Eraikitzailea
	 */
	
	public BiltegiDB() {
		this.biltegiList = new Biltegi[0];
	}
	
	/**
	 * Biltegi arrayaren lista
	 * @return biltegiList
	 */
	
	public Biltegi[] getBiltegiList() {
		return biltegiList;
	}
	
	/**
	 * Biltegi lista aldatzeko setterra
	 * @param biltegiList
	 */

	public void setBiltegiList(Biltegi[] biltegiList) {
		this.biltegiList = biltegiList;
	}
	
	/**
	 * Biltegiak arrayari gehitzeko funtzioa
	 * @param b
	 */

	public void addBiltegia(Biltegi b) {
		this.biltegiList =  Arrays.copyOf(this.biltegiList, this.biltegiList.length+1);
		this.biltegiList[this.biltegiList.length-1] = b;
	}
}
