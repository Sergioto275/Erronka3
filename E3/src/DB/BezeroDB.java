package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BezeroDB {
	private Bezeroa[] bezeroList;

	public BezeroDB() {
		this.bezeroList = new Bezeroa[0];
	}	
		
	public Bezeroa[] getBezeroList() {
		return bezeroList;
	}

	public void setBezeroList(Bezeroa[] bezeroList) {
		this.bezeroList = bezeroList;
	}

	public void addBezero(Bezeroa b) {
		this.bezeroList = Arrays.copyOf(this.bezeroList,this.bezeroList.length+1);
		this.bezeroList[this.bezeroList.length-1] = b;
	}		
}
