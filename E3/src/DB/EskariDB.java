package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class EskariDB {
	private Eskaria[] eskariList;
	
	public EskariDB() {
		this.eskariList = new Eskaria[0];
	}
		
	public Eskaria[] getEskariList() {
		return eskariList;
	}

	public void setEskariList(Eskaria[] eskariList) {
		this.eskariList = eskariList;
	}

	public void addEskaria (Eskaria e) {
		this.eskariList = Arrays.copyOf(this.eskariList, this.eskariList.length+1);
		this.eskariList[this.eskariList.length-1] = e;
	}	
}
