package DB;


public class Biltegi {
	private int id;
	private String izena;
	private String helbidea;
	private String kontinentea;
	private String herrialde;
	private String probintzia;
	private String udalerria;
	private String postakodea;

	
	public Biltegi () {}

	public Biltegi(int id, String izena, String helbidea, String kontinentea, String herrialde, String probintzia,
			String udalerria, String postakodea) {
		super();
		this.id = id;
		this.izena = izena;
		this.helbidea = helbidea;
		this.kontinentea = kontinentea;
		this.herrialde = herrialde;
		this.probintzia = probintzia;
		this.udalerria = udalerria;
		this.postakodea = postakodea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getHelbidea() {
		return helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	public String getKontinentea() {
		return kontinentea;
	}

	public void setKontinentea(String kontinentea) {
		this.kontinentea = kontinentea;
	}

	public String getHerrialde() {
		return herrialde;
	}

	public void setHerrialde(String herrialde) {
		this.herrialde = herrialde;
	}

	public String getProbintzia() {
		return probintzia;
	}

	public void setProbintzia(String probintzia) {
		this.probintzia = probintzia;
	}

	public String getUdalerria() {
		return udalerria;
	}

	public void setUdalerria(String udalerria) {
		this.udalerria = udalerria;
	}

	public String getPostakodea() {
		return postakodea;
	}

	public void setPostakodea(String postakodea) {
		this.postakodea = postakodea;
	}

	@Override
	public String toString() {
		return "Biltegi [id=" + id + ", izena=" + izena + ", helbidea=" + helbidea + ", kontinentea=" + kontinentea
				+ ", herrialde=" + herrialde + ", probintzia=" + probintzia + ", udalerria=" + udalerria
				+ ", postakodea=" + postakodea + "]";
	}
	
}
