package DB;


public class Inbentario {
	private String biltegi_izena;
	private int stock_kop;
	
	public Inbentario(String biltegi_izena, int stock_kop) {
		super();
		this.biltegi_izena = biltegi_izena;
		this.stock_kop = stock_kop;
	}
	
	public String getBiltegi_izena() {
		return biltegi_izena;
	}
	
	public void setBiltegi_izena(String biltegi_izena) {
		this.biltegi_izena = biltegi_izena;
	}
	
	public int getStock_kop() {
		return stock_kop;
	}
	
	public void setStock_kop(int stock_kop) {
		this.stock_kop = stock_kop;
	}
	
	@Override
	public String toString() {
		return "Inbentario [biltegi_izena=" + biltegi_izena + ", stock_kop=" + stock_kop + "]";
	}
	
	
}
