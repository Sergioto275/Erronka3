package DB;

/**
 * Saltzailea klasea (langiletik abiarazita)
 * @author ikasle
 * @version 05/05
 */
public class Saltzailea extends Langile{
	/**
	 * atributuak
	 */
	private String erabiltzaile;
	private String pasahitza;
	
	/**
	 * eraikitzailea defektuz
	 */
	public Saltzailea() {}
	
	/**
	 * Eraikitzailea parametroekin
	 * @param izena
	 * @param abizena
	 * @param id
	 * @param email
	 * @param kontratatze_data
	 * @param telefonoa
	 * @param idNagusia
	 * @param soldata
	 * @param erabiltzaile
	 * @param pasahitza
	 */
	
	public Saltzailea(String izena, String abizena, int id, String email, String kontratatze_data, String telefonoa,
			int idNagusia, double soldata, String erabiltzaile, String pasahitza) {
		super(izena, abizena, id, email, kontratatze_data, telefonoa, idNagusia, soldata);
		this.erabiltzaile = erabiltzaile;
		this.pasahitza = pasahitza;
	}
	
	/**
	 * erabiltzailearen getterra
	 * @return erabiltzaile
	 */
	
	public String getErabiltzaile() {
		return this.erabiltzaile;
	}
	
	/**
	 * erabiltzailea aldatzeko setterra
	 * @param erabiltzaile
	 */
	
	public void setErabiltzaile(String erabiltzaile) {
		this.erabiltzaile = erabiltzaile;
	}
	
	/**
	 * pasahitzaren getterra
	 * @return pasahitza
	 */
	
	public String getPasahitza() {
		return this.pasahitza;
	}
	
	/**
	 * pasahitza aldatzeko setterra
	 * @param pasahitza
	 */
	
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	
	/**
	 * toString funtzioa datuak bistaratzeko
	 */
	
	@Override	
	public String toString() {
		return "Saltzailea [erabiltzaile=" + this.erabiltzaile + ", pasahitza=" + this.pasahitza + ", izena=" + this.izena
				+ ", abizena=" + this.abizena + ", NAN=" + this.id +", email= "+this.email+", Kontratatze_data=" + this.kontratatze_data + ", telefonoa="
				+ this.telefonoa + ", IdNagusia=" + this.idNagusia + "]";
	}	
}
