package DB;

import java.util.Arrays;

/**
 * Eskaria klasea
 * @author T1
 * @version 05/05
 * @see Eskari_info
 */
public class Eskaria {
	private int id;
	private int bezero_izena;
	private int saltzaile_izena;
	private String egoera;
	private String data;
	private Eskari_Info[] info;
	
	/**
	 * Defektuzko sortzailea
	 */

	public Eskaria() {}
	
	/**
	 * Sortzailea parametroekin
	 * @param id
	 * @param bezero_izena
	 * @param saltzaile_izena
	 * @param egoera
	 * @param data
	 * @param info
	 * @see Eskari_info
	 */

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
	
	/**
	 * id getterra
	 * @return
	 */

	public int getId() {
		return id;
	}
	
	/**
	 * id aldatzeko setterra
	 * @param id
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * bezeroaren izenaren getterra
	 * @return bezero_izena
	 */

	public int getBezero_izena() {
		return bezero_izena;
	}
	
	/**
	 * bezeroaren izena aldatzeko setterra
	 * @param bezero_izena
	 */

	public void setBezero_izena(int bezero_izena) {
		this.bezero_izena = bezero_izena;
	}
	
	/**
	 * saltzaile izenaren getterra
	 * @return saltzaile_izena
	 */

	public int getSaltzaile_izena() {
		return saltzaile_izena;
	}
	
	/**
	 * saltzaile izena aldatzeko setterra
	 * @param saltzaile_izena
	 */

	public void setSaltzaile_izena(int saltzaile_izena) {
		this.saltzaile_izena = saltzaile_izena;
	}
	
	/**
	 * egoeraren getterra
	 * @return egoera
	 */

	public String getEgoera() {
		return egoera;
	}
	
	/**
	 * egoera aldatzeko setterra
	 * @param egoera
	 */

	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}
	
	/**
	 * dataren getterra
	 * @return data
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * data aldatzeko setterra
	 * @param data
	 */

	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * eskari_info arrayaren getterra
	 * @return info
	 */

	public Eskari_Info[] getProduktu_kop() {
		return this.info;
	}
	
	/**
	 * produktuen kategoria aldatzeko setterra
	 * @param produktu_kop
	 */

	public void setProduktu_kop(Eskari_Info[] produktu_kop) {
		this.info = produktu_kop;
	}
	
	/**
	 * toString funtzioa datuak bistaratzeko
	 */

	@Override
	public String toString() {
		return "Eskaria [id=" + id + ", bezero_izena=" + bezero_izena + ", saltzaile_izena=" + saltzaile_izena
				+ ", egoera=" + egoera + ", data=" + data + ", Produktu_kop=" +this.info.toString() + "]";
	}	
}
