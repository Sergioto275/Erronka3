package DB;

/**
 * Eskari_info klasea
 * @author ikasle
 * @version 05/05
 */

public class Eskari_Info {
	private int id;
	private int idProd;
	private int kopurua;
	private double salneurria;
	
	/**
	 * Eraikitzailea parametroekin
	 * @param id
	 * @param idProd
	 * @param kopurua
	 * @param salneurria
	 */
	
	public Eskari_Info(int id, int idProd, int kopurua, double salneurria) {
		this.id = id;
		this.idProd = idProd;
		this.kopurua = kopurua;
		this.salneurria = salneurria;
	}
	
	/**
	 * idearen getterra
	 * @return id
	 */

	public int getId() {
		return id;
	}
	/**
	 * idea aldatzeko setterra
	 * @param id
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * id_produktuaren getterra
	 * @return idProd
	 */

	public int getIdProd() {
		return idProd;
	}
	
	/**
	 * idProd aldatzeko setterra
	 * @param idProd
	 */

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	
	/**
	 * kopuruaren getterra
	 * @return kopurua
	 */

	public int getKopurua() {
		return kopurua;
	}
	
	/**
	 * kopurua aldatzeko setterra
	 * @param kopurua
	 */

	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}
	
	/**
	 * salneurriaren getterra
	 * @return salneurria
	 */

	public double getSalneurria() {
		return salneurria;
	}
	
	/**
	 * salneurria aldatzeko setterra
	 * @param salneurria
	 */

	public void setSalneurria(double salneurria) {
		this.salneurria = salneurria;
	}
	
	/**
	 * toString funtzioa datuak bistaratzeko
	 */

	@Override
	public String toString() {
		return "Eskari_Info [id=" + id + ", idProd=" + idProd + ", kopurua=" + kopurua + ", salneurria=" + salneurria
				+ "]";
	}
}
