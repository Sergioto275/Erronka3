package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ProduktuDB {
	private Produktu [] produktuList;
	
	public Produktu[] getProduktuList() {
		return produktuList;
	}

	public void setProduktuList(Produktu[] produktuList) {
		this.produktuList = produktuList;
	}

	public ProduktuDB() {
		this.produktuList = new Produktu[0];
	}
	
	public void addProduktua(Produktu p) {
		this.produktuList = Arrays.copyOf(this.produktuList, this.produktuList.length+1);
		this.produktuList[this.produktuList.length-1] = p;			
	}
}
