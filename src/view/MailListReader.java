package view;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import model.Mail;
public class MailListReader {
    
    public List<Mail> read (String fileName) throws IOException, ClassNotFoundException{
        
        List<Mail> lista =  new LinkedList<Mail>();
        try(FileReader is = new FileReader(new File(fileName))){
            BufferedReader reader = new BufferedReader(is);
            while (reader.ready()){
                Mail mail = new Mail(reader.readLine());
                if (mail.getDomain().length() != 0) lista.add(mail);
            }
            
        }
        
        
        return lista;
    }
}
