package DB;

import java.util.Arrays;

public class Eskaria {
	private int id;
	private String bezero_izena;
	private String saltzaile_izena;
	private String egoera;
	private String data;
	private String [][] produktu_kop;

	public Eskaria() {}

	public Eskaria(int id, String bezero_izena, String saltzaile_izena, String egoera, String data,
			String[][] produktu_kop) {
		super();
		this.id = id;
		this.bezero_izena = bezero_izena;
		this.saltzaile_izena = saltzaile_izena;
		this.egoera = egoera;
		this.data = data;
		this.produktu_kop = produktu_kop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBezero_izena() {
		return bezero_izena;
	}

	public void setBezero_izena(String bezero_izena) {
		this.bezero_izena = bezero_izena;
	}

	public String getSaltzaile_izena() {
		return saltzaile_izena;
	}

	public void setSaltzaile_izena(String saltzaile_izena) {
		this.saltzaile_izena = saltzaile_izena;
	}

	public String getEgoera() {
		return egoera;
	}

	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String[][] getProduktu_kop() {
		return produktu_kop;
	}

	public void setProduktu_kop(String[][] produktu_kop) {
		this.produktu_kop = produktu_kop;
	}

	@Override
	public String toString() {
		return "Eskaria [id=" + id + ", bezero_izena=" + bezero_izena + ", saltzaile_izena=" + saltzaile_izena
				+ ", egoera=" + egoera + ", data=" + data + ", Produktu_kop=" + Arrays.deepToString(produktu_kop) + "]";
	}	
	
}
