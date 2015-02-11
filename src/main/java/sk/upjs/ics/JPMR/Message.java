package sk.upjs.ics.JPMR;

public class Message {    
    private int iDM;
    private String object;
    private String text;
    private int iDSender;
    private int iDReceiver;
    private String meno;//odosielatela - zmenime na eng nazov
    private String date;
    private int readMess;
    private int iDMovie = -1;

    public int getiDMovie() {
        return iDMovie;
    }

    public void setiDMovie(int iDMovie) {
        this.iDMovie = iDMovie;
    }

    public int getiDReceiver() {
        return iDReceiver;
    }

    public void setiDReceiver(int iDReceiver) {
        this.iDReceiver = iDReceiver;
    }    
    
    public int getReadMess() {
        return readMess;
    }

    public void setReadMess(int readMess) {
        this.readMess = readMess;
    }    

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public int getiDSender() {
        return iDSender;
    }

    public void setiDSender(int iDSender) {
        this.iDSender = iDSender;
    }

    public int getiDM() {
        return iDM;
    }

    public void setiDM(int iDM) {
        this.iDM = iDM;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
