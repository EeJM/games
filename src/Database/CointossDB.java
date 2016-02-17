package Database;



public class CointossDB {
    
    private final int henkiloID;
    private final String etunimi;
    private final String sukunimi;
    private final int syntymavuosi;

    public CointossDB(int henkiloID, String etunimi, String sukunimi, int syntymavuosi) {
        this.henkiloID = henkiloID;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymavuosi = syntymavuosi;
    }

    public int getHenkiloID() {
        return henkiloID;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public int getSyntymavuosi() {
        return syntymavuosi;
    }

    @Override
    public String toString() {
        return "ID=" + henkiloID +": " + etunimi + " " + sukunimi +". S." + syntymavuosi;
    }
    
    

    
}
