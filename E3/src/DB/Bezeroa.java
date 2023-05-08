package DB;

import java.util.Arrays;

/**
 * Bezeroa klasea
 * @author T1
 * @version 05/05
 */

public class Bezeroa {
	private String izena;
	private String abizena;
	private String helbidea;
	private int id;
	private String email;
	private String telefonoa;
	
	/**
	 * Defektuzko eraikitzailea
	 */
	
	public Bezeroa() {}
	
	/**
	 * Eraikitzailea parametroekin
	 * @param izena
	 * @param abizena
	 * @param helbidea
	 * @param id
	 * @param email
	 * @param telefonoa
	 */
	
	public Bezeroa(String izena, String abizena, String helbidea, int id, String email, String telefonoa) {
		this.izena = izena;
		this.abizena = abizena;
		this.helbidea = helbidea;
		this.id = id;
		this.email = email;
		this.telefonoa = telefonoa;
	}
	
	/**
	 * Izenaren getterra
	 * @return izena
	 */

	public String getIzena() {
		return this.izena;
	}
	
	/**
	 * Izena aldatzeko setterra
	 * @param izena
	 */

	public void setIzena(String izena) {
		this.izena = izena;
	}
	
	/**
	 * Abizenaren getterra
	 * @return abizena
	 */

	public String getAbizena() {
		return this.abizena;
	}
	
	/**
	 * Abizena aldatzeko setterra
	 * @param abizena
	 */

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	
	/**
	 * Helbidearen getterra
	 * @return helbidea
	 */

	public String getHelbidea() {
		return this.helbidea;
	}
	
	/**
	 * Helbidea aldatzeko setterra
	 * @param helbidea
	 */

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}
	
	/**
	 * Idaren getterra
	 * @return id
	 */

	public int getId() {
		return this.id;
	}
	
	/**
	 * Idea aldatzeko setterra
	 * @param nan
	 */

	public void setId(int nan) {
		this.id = nan;
	}
	
	/**
	 * Emailaren getterra
	 * @return email
	 */

	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Email aldatzeko setterra
	 * @param email
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Telefonoaren getterra
	 * @return telefonoa
	 */

	public String getTelefonoa() {
		return this.telefonoa;
	}
	
	/**
	 * Telefonoa aldatzeko setterra
	 * @param telefonoa
	 */

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}
	
	/**
	 * toString funtzioa datuak bistaratzeko
	 */

	@Override
	public String toString() {
		return "Bezeroa [izena=" + this.izena + ", abizena=" + this.abizena + ", helbidea=" + this.helbidea + ", Id=" + this.id
				+ ", email=" + this.email + ", telefonoa=" + this.telefonoa + "]";
	}
	
	
}
