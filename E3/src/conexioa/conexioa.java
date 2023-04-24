package conexioa;

import java.sql.*;
import javax.swing.*;

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
}