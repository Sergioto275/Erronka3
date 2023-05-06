package DB;

/**
 * Biltegi klasea
 * @author ikasle
 * @version 05/05
 */

public class Biltegi {
	private int id;
	private String id_herrialde;
	private int id_kontinente;
	private int id_kokaleku;
	private String izena;
	private String helbidea;
	private String kontinentea;
	private String herrialde;
	private String probintzia;
	private String udalerria;
	private String postakodea;

	/**
	 * Defektuzko eraikitzailea
	 */
	
	public Biltegi () {}
	
	/**
	 * Eraikitzailea parametroekin
	 * @param id
	 * @param izena
	 * @param helbidea
	 * @param kontinentea
	 * @param herrialde
	 * @param probintzia
	 * @param udalerria
	 * @param postakodea
	 * @param id_herrialde
	 * @param id_kontinente
	 * @param id_kokaleku
	 */

	public Biltegi(int id, String izena, String helbidea, String kontinentea, String herrialde, String probintzia,
			String udalerria, String postakodea, String id_herrialde, int id_kontinente, int id_kokaleku) {
		super();
		this.id = id;
		this.izena = izena;
		this.helbidea = helbidea;
		this.kontinentea = kontinentea;
		this.herrialde = herrialde;
		this.probintzia = probintzia;
		this.udalerria = udalerria;
		this.postakodea = postakodea;
		this.id_herrialde = id_herrialde;
		this.id_kontinente = id_kontinente;
		this.id_kokaleku = id_kokaleku;
	}
	
	/**
	 * Idaren getterra
	 * @return id
	 */

	public int getId() {
		return id;
	}
	
	/**
	 * idearen setterra
	 * @param id
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Izenaren getterra
	 * @return izena
	 */

	public String getIzena() {
		return izena;
	}
	
	/**
	 * Izena aldatzeko setterra
	 * @param izena
	 */

	public void setIzena(String izena) {
		this.izena = izena;
	}
	
	/**
	 * Helbidearen getterra
	 * @return helbidea
	 */

	public String getHelbidea() {
		return helbidea;
	}
	
	/**
	 * Helbidea aldatzeko setterra
	 * @param helbidea
	 */

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}
	
	/**
	 * Kontinentearen getterra
	 * @return kontinentea
	 */

	public String getKontinentea() {
		return kontinentea;
	}
	
	/**
	 * kontinentea aldatzeko setterra
	 * @param kontinentea
	 */

	public void setKontinentea(String kontinentea) {
		this.kontinentea = kontinentea;
	}
	
	/**
	 * Herrialdearen getterra 
	 * @return herrialde
	 */

	public String getHerrialde() {
		return herrialde;
	}
	
	/**
	 * Herrialdea aldatzeko setterra
	 * @param herrialde
	 */

	public void setHerrialde(String herrialde) {
		this.herrialde = herrialde;
	}
	
	/**
	 * Probintziaren getterra
	 * @return probintzia
	 */

	public String getProbintzia() {
		return probintzia;
	}
	
	/**
	 * Probintzia aldatzeko setterra
	 * @param probintzia
	 */

	public void setProbintzia(String probintzia) {
		this.probintzia = probintzia;
	}
	
	/**
	 * Udalerriaren getterra
	 * @return udalerria
	 */

	public String getUdalerria() {
		return udalerria;
	}
	
	/**
	 * Udalerria aldatzeko setterra
	 * @param udalerria
	 */

	public void setUdalerria(String udalerria) {
		this.udalerria = udalerria;
	}
	
	/**
	 * Postakodearen getterra
	 * @return postakodea
	 */

	public String getPostakodea() {
		return postakodea;
	}
	
	/**
	 * Postakodea aldatzeko setterra
	 * @param postakodea
	 */

	public void setPostakodea(String postakodea) {
		this.postakodea = postakodea;
	}
	
	/**
	 * Id_herrialdearen getterra
	 * @return id_herrialde
	 */

	public String getId_herrialde() {
		return id_herrialde;
	}
	
	/**
	 * Id_herrialdea aldatzeko setterra
	 * @param id_herrialde
	 */

	public void setId_herrialde(String id_herrialde) {
		this.id_herrialde = id_herrialde;
	}
	
	/**
	 * id_kontinentearen getterra
	 * @return getterra
	 */

	public int getId_kontinente() {
		return id_kontinente;
	}
	
	/**
	 * id_kontinentea aldatzeko setterra
	 * @param id_kontinente
	 */

	public void setId_kontinente(int id_kontinente) {
		this.id_kontinente = id_kontinente;
	}
	
	/**
	 * id_kokalekuaren getterra
	 * @return id_kokaleku
	 */

	public int getId_kokaleku() {
		return id_kokaleku;
	}
	
	/**
	 * id_kokaleku aldatzeko setterra
	 * @param id_kokaleku
	 */

	public void setId_kokaleku(int id_kokaleku) {
		this.id_kokaleku = id_kokaleku;
	}
	
	/**
	 * toString funtzioa datuak bistaratzeko
	 */

	@Override
	public String toString() {
		return "Biltegi [id=" + id + ", id_herrialde=" + id_herrialde + ", id_kontinente=" + id_kontinente
				+ ", id_kokaleku=" + id_kokaleku + ", izena=" + izena + ", helbidea=" + helbidea + ", kontinentea="
				+ kontinentea + ", herrialde=" + herrialde + ", probintzia=" + probintzia + ", udalerria=" + udalerria
				+ ", postakodea=" + postakodea + "]";
	}
	
}
