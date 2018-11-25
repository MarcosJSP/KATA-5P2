
package controller;

import java.io.IOException;
import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReaderBD;

public class KATA4 {
    private String BD;
    private String table;
    private MailListReaderBD reader;
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
        BD = "KATA5.db";
        table = "EMAIL";
        reader = new MailListReaderBD();
        mailList = reader.read(BD, table);
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
