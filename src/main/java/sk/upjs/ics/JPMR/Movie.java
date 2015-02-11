package sk.upjs.ics.JPMR;

public class Movie {

    private long id = -1;
    private String meno;
    private String reziser;
    private String herci;
    private String zanre;
    private String jazyky;
    private String titulky;
    private int dlzka = 0; //minuty
    private int rok = 0;
    private int hodnotenie = 0; //0-10
    private String cesta;

    public Movie() {
        //default constructor
    }

    public Movie(String meno) {
        this.meno = meno;
    }

    @Override
    public String toString() {
        return "Film{" + "id=" + id + ", meno=" + meno + ", reziser=" + reziser + ", herci=" + herci + ", zanre=" + zanre + ", jazyky=" + jazyky + ", titulky=" + titulky + ", dlzka=" + dlzka + ", rok=" + rok + ", hodnotenie=" + hodnotenie + ", cesta=" + cesta + '}';
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public String getHerci() {
        return herci;
    }

    public void setHerci(String herci) {
        this.herci = herci;
    }

    public String getZanre() {
        return zanre;
    }

    public void setZanre(String zanre) {
        this.zanre = zanre;
    }

    public int getDlzka() {
        return dlzka;
    }

    public void setDlzka(int dlzka) {
        this.dlzka = dlzka;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getHodnotenie() {
        return hodnotenie;
    }

    public void setHodnotenie(int hodnotenie) {
        this.hodnotenie = hodnotenie;
    }

    public String getCesta() {
        return cesta;
    }

    public void setCesta(String cesta) {
        this.cesta = cesta;
    }

    public String getJazyky() {
        return jazyky;
    }

    public void setJazyky(String jazyky) {
        this.jazyky = jazyky;
    }

    public String getTitulky() {
        return titulky;
    }

    public void setTitulky(String titulky) {
        this.titulky = titulky;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void changeAttributes(String name, String path, String director, String actors, String genres, String languages, String subtitles, int releaseYear, int rating, int screenTime) {
        if (name != null || !name.equals(this.meno)) {
            this.setMeno(name);
        }

        if (path != null || !path.equals(this.cesta)) {
            this.setCesta(path);
        }

        if (director != null || !director.equals(this.reziser)) {
            this.setReziser(director);
        }

        if (actors != null || !actors.equals(this.herci)) {
            this.setHerci(actors);
        }

        if (genres != null || !genres.equals(this.zanre)) {
            this.setZanre(genres);
        }

        if (languages != null || !languages.equals(this.jazyky)) {
            this.setJazyky(languages);
        }

        if (subtitles != null || !subtitles.equals(this.titulky)) {
            this.setTitulky(subtitles);
        }

        if (releaseYear != 0 || this.rok != releaseYear) {
            this.setRok(releaseYear);
        }

        if (rating != 0 || this.hodnotenie != rating) {
            this.setHodnotenie(rating);
        }

        if (screenTime != 0 || this.dlzka != screenTime) {
            this.setDlzka(screenTime);
        }
    }

}
