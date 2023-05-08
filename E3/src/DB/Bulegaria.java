package DB;
/**
 * Bulegaria klasea
 * @author T1
 * @version 05/05
 * @see Langile
 */

public class Bulegaria extends Langile {
	private String lanpostua;
	
	/**
	 * Eraikitzailea defektuz
	 */
	
	public Bulegaria() {
		super();
	}
	
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
	 * @param lanpostua
	 * @see Langile
	 */

	public Bulegaria(String izena, String abizena, int id, String email, String kontratatze_data, String telefonoa, int idNagusia, double soldata,
			String lanpostua) {
		super(izena, abizena, id,email, kontratatze_data, telefonoa, idNagusia, soldata);
		this.lanpostua = lanpostua;
	}
	
	/**
	 * Lanpostuaren getterra
	 * @return lanpostua
	 */

	public String getLanpostua() {
		return this.lanpostua;
	}
	
	/**
	 * Lanpostua aldatzeko setterra
	 * @param lanpostua
	 */

	public void setLanpostua(String lanpostua) {
		this.lanpostua = lanpostua;
	}
	
	/*
	 * toString funtzioa datuak bistaratzeko
	 */

	@Override
	public String toString() {
		return "Bulegaria [lanpostua=" + lanpostua + ", izena=" + izena + ", abizena=" + abizena + ", id=" + id
				+ ", email=" + email + ", kontratatze_data=" + kontratatze_data + ", telefonoa=" + telefonoa
				+ ", idNagusia=" + idNagusia + "]";
	}
	
	
}
