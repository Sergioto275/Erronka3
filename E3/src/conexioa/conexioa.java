package conexioa;

import java.sql.*;
import javax.swing.*;

import DB.*;

public class conexioa{
      private Connection c;
      private String url;
      private String erabiltzailea;       
      private String pasahitza;
      
      public conexioa(){}

      public conexioa(String url, String erabiltzailea, String pasahitza){
         this.url = url;
         this.erabiltzailea = erabiltzailea;
         this.pasahitza = pasahitza;
         try{
            this.c = DriverManager.getConnection(url, erabiltzailea, pasahitza);
         }catch(Exception e){
            String mensaje = ""+e;
            JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
         }
      }
      
      public Saltzailea erabiltzaileKontsulta(String erab) {
    	  Saltzailea s = null;
    	  try {
    		  String Kontsulta = "SELECT L.IZENA, L.ABIZENA, L.ID, L.EMAILA, L.KONTRATAZIO_DATA, L.TELEFONOA, L.ID_NAGUSI, S.ERABILTZAILEA, S.PASAHITZA FROM LANGILE L, SALTZAILE S WHERE ERABILTZAILEA = ? AND L.ID = S.ID";
    		  PreparedStatement st = this.c.prepareStatement(Kontsulta);
    		  st.setString(1, erab);
    		  ResultSet rt = st.executeQuery();
    		  while(rt.next()) {
    			  s = new Saltzailea(rt.getString("IZENA"),rt.getString("ABIZENA"),rt.getString("ID"),rt.getString("EMAILA"),rt.getString("KONTRATAZIO_DATA"),rt.getString("TELEFONOA"),rt.getString("ID_NAGUSI"),rt.getString("ERABILTZAILEA"),rt.getString("PASAHITZA"));
    		  }
    		  rt.close();
    		  st.close();
    		  this.c.close();
    	  }catch(Exception e) {
              String mensaje = ""+e;
              JOptionPane.showMessageDialog(null, mensaje,"ERROREA",JOptionPane.WARNING_MESSAGE);        
    	  }
    	  return s;
      }
}