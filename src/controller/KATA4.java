
package controller;

import java.io.IOException;
import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class KATA4 {
    private String fileName;
    private MailListReader reader;
    private List<Mail> mailList;
    private MailHistogramBuilder builder;
    private Histogram<String> histogram;
    private HistogramDisplay histoDisplay;
    
    public static void main(String[] args){
        KATA4 m = new KATA4();
        m.control();
    }
    
    public void control(){
        input();
        process();
        output();
    }
    
    public void input(){
        try {
            fileName = "email.txt";
            reader = new MailListReader();
            mailList = reader.read(fileName);
        } catch (Exception e) {
            System.err.println("Hubo un error con la lectura del archivo");
        }
    }
    
    public void process(){
        builder = new MailHistogramBuilder();
        histogram = builder.build(mailList);
    }
    
    public void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
}
