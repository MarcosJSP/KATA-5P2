package view;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import model.Mail;
public class MailListReaderBD {
    
    public List<Mail> read (String baseDatos, String tabla){
        List<Mail> lista =  new LinkedList<Mail>();
        
        String url = "jdbc:sqlite:" + baseDatos;
        String sql = "select * from " + tabla;
        
        Connection con = null;
        try {
            //establecemos conexión con la base de datos
            con = DriverManager.getConnection(url);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            //recorremos registros de la tabla
            while(rs.next()){
                Mail mail = new Mail(rs.getString("Mail"));
                if (mail.getDomain().length() != 0) lista.add(mail);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }       
        return lista;
    }
}
