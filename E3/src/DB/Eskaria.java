package DB;

import java.util.Arrays;

public class Eskaria {
	private int id;
	private int bezero_izena;
	private int saltzaile_izena;
	private String egoera;
	private String data;
	private Eskari_Info[] info;

	public Eskaria() {}

	public Eskaria(int id, int bezero_izena, int saltzaile_izena, String egoera, String data,
			Eskari_Info[] info) {
		super();
		this.id = id;
		this.bezero_izena = bezero_izena;
		this.saltzaile_izena = saltzaile_izena;
		this.egoera = egoera;
		this.data = data;
		this.info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBezero_izena() {
		return bezero_izena;
	}

	public void setBezero_izena(int bezero_izena) {
		this.bezero_izena = bezero_izena;
	}

	public int getSaltzaile_izena() {
		return saltzaile_izena;
	}

	public void setSaltzaile_izena(int saltzaile_izena) {
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

	public Eskari_Info[] getProduktu_kop() {
		return this.info;
	}

	public void setProduktu_kop(Eskari_Info[] produktu_kop) {
		this.info = produktu_kop;
	}

	@Override
	public String toString() {
		return "Eskaria [id=" + id + ", bezero_izena=" + bezero_izena + ", saltzaile_izena=" + saltzaile_izena
				+ ", egoera=" + egoera + ", data=" + data + ", Produktu_kop=" +this.info.toString() + "]";
	}	
	
}
