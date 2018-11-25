package model;

public class Mail {
    private String mail;
    
    public Mail(String mail){
        this.mail = mail;
    }
    
    public String getDomain(){
        String [] email = mail.split("@");       
        return email.length == 2 ? email[1] : "";
    }
}
