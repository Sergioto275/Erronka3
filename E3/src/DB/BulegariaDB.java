package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BulegariaDB {
	private Bulegaria[] bulegariList;
	
	public BulegariaDB() {
		this.bulegariList = new Bulegaria[0];
	}
		
	public Bulegaria[] getBulegariList() {
		return bulegariList;
	}

	public void setBulegariList(Bulegaria[] bulegariList) {
		this.bulegariList = bulegariList;
	}

	public void addBulegaria(Bulegaria b) {
		this.bulegariList = Arrays.copyOf(this.bulegariList,this.bulegariList.length+1);
		this.bulegariList[this.bulegariList.length-1] = b;
	}	
}
