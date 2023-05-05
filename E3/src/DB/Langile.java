package DB;

/**
 * Langile klasea
 * @author ikasle
 * @version 05/05
 */

public class Langile {
	/**
	 * atributuak
	 */
	
	protected String izena;
	protected String abizena;
	protected int id;
	protected String email;
	protected String kontratatze_data;
	protected String telefonoa;
	protected int idNagusia;
	protected double soldata;
	
	/**
	 * Defektuzko sortzailea
	 */
	
	public Langile() {}
	
	/**
	 * Sortzailea parametroekin
	 * @param izena
	 * @param abizena
	 * @param id
	 * @param email
	 * @param kontratatze_data
	 * @param telefonoa
	 * @param idNagusia
	 * @param soldata
	 */

	public Langile(String izena, String abizena, int id, String email, String kontratatze_data, String telefonoa,
			int idNagusia, double soldata) {
		super();
		this.izena = izena;
		this.abizena = abizena;
		this.id = id;
		this.email = email;
		this.kontratatze_data = kontratatze_data;
		this.telefonoa = telefonoa;
		this.idNagusia = idNagusia;
		this.soldata = soldata;
	}

	/**
	 * izenaren getterra
	 * @return izena
	 */

	public String getIzena() {
		return izena;
	}
	
	/**
	 * izena aldatzeko setterra
	 * @param izena
	 */

	public void setIzena(String izena) {
		this.izena = izena;
	}
	
	/**
	 * abizenaren getterra
	 * @return abizena
	 */

	public String getAbizena() {
		return abizena;
	}
	
	/**
	 * abizena aldatzeko setterra
	 * @param abizena
	 */

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}
	
	/**
	 * id getterra
	 * @return id
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
	 * emailaren getterra
	 * @return email
	 */

	public String getEmail() {
		return email;
	}
	
	/**
	 * email aldazeko setterra
	 * @param email
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * kontratatze dataren getterra
	 * @return kontratatze_data
	 */

	public String getKontratatze_data() {
		return kontratatze_data;
	}
	
	/**
	 * kontratatze data aldatzeko setterra
	 * @param kontratatze_data
	 */

	public void setKontratatze_data(String kontratatze_data) {
		this.kontratatze_data = kontratatze_data;
	}
	
	/**
	 * telefonoaren getterra
	 * @return
	 */

	public String getTelefonoa() {
		return telefonoa;
	}
	
	/**
	 * telefonoa aldatzeko setterra
	 * @param telefonoa
	 */

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}
	
	/**
	 * id nagusiaren getterra
	 * @return idNagusia
	 */

	public int getIdNagusia() {
		return idNagusia;
	}
	
	/**
	 * id nagusia aldatzeko setterra
	 * @param idNagusia
	 */

	public void setIdNagusia(int idNagusia) {
		this.idNagusia = idNagusia;
	}
	
	/**
	 * soldataren getterra
	 * @return soldata
	 */

	public double getSoldata() {
		return soldata;
	}
	
	/**
	 * soldata aldatzeko setterra
	 * @param soldata
	 */

	public void setSoldata(double soldata) {
		this.soldata = soldata;
	}
	
	/**
	 * toString funtzioa datuak bistaratzeko
	 */

	@Override
	public String toString() {
		return "Langile [izena=" + izena + ", abizena=" + abizena + ", id=" + id + ", email=" + email
				+ ", kontratatze_data=" + kontratatze_data + ", telefonoa=" + telefonoa + ", idNagusia=" + idNagusia
				+ "]";
	}
}
