package DB;

import java.util.Arrays;

/**
 * Produktu klasea
 * @author T1
 * @version 05/05
 * @see Inbentario
 */

public class Produktu {
		private int id;
		private String kategoria;
		private String izena;
		private String deskribapena;
		private double balioa;
		private double salneurria;
		private Inbentario [] inbentario;
		
		/**
		 * Produktuaren eraikitzalea defektuz
		 */
		
		public Produktu() {}
		
		/**
		 * Eraikitzailea parametroekin
		 * @param id
		 * @param izena
		 * @param deskribapena
		 * @param balioa
		 * @param salneurria
		 * @param kategoria
		 * @param inbentario
		 * @see Inbentario
		 */

		public Produktu(int id,String izena, String deskribapena, double balioa, double salneurria, String kategoria, Inbentario[] inbentario) {
			super();
			this.id = id;
			this.kategoria = kategoria;
			this.izena = izena;
			this.deskribapena = deskribapena;
			this.balioa = balioa;
			this.salneurria = salneurria;
			this.inbentario = inbentario;
		}
		
		/**
		 * id getterra
		 * @return id
		 */

		public int getId() {
			return this.id;
		}
		
		/**
		 * idtik produktu_kodeara aldatzeko setterra
		 * @param prod_kodea
		 */

		public void setProd_kodea(int prod_kodea) {
			this.id = prod_kodea;
		}
		
		/**
		 * kategoria aldatzeko setterra
		 * @return
		 */

		public String getKategoria() {
			return this.kategoria;
		}
		
		/**
		 * kategoria aldatzeko setterra
		 * @param kategoria
		 */

		public void setKategoria(String kategoria) {
			this.kategoria = kategoria;
		}
		
		/**
		 * izenaren getterra
		 * @return izena
		 */

		public String getIzena() {
			return this.izena;
		}
		
		/**
		 * izena aldatzeko setterra
		 * @param izena
		 */

		public void setIzena(String izena) {
			this.izena = izena;
		}
		
		/**
		 * deskribapenaren getterra
		 * @return deskribapena
		 */

		public String getDeskribapena() {
			return this.deskribapena;
		}
		
		/**
		 * deskribapena aldatzeko setterra
		 * @param deskribapena
		 */

		public void setDeskribapena(String deskribapena) {
			this.deskribapena = deskribapena;
		}
		
		/**
		 * balioaren getterra
		 * @return balioa
		 */

		public double getBalioa() {
			return this.balioa;
		}
		
		/**
		 * balioa aldatzeko setterra
		 * @param balioa
		 */

		public void setBalioa(double balioa) {
			this.balioa = balioa;
		}
		
		/**
		 * uneko salneurriaren getterra
		 * @return salneurria
		 */

		public double getUneko_salneurria() {
			return this.salneurria;
		}
		
		/**
		 * salneurritik uneko salneurrira aldatzeko setterra
		 * @param uneko_salneurria
		 */

		public void setUneko_salneurria(double uneko_salneurria) {
			this.salneurria = uneko_salneurria;
		}
		
		/**
		 * inbentarioaren getterra
		 * @return inbentario
		 * @see Inbentario
		 */

		public Inbentario[] getInbentario() {
			return inbentario;
		}
		
		/**
		 * inbentario aldatzeko setterra
		 * @param inbentario
		 * @see Inbentario
		 */

		public void setInbentario(Inbentario[] inbentario) {
			this.inbentario = inbentario;
		}
		
		/**
		 * inbentarioak arrayari gehitzeko
		 * @param inbentario
		 */
		
		public void addInbentario(Inbentario inbentario) {
			this.inbentario = Arrays.copyOf(this.inbentario, this.inbentario.length+1);
			this.inbentario[this.inbentario.length-1] = inbentario;
		}
		
		/**
		 * toString funtzioa datuak bistaratzeko
		 */

		@Override
		public String toString() {
			return "Produktu [id=" + id + ", kategoria=" + kategoria + ", izena=" + izena + ", deskribapena="
					+ deskribapena + ", balioa=" + balioa + ", salneurria=" + salneurria + ", inbentario="
					+ Arrays.toString(inbentario) + "]";
		}
		
		
}
