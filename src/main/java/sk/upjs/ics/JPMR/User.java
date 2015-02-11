
package sk.upjs.ics.JPMR;

public class User {
    
    private int IdU = -1;
    private String meno;
    private String Heslo;
    private int typ;

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }

    public int getIdU() {
        return IdU;
    }

    public void setIdU(int IdU) {
        this.IdU = IdU;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getHeslo() {
        return Heslo;
    }

    public void setHeslo(String heslo) {
        this.Heslo = heslo;
    }

    @Override
    public String toString() {
        return IdU+"-"+meno+"-"+Heslo;
    }
     
    
}
