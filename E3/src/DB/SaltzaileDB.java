package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SaltzaileDB {
	private Saltzailea[] saltzaileList;
	
	public SaltzaileDB() {
		this.saltzaileList = new Saltzailea[0];
	}
	
	public void addSaltzailea(Saltzailea s) {
		this.saltzaileList = Arrays.copyOf(this.saltzaileList, this.saltzaileList.length+1);
		this.saltzaileList[this.saltzaileList.length-1] = s;
	}
	
	public Saltzailea[] getSaltzaileList() {
		return saltzaileList;
	}

	public void setSaltzaileList(Saltzailea[] saltzaileList) {
		this.saltzaileList = saltzaileList;
	}
}
