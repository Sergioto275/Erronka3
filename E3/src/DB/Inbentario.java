package DB;


public class Inbentario {
	private int biltegi_id;
	private int stock_kop;
	
	public Inbentario(int biltegi_izena, int stock_kop) {
		super();
		this.biltegi_id = biltegi_izena;
		this.stock_kop = stock_kop;
	}
	
	public int getBiltegi_izena() {
		return biltegi_id;
	}
	
	public void setBiltegi_izena(int biltegi_izena) {
		this.biltegi_id = biltegi_izena;
	}
	
	public int getStock_kop() {
		return stock_kop;
	}
	
	public void setStock_kop(int stock_kop) {
		this.stock_kop = stock_kop;
	}
	
	@Override
	public String toString() {
		return "Inbentario [biltegi_izena=" + biltegi_id + ", stock_kop=" + stock_kop + "]";
	}
	
	
}
