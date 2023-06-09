package conexioa;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DB.*;
import GUI.*;

/**
 * conexioa Klasea
 * @author T1
 * @version 05/05
 */

public class conexioa{
      private Connection c;
      private String url;
      private String erabiltzailea;
      private String pasahitza;

      /**
       * Defektuzko eraikitzailea
       */

      public conexioa(){}

      /**
       * Parametroekin eraikitzailea
       * @param url
       * @param erabiltzailea
       * @param pasahitza
       */

      public conexioa(String url, String erabiltzailea, String pasahitza){
         this.url = url;
         this.erabiltzailea = erabiltzailea;
         this.pasahitza = pasahitza;
         try{
        	 this.c = DriverManager.getConnection(url,erabiltzailea,pasahitza);
         }catch(Exception e){
            String mensaje = ""+e;
            JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
         }
      }

//ERABILTZAILEA ----------------------------------------------------------------------------------------------------------------------------------------------
      /**
       * Saltzaile mota funtzioa
       * @param erab
       * @return saltzailea
       * {@link Saltzailea}
       */

      public Saltzailea erabiltzaileKontsulta(String erab) {
    	  Saltzailea s = null;
    	  try {
    		  String Kontsulta = "SELECT L.IZENA, L.ABIZENA, L.ID, L.EMAILA, L.KONTRATAZIO_DATA, L.TELEFONOA, L.ID_NAGUSI, L.SOLDATA, S.ERABILTZAILEA, S.PASAHITZA FROM LANGILE L, SALTZAILE S WHERE ERABILTZAILEA = ? AND L.ID = S.ID";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, erab);
    		  ResultSet rt = st.executeQuery();
    		  rt.next();
    		  s = new Saltzailea(rt.getString("IZENA"),rt.getString("ABIZENA"),rt.getInt("ID"),rt.getString("EMAILA"),rt.getString("KONTRATAZIO_DATA"),rt.getString("TELEFONOA"),rt.getInt("ID_NAGUSI"),rt.getDouble("SOLDATA"),rt.getString("ERABILTZAILEA"),rt.getString("PASAHITZA"));
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return s;
      }
//BEZEROAK ----------------------------------------------------------------------------------------------------------------------------------------------
      /**
       * BezeroDB mota funtzioa
       * @return bezeroen arraya
       * {@link BezeroDB}
       */

      public BezeroDB bezeroKontsulta() {
    	  BezeroDB bdb = new BezeroDB();
    	  try {
    		  Statement st = this.c.createStatement();
    		  String kontsulta = "SELECT * FROM BEZERO B, BEZERO_TELEFONO BT WHERE B.ID = BT.ID_BEZERO ORDER BY B.ID ASC";
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  Bezeroa b = new Bezeroa(rt.getString("IZENA"),rt.getString("ABIZENA"),rt.getString("HELBIDEA"),rt.getInt("ID"),rt.getString("EMAILA"),rt.getString("ZENBAKIA"));
    			  bdb.addBezero(b);
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return bdb;
      }

      /**
       * Bezeroak txertatzeko funtzioa
       * @param id
       * @param izena
       * @param abizena
       * @param email
       * @param helbidea
       * @param telefonoa
       */

      public void bezeroInsert(int id, String izena, String abizena, String email, String helbidea, String telefonoa, DefaultTableModel modelo) {
    	  try {
    		  String Kontsulta = "INSERT INTO BEZERO VALUES (?,?,?,?,?)";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.setString(2, izena);
    		  st.setString(3, abizena);
    		  st.setString(4, helbidea);
    		  st.setString(5, email);
    		  st.executeQuery();
    		  st.close();
    		  String Kontsulta2 = "INSERT INTO BEZERO_TELEFONO VALUES(1,?,?)";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setInt(1, id);
    		  st2.setString(2, telefonoa);
    		  st2.executeQuery();
    		  st2.close();
    		  this.c.close();
			  modelo.addRow(new Object[] {id,izena,abizena,helbidea,email,telefonoa,null,null});
			  JOptionPane.showMessageDialog(null,"Hilara bat txertatu da","TXERTAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Bezeroen ezaugarriak aldatzeko funtzioa
       * @param id
       * @param izena
       * @param abizena
       * @param email
       * @param helbidea
       * @param telefonoa
       */

      public void bezeroUpdate(int id, String izena, String abizena, String email, String helbidea, String telefonoa) {
    	  try {
    		  String Kontsulta = "UPDATE BEZERO SET IZENA = ?, ABIZENA = ?, EMAILA = ?, HELBIDEA = ? WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, izena);
    		  st.setString(2, abizena);
    		  st.setString(3, email);
    		  st.setString(4, helbidea);
    		  st.setInt(5, id);
    		  st.executeUpdate();
    		  st.close();
    		  String Kontsulta2 = "UPDATE BEZERO_TELEFONO SET ZENBAKIA = ? WHERE ID = ?";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setString(1, telefonoa);
    		  st2.setInt(2, id);
    		  st2.executeUpdate();
    		  st2.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Bezeroak ezabatzeko funtzioa
       * @param id
       */

      public void bezeroDelete(int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM BEZERO WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara ezabatu da","EZABAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }
//PRODUKTUAK ----------------------------------------------------------------------------------------------------------------------------------------------

      /**
       * Produktuak bueltatzeko funtzioa
       * @return produktuen arraya
       * {@link ProduktuDB}
       */
      public ProduktuDB produktuKontsulta() {
    	  ProduktuDB pdb = new ProduktuDB();
    	  try {
    		  Statement st = this.c.createStatement();
    		  String kontsulta = "SELECT P.ID, P.IZENA, P.DESKRIBAPENA, P.BALIOA, P.SALNEURRIA, K.IZENA AS KIZENA FROM PRODUKTU P, KATEGORIA K WHERE P.ID_KATEGORIA = K.ID ORDER BY P.ID ASC";
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  Produktu p = new Produktu(rt.getInt("ID"),rt.getString("IZENA"),rt.getString("DESKRIBAPENA"),rt.getDouble("BALIOA"),rt.getDouble("SALNEURRIA"),rt.getString("KIZENA"),produktuInbKontsulta(rt.getInt("ID")));
    			  pdb.addProduktua(p);
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return pdb;
      }

      /**
       * Inbentarioan dauden produktuak kontsultatzeko funtzioa
       * @param idProd
       * @return inbentarioa
       * {@link Inbentario}
       */

      public Inbentario[] produktuInbKontsulta(int idProd) {
    	  Inbentario[] i = new Inbentario[0];
    	  try {
    		  String kontsulta = "SELECT ID_BILTEGI, KOPURUA FROM INBENTARIO WHERE ID_PRODUKTU = ? ORDER BY ID_BILTEGI ASC";
    		  PreparedStatement st = this.c.prepareStatement(kontsulta);
    		  st.setInt(1, idProd);
    		  ResultSet rt = st.executeQuery();
    		  while(rt.next()) {
    			  Inbentario inb = new Inbentario(rt.getInt("ID_BILTEGI"),rt.getInt("KOPURUA"));
    			  i = Arrays.copyOf(i, i.length+1);
    			  i[i.length-1]=inb;
    		  }
    		  rt.close();
    		  st.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return i;
      }

      /**
       * Produktuen kategoria kontsultatzeko funtzioa
       * @return arraya String
       */

      public String[] produktuKatKontsulta() {
    	  String[] i = new String[0];
    	  try {
    		  String kontsulta = "SELECT IZENA FROM KATEGORIA ORDER BY ID";
    		  Statement st = this.c.createStatement();
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  String kat = rt.getString("IZENA");
    			  i = Arrays.copyOf(i, i.length+1);
    			  i[i.length-1]=kat;
    		  }
    		  rt.close();
    		  st.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return i;
      }

      /**
       * Produktuak ezabatzeko funtzioa
       * @param id
       */

      public void produktuDelete(int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM PRODUKTU WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara ezabatu da","EZABAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Produktuak aldatzeko funtzioa
       * @param id
       * @param izena
       * @param deskribapena
       * @param balioa
       * @param salneurria
       * @param kategoria
       */

      public void produktuUpdate(int id, String izena, String deskribapena, double balioa, double salneurria, String kategoria) {
    	  try {
    		  String Kontsulta = "UPDATE PRODUKTU SET IZENA = ?, DESKRIBAPENA = ?, BALIOA = ?, SALNEURRIA = ?, ID_KATEGORIA = (SELECT ID FROM KATEGORIA WHERE IZENA = ?) WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, izena);
    		  st.setString(2, deskribapena);
    		  st.setDouble(3, balioa);
    		  st.setDouble(4, salneurria);
    		  st.setString(5, kategoria);
    		  st.setInt(6, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Produktuak txertatzeko funtzioa
       * @param id
       * @param izena
       * @param deskribapena
       * @param balioa
       * @param salneurria
       * @param kategoria
       */

      public void produktuInsert(int id, String izena, String deskribapena, double balioa, double salneurria, String kategoria, DefaultTableModel modelo) {
    	  try {
    		  String Kontsulta = "INSERT INTO PRODUKTU SELECT ?,?,?,?,?,ID FROM KATEGORIA WHERE IZENA = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.setString(2, izena);
    		  st.setString(3, deskribapena);
    		  st.setDouble(4, balioa);
    		  st.setDouble(5, salneurria);
    		  st.setString(6, kategoria);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    		  modelo.addRow(new Object[] {id,izena,deskribapena,salneurria,balioa,kategoria,null,null});
	          JOptionPane.showMessageDialog(null,"Hilara bat txertatu da","TXERTAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Inbentarioa ezabatzeko funtzioa
       * @param idProd
       * @param idBiltegi
       */

      public void inbentarioDelete(int idProd,int idBiltegi) {
    	  try {
    		  String Kontsulta = "DELETE FROM INBENTARIO WHERE ID_PRODUKTU = ? AND ID_BILTEGI = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, idProd);
    		  st.setInt(1, idBiltegi);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara ezabatu da","EZABAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Inbentarioa aldatzeko funtzioa
       * @param kopurua
       * @param idProd
       * @param idBiltegi
       */

      public void inbentarioUpdate(int kopurua, int idProd,int idBiltegi) {
    	  try {
    		  String Kontsulta = "UPDATE INBENTARIO SET KOPURUA = ? WHERE ID_PRODUKTU = ? AND ID_BILTEGI = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1,kopurua );
    		  st.setInt(2, idProd);
    		  st.setInt(3, idBiltegi);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Inbentarioa txertatzeko funtzioa
       * @param kopurua
       * @param idProd
       * @param idBiltegi
       */

      public void inbentarioInsert(int kopurua, int idProd,int idBiltegi, DefaultTableModel modelo) {
    	  try {
    		  String Kontsulta = "INSERT INTO INBENTARIO VALUES (?,?,?)";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, idProd);
    		  System.out.println(idBiltegi);
    		  st.setInt(2, idBiltegi);
    		  st.setInt(3, kopurua);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    		  modelo.addRow(new Object[] {idBiltegi,kopurua,null,null});
	          JOptionPane.showMessageDialog(null,"Hilara bat txertatu da","TXERTAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

//ESKARIAK ----------------------------------------------------------------------------------------------------------------------------------------------

      /**
       * EskariDB motako funtzioa eskariak kontsultatzeko
       * @return eskarien arraya
       * {@link EskariDB}
       */

      public EskariDB eskariKontsulta() {
    	  EskariDB edb = new EskariDB();
    	  try {
    		  Statement st = this.c.createStatement();
    		  String kontsulta = "SELECT E.ID, E.ID_BEZERO, EG.DESKRIBAPENA, E.ID_SALTZAILE, TO_CHAR(E.ESKAERA_DATA,'YYYY/MM/DD') AS ESKAERA_DATA FROM ESKARI E, ESKARI_EGOERA EG WHERE E.ID_EGOERA = EG.ID ORDER BY E.ID ASC";
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  Eskaria e = new Eskaria(rt.getInt("ID"),rt.getInt("ID_BEZERO"),rt.getInt("ID_SALTZAILE"),rt.getString("DESKRIBAPENA"),rt.getString("ESKAERA_DATA"),eskariInfoKontsulta(rt.getInt("ID")));
    			  edb.addEskaria(e);
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return edb;
      }

      /**
       * Eskari infoirmazio array mota kontsultatzeko funtzioa
       * @param idEsk
       * @return eskariak
       * {@link Eskari_Info}
       */

      public Eskari_Info[] eskariInfoKontsulta(int idEsk) {
    	  Eskari_Info[] esk = new Eskari_Info[0];
    	  try {
    		  String kontsulta = "SELECT ID_LERRO, ID_PRODUKTU, KOPURUA, SALNEURRIA FROM ESKARI_LERRO WHERE ID_ESKARI = ? ORDER BY ID_LERRO ASC";
    		  PreparedStatement st = this.c.prepareStatement(kontsulta);
    		  st.setInt(1,idEsk);
    		  ResultSet rt = st.executeQuery();
    		  while(rt.next()) {
    			  Eskari_Info e = new Eskari_Info(rt.getInt("ID_LERRO"),rt.getInt("ID_PRODUKTU"),rt.getInt("KOPURUA"),rt.getDouble("SALNEURRIA"));
    			  esk = Arrays.copyOf(esk, esk.length+1);
    			  esk[esk.length-1]= e;
    		  }
    		  rt.close();
    		  st.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return esk;
      }

      /**
       * Eskariak ezabatzeko funtzioa
       * @param id
       */

      public void eskariDelete(int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM ESKARI WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara ezabatu da","EZABAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Eskariak aldatzeko funtzioa parametroekin
       * @param id
       * @param id_bez
       * @param id_saltzaile
       * @param data
       * @param deskribapena
       */

      public void eskariUpdate(int id, int id_bez, int id_saltzaile, String data, String deskribapena) {
    	  try {
    		  String Kontsulta = "UPDATE ESKARI SET ID_BEZERO = ?, ID_SALTZAILE = ?, ESKAERA_DATA = TO_DATE(?,'YYYY/MM/DD'), ID_EGOERA = (SELECT ID FROM ESKARI_EGOERA WHERE DESKRIBAPENA = ?) WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id_bez);
    		  st.setInt(2, id_saltzaile);
    		  st.setString(3, data);
    		  st.setString(4, deskribapena);
    		  st.setInt(5, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Eskariak txertatzeko funtzioa
       * @param id
       * @param id_bez
       * @param id_saltzaile
       * @param data
       * @param deskribapena
       */

      public void eskariInsert(int id, int id_bez, int id_saltzaile, String data, String deskribapena,DefaultTableModel modelo) {
    	  try {
    		  String Kontsulta = "INSERT INTO ESKARI SELECT ?,?,ID,?,TO_DATE(?,'YYYY/MM/DD') FROM ESKARI_EGOERA WHERE DESKRIBAPENA = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.setInt(2, id_bez);
    		  st.setInt(3, id_saltzaile);
    		  st.setString(4, data);
    		  st.setString(5, deskribapena);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
    		  modelo.addRow(new Object[] {id,id_bez,deskribapena,id_saltzaile,data,null,null});
    		  JOptionPane.showMessageDialog(null,"Hilara bat txertatu da","TXERTAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Eskari arraya string mota kontsultatzeko funtzioa
       * @return eskaria
       */

      public String[] eskariEgKontsulta() {
    	  String[] i = new String[0];
    	  try {
    		  String kontsulta = "SELECT DESKRIBAPENA FROM ESKARI_EGOERA ORDER BY ID";
    		  Statement st = this.c.createStatement();
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  String eg = rt.getString("DESKRIBAPENA");
    			  i = Arrays.copyOf(i, i.length+1);
    			  i[i.length-1]=eg;
    		  }
    		  rt.close();
    		  st.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return i;
      }

      /**
       * Eskarien informazioa exabatzeko funtzioa
       * @param idEsk
       * @param id
       */

      public void eskariInfoDelete(int idEsk,int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM ESKARI_LERRO WHERE ID_ESKARI = ? AND ID_LERRO = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, idEsk);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara ezabatu da","EZABAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Eskarien informazioa aldatzeko funtzioa
       * @param idEsk
       * @param id
       * @param idProd
       * @param kopurua
       * @param salneurria
       */

      public void eskariInfoUpdate(int idEsk,int id, int idProd, int kopurua, Double salneurria) {
    	  try {
    		  String Kontsulta = "UPDATE ESKARI_LERRO SET ID_PRODUKTU = ?, SALNEURRIA = ?,KOPURUA = ? WHERE ID_ESKARI = ? AND ID_LERRO = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1,idProd);
    		  st.setDouble(2, salneurria);
    		  st.setInt(3, kopurua);
    		  st.setInt(4, idEsk);
    		  st.setInt(5, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

// SALTZAILEAK ------------------------------------------------------------------------------------------------------------------------------------------------------

      /**
       * SaltzaileDB array mota saltzaileak kontsultatzeko funtzioa
       * @return saltzaileen arraya
       * {@link SaltzaileDB}
       */

      public SaltzaileDB saltzaileakKontsulta() {
    	  SaltzaileDB sdb = new SaltzaileDB();
    	  try {
    		  Statement st = this.c.createStatement();
    		  String kontsulta = "SELECT L.IZENA, L.ABIZENA, L.ID, L.EMAILA, TO_CHAR(L.KONTRATAZIO_DATA,'YYYY/MM/DD') AS KONTRATAZIO_DATA, L.TELEFONOA, L.ID_NAGUSI, L.SOLDATA,  S.ERABILTZAILEA, S.PASAHITZA FROM LANGILE L, SALTZAILE S WHERE L.ID = S.ID ORDER BY L.ID ASC";
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  Saltzailea s = new Saltzailea(rt.getString("IZENA"),rt.getString("ABIZENA"),rt.getInt("ID"),rt.getString("EMAILA"),rt.getString("KONTRATAZIO_DATA"),rt.getString("TELEFONOA"),rt.getInt("ID_NAGUSI"),rt.getDouble("SOLDATA"),rt.getString("ERABILTZAILEA"),rt.getString("PASAHITZA"));
    			  sdb.addSaltzailea(s);
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREAK",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return sdb;
      }


      /**
       * Saltzaileak txertatzeko funtzioa
       * @param id
       * @param izena
       * @param abizena
       * @param email
       * @param k_data
       * @param telefonoa
       * @param id_nagusia
       * @param soldata
       * @param erabiltzailea
       * @param pasahitza
       */

      public void saltzaileInsert(int id, String izena, String abizena, String email, String k_data, String telefonoa, int id_nagusia,double soldata, String erabiltzailea, String pasahitza, DefaultTableModel modelo) {
    	  try {
    		  String Kontsulta = "INSERT INTO LANGILE VALUES (?,?,?,?,?,TO_DATE(?,'YYYY/MM/DD'),?,?)";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.setString(2, izena);
    		  st.setString(3, abizena);
    		  st.setString(4, email);
    		  st.setString(5, telefonoa);
    		  st.setString(6, k_data);
    		  st.setInt(7, id_nagusia);
    		  st.setDouble(8, soldata);
    		  st.executeQuery();
    		  st.close();
    		  String Kontsulta2 = "INSERT INTO SALTZAILE VALUES(?,?,?)";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setInt(1, id);
    		  st2.setString(2, erabiltzailea);
    		  st2.setString(3, pasahitza);
    		  st2.executeQuery();
    		  st2.close();
    		  this.c.close();
    		  modelo.addRow(new Object[] {id,izena,abizena,email,k_data,telefonoa,id_nagusia,soldata,erabiltzailea,pasahitza,null,null});
	          JOptionPane.showMessageDialog(null,"Hilara bat txertatu da","TXERTAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Saltzaileak aldatzeko funtzioa
       * @param id
       * @param izena
       * @param abizena
       * @param email
       * @param k_data
       * @param telefonoa
       * @param id_nagusia
       * @param soldata
       * @param erabiltzailea
       * @param pasahitza
       */

      public void saltzaileUpdate(int id, String izena, String abizena, String email, String k_data, String telefonoa, int id_nagusia,double soldata, String erabiltzailea, String pasahitza) {
    	  try {
    		  String Kontsulta = "UPDATE LANGILE SET IZENA = ?, ABIZENA = ?, EMAILA = ?, KONTRATAZIO_DATA = TO_DATE(?,'YYYY/MM/DD'), TELEFONOA = ?, ID_NAGUSI = ?, SOLDATA = ? WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, izena);
    		  st.setString(2, abizena);
    		  st.setString(3, email);
    		  st.setString(4, k_data);
    		  st.setString(5, telefonoa);
    		  st.setInt(6, id_nagusia);
    		  st.setDouble(7, soldata);
    		  st.setInt(8, id);
    		  st.executeUpdate();
    		  st.close();
    		  String Kontsulta2 = "UPDATE SALTZAILE SET ERABILTZAILEA = ?, PASAHITZA = ? WHERE ID = ?";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setString(1, erabiltzailea);
    		  st2.setString(2, pasahitza);
    		  st2.setInt(3, id);
    		  st2.executeUpdate();
    		  st2.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Saltzaileak ezabatzeko funtzioa
       * @param id
       */

      public void saltzaileDelete(int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM LANGILE WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara ezabatu da","EZABAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

// BULEGARIAK ------------------------------------------------------------------------------------------------------------------------------------------------------

      /**
       * BulegariDB motako funtzioa konstultatzeko
       * @return bulegarien arraya
       * {@link BulegariaDB}
       */

      public BulegariaDB bulegariKontsulta() {
    	  BulegariaDB bdb = new BulegariaDB();
    	  try {
    		  Statement st = this.c.createStatement();
    		  String kontsulta = "SELECT L.IZENA, L.ABIZENA, L.ID, L.EMAILA, TO_CHAR(L.KONTRATAZIO_DATA,'YYYY/MM/DD') AS KONTRATAZIO_DATA, L.TELEFONOA, L.ID_NAGUSI, L.SOLDATA, LA.DESKRIBAPENA FROM LANGILE L, BULEGARI B, LANPOSTU LA WHERE L.ID = B.ID AND B.LANPOSTU_ID = LA.ID ORDER BY L.ID ASC";
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  Bulegaria b = new Bulegaria(rt.getString("IZENA"),rt.getString("ABIZENA"),rt.getInt("ID"),rt.getString("EMAILA"),rt.getString("KONTRATAZIO_DATA"),rt.getString("TELEFONOA"),rt.getInt("ID_NAGUSI"),rt.getDouble("SOLDATA"),rt.getString("DESKRIBAPENA"));
    			  bdb.addBulegaria(b);
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREAK",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return bdb;
      }

      /**
       * Bulegariak txertatzeko funtzioa
       * @param id
       * @param izena
       * @param abizena
       * @param email
       * @param k_data
       * @param telefonoa
       * @param id_nagusia
       * @param soldata
       * @param deskribapena
       */

      public void bulegariInsert(int id, String izena, String abizena, String email, String k_data, String telefonoa, int id_nagusia,double soldata, String deskribapena, DefaultTableModel modelo) {
    	  try {
    		  String Kontsulta = "INSERT INTO LANGILE VALUES (?,?,?,?,?,TO_DATE(?,'YYYY/MM/DD'),?,?)";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.setString(2, izena);
    		  st.setString(3, abizena);
    		  st.setString(4, email);
    		  st.setString(5, telefonoa);
    		  st.setString(6, k_data);
    		  st.setInt(7, id_nagusia);
    		  st.setDouble(8, soldata);
    		  st.executeQuery();
    		  st.close();
    		  String Kontsulta2 = "INSERT INTO BULEGARI SELECT ?, ID FROM LANPOSTU WHERE DESKRIBAPENA = ?";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setInt(1, id);
    		  st2.setString(2, deskribapena);
    		  st2.executeQuery();
    		  st2.close();
    		  this.c.close();
    		  modelo.addRow(new Object[] {id,izena,abizena,email,k_data,telefonoa,id_nagusia,soldata,deskribapena,null,null});
	          JOptionPane.showMessageDialog(null,"Hilara bat txertatu da","TXERTAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Bulegariak aldatzeko funtzioa
       * @param id
       * @param izena
       * @param abizena
       * @param email
       * @param k_data
       * @param telefonoa
       * @param id_nagusia
       * @param soldata
       * @param deskribapena
       */

      public void bulegariUpdate(int id, String izena, String abizena, String email, String k_data, String telefonoa, int id_nagusia,double soldata, String deskribapena) {
    	  try {
    		  String Kontsulta = "UPDATE LANGILE SET IZENA = ?, ABIZENA = ?, EMAILA = ?, KONTRATAZIO_DATA = TO_DATE(?,'YYYY/MM/DD'), TELEFONOA = ?, ID_NAGUSI = ?, SOLDATA = ? WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, izena);
    		  st.setString(2, abizena);
    		  st.setString(3, email);
    		  st.setString(4, k_data);
    		  st.setString(5, telefonoa);
    		  st.setInt(6, id_nagusia);
    		  st.setDouble(7, soldata);
    		  st.setInt(8, id);
    		  st.executeUpdate();
    		  st.close();
    		  String Kontsulta2 = "UPDATE BULEGARI SET LANPOSTU_ID = (SELECT ID FROM LANPOSTU WHERE DESKRIBAPENA = ?) WHERE ID = ?";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setString(1, deskribapena);
    		  st2.setInt(2, id);
    		  st2.executeUpdate();
    		  st2.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Bulegariak ezabatzeko funtzioa
       * @param id
       */

      public void bulegariDelete(int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM LANGILE WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara ezabatu da","EZABAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

// BILTEGIAK ------------------------------------------------------------------------------------------------------------------------------------------------------

      /**
       * BiltegiDB motako funtzioa biltegiak kontsultatzeko
       * @return biltegien arraya
       * {@link BiltegiDB}
       */

      public BiltegiDB biltegiKontsulta() {
    	  BiltegiDB bdb = new BiltegiDB();
    	  try {
    		  Statement st = this.c.createStatement();
    		  String kontsulta = "SELECT B.ID, B.IZENA, K.HELBIDEA, K.POSTAKODEA, K.UDALERRIA, K.PROBINTZIA, H.IZENA AS HERRIALDE, KN.IZENA AS KONTINENTE, B.ID_KOKALEKU, K.ID_HERRIALDE, H.ID_KONTINENTE FROM BILTEGI B, KOKALEKU K, HERRIALDE H, KONTINENTE KN WHERE B.ID_KOKALEKU = K.ID AND K.ID_HERRIALDE = H.ID AND H.ID_KONTINENTE = KN.ID ORDER BY B.ID ASC";
    		  ResultSet rt = st.executeQuery(kontsulta);
    		  while(rt.next()) {
    			  Biltegi b = new Biltegi(rt.getInt("ID"),rt.getString("IZENA"),rt.getString("HELBIDEA"),rt.getString("KONTINENTE"),rt.getString("HERRIALDE"),rt.getString("PROBINTZIA"),rt.getString("UDALERRIA"),rt.getString("POSTAKODEA"),rt.getString("ID_HERRIALDE"),rt.getInt("ID_KONTINENTE"),rt.getInt("ID_KOKALEKU"));
    			  bdb.addBiltegia(b);
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
    		  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREAK",JOptionPane.WARNING_MESSAGE);
    	  }
    	  return bdb;
      }

      /**
       * Biltegiak txertatzeko funtzioa
       * @param id
       * @param izena
       * @param helbidea
       * @param kontinentea
       * @param herrialde
       * @param probintzia
       * @param udalerria
       * @param postakodea
       * @param id_kontinente
       * @param id_herrialde
       * @param id_kokaleku
       */

      public void biltegiInsert(int id, String izena, String helbidea, String kontinentea, String herrialde, String probintzia,
  			String udalerria, String postakodea, int id_kontinente, String id_herrialde, int id_kokaleku, DefaultTableModel modelo) {
    	  try {
    		  String Kontsulta4 = "INSERT INTO KONTINENTE VALUES(?,?)";
    		  PreparedStatement st4 = this.c.prepareStatement(Kontsulta4);
    		  st4.setInt(1, id_kontinente);
    		  st4.setString(2, kontinentea);
    		  st4.executeQuery();
    		  st4.close();
    		  String Kontsulta3 = "INSERT INTO HERRIALDE VALUES(?,?,?)";
    		  PreparedStatement st3 = this.c.prepareStatement(Kontsulta3);
    		  st3.setString(1, id_herrialde);
    		  st3.setString(2, herrialde);
    		  st3.setInt(3, id_kontinente);
    		  st3.executeQuery();
    		  st3.close();
    		  String Kontsulta2 = "INSERT INTO KOKALEKU VALUES(?,?,?,?,?,?)";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setInt(1, id_kokaleku);
    		  st2.setString(2, helbidea);
    		  st2.setString(3, postakodea);
    		  st2.setString(4, udalerria);
    		  st2.setString(5, probintzia);
    		  st2.setString(6, id_herrialde);
    		  st2.executeQuery();
    		  st2.close();
    		  String Kontsulta = "INSERT INTO BILTEGI VALUES (?,?,?)";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.setString(2, izena);
    		  st.setInt(3, id_kokaleku);
    		  st.executeQuery();
    		  st.close();
    		  this.c.close();
    		  modelo.addRow(new Object[] {id,izena,id_kokaleku,herrialde,udalerria,postakodea,probintzia,id_herrialde,herrialde,id_kontinente,kontinentea,null,null});
	          JOptionPane.showMessageDialog(null,"Hilara bat txertatu da","TXERTAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Biltegiak aldatzeko funtzioa
       * @param id
       * @param izena
       * @param helbidea
       * @param kontinentea
       * @param herrialde
       * @param probintzia
       * @param udalerria
       * @param postakodea
       * @param id_kontinente
       * @param id_herrialde
       * @param id_kokaleku
       */

      public void biltegiUpdate(int id, String izena, String helbidea, String kontinentea, String herrialde, String probintzia,
    			String udalerria, String postakodea, int id_kontinente, String id_herrialde, int id_kokaleku) {
    	  try {
    		  String Kontsulta4 = "UPDATE KONTINENTE SET IZENA = ? WHERE ID = ?";
    		  PreparedStatement st4 = this.c.prepareStatement(Kontsulta4);
    		  st4.setString(1, kontinentea);
    		  st4.setInt(2, id_kontinente);
    		  st4.executeQuery();
    		  st4.close();
    		  String Kontsulta3 = "UPDATE HERRIALDE SET IZENA = ?,ID_KONTINENTE = ? WHERE ID = ?";
    		  PreparedStatement st3 = this.c.prepareStatement(Kontsulta3);
    		  st3.setString(1, herrialde);
    		  st3.setInt(2, id_kontinente);
    		  st3.setString(3, id_herrialde);
    		  st3.executeQuery();
    		  st3.close();
    		  String Kontsulta2 = "UPDATE KOKALEKU SET HELBIDEA = ?,POSTAKODEA = ?, UDALERRIA = ?,PROBINTZIA = ?,ID_HERRIALDE = ? WHERE ID = ?";
    		  PreparedStatement st2 = this.c.prepareStatement(Kontsulta2);
    		  st2.setString(1, helbidea);
    		  st2.setString(2, postakodea);
    		  st2.setString(3, udalerria);
    		  st2.setString(4, probintzia);
    		  st2.setString(5, id_herrialde);
    		  st2.setInt(6, id_kokaleku);
    		  st2.executeQuery();
    		  st2.close();
    		  String Kontsulta = "UPDATE BILTEGI SET IZENA = ?, ID_KOKALEKU = ? WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, izena);
    		  st.setInt(2, id_kokaleku);
    		  st.setInt(3, id);
    		  st.executeQuery();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara eguneratu da","EGUNERAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

      /**
       * Biltegiak ezabatzeko funtzioa
       * @param id
       */

      public void biltegiDelete(int id) {
    	  try {
    		  String Kontsulta = "DELETE FROM BILTEGI WHERE ID = ?";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setInt(1, id);
    		  st.executeUpdate();
    		  st.close();
    		  this.c.close();
	          JOptionPane.showMessageDialog(null,"Hilara ezabatu da","EZABAKETA",JOptionPane.INFORMATION_MESSAGE);
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
    	  }
      }

// FUNTZIOEI ETA PROZEDUREN DEIAK ---------------------------------------------------------------------------------------------------------------------------------
      
      /**
       * Deskontuak egiteko funtzioa String motakoa
       * @return deskontuak
       */
      
      public String[] deskontuak() {
    	  String[] deskontuak = null;;
    	  try{
    		  CallableStatement call = this.c.prepareCall("{call DESKONTUA(?)}");
              call.registerOutParameter(1, oracle.jdbc.OracleTypes.ARRAY,"LISTAMAXIMO");
              call.execute();
              Array arr = call.getArray(1);
              if (arr != null) {
            	  deskontuak = (String[]) arr.getArray();
              }
              this.c.close();
          }catch(SQLException e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);
          }
    	  return deskontuak;
      }
      
      /**
       * Produktuen prezioak eguneratzeko funtzioa
       * @param datuak
       */

      public void updateProd(String datuak) {
    	  try{
    		  CallableStatement call = this.c.prepareCall("{call UPDATEPROD(?)}");
       		  call.setString(1,datuak);
              call.execute();
              this.c.close();
	          JOptionPane.showMessageDialog(null,"Produktuak eguneratu dira","TXERTAKETA",JOptionPane.INFORMATION_MESSAGE);
          }catch(SQLException e) {
        	  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);          
          }
      }
      
      /**
       * Funtzio hau saltzailea nagusia den edo ez bueltatzen du
       * @param id
       * @return
       */
      public boolean langileNagusia(int id) {
    	  boolean nagusi;
    	  int aux = 0;
    	  try{
    		  CallableStatement call = this.c.prepareCall("{? = call NAGUSIA_ALA_EZ(?)}");
    		  call.registerOutParameter(1, Types.INTEGER);
       		  call.setInt(2,id);
              call.execute();
              aux = call.getInt(1);
              this.c.close();
          }catch(SQLException e) {
        	  String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREAk",JOptionPane.WARNING_MESSAGE);          
          }
    	  if(aux == 1) {
    		  nagusi = true;
    	  }else {
    		  nagusi = false;
    	  }
    	  return nagusi;
      }
}
