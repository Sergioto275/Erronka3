package DB;

/**
 * Inbentario klasea
 * @author T1
 * @version 05/05
 */

public class Inbentario {
	private int biltegi_id;
	private int stock_kop;
	
	/**
	 * eraikitzaile parametroekin
	 * @param biltegi_izena
	 * @param stock_kop
	 */
	
	public Inbentario(int biltegi_izena, int stock_kop) {
		super();
		this.biltegi_id = biltegi_izena;
		this.stock_kop = stock_kop;
	}
	
	/**
	 * biltegi_izenaren getterra
	 * @return biltegi_id
	 */
	
	public int getBiltegi_izena() {
		return biltegi_id;
	}
	
	/**
	 * biltegi izena aldatzeko setterra
	 * @param biltegi_izena
	 */
	
	public void setBiltegi_izena(int biltegi_izena) {
		this.biltegi_id = biltegi_izena;
	}
	
	/**
	 * stock kopuruaren getterra
	 * @return stock_kop
	 */
	
	public int getStock_kop() {
		return stock_kop;
	}
	
	/**
	 * stock kopurua aldatzeko setterra
	 * @param stock_kop
	 */
	
	public void setStock_kop(int stock_kop) {
		this.stock_kop = stock_kop;
	}
	
	/**
	 * toString funtzioa datuak bistaratzeko
	 */
	
	@Override
	public String toString() {
		return "Inbentario [biltegi_izena=" + biltegi_id + ", stock_kop=" + stock_kop + "]";
	}
	
	
}
