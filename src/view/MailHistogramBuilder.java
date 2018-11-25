package view;

import java.util.List;
import model.Histogram;
import model.Mail;

public class MailHistogramBuilder {
    public Histogram<String> build(List<Mail> lista){
        Histogram<String> histogram = new Histogram<>();
        for(Mail mail : lista) {
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }
}
