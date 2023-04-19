package DB;

import java.io.*;
import java.util.*;

public class BiltegiDB {
	private Biltegi [] biltegiList;
	
	public BiltegiDB() {
		this.biltegiList = new Biltegi[0];
	}
	
	public Biltegi[] getBiltegiList() {
		return biltegiList;
	}

	public void setBiltegiList(Biltegi[] biltegiList) {
		this.biltegiList = biltegiList;
	}

	public void addBiltegia(Biltegi b) {
		this.biltegiList =  Arrays.copyOf(this.biltegiList, this.biltegiList.length+1);
		this.biltegiList[this.biltegiList.length-1] = b;
	}
}
