package Domain;

public class Prietenie {
    int id;
    int idPrietenieTrimisa;
    int idPrieteniePrimita;
    String mesaj;

    public Prietenie(int id, int idPrietenieTrimisa, int idPrieteniePrimita, String mesaj) {
            //constructor cu parametrii
        this.id = id;
        this.idPrietenieTrimisa = idPrietenieTrimisa;
        this.idPrieteniePrimita = idPrieteniePrimita;
        this.mesaj = mesaj;
    }

    //getter si setter pt id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //getter si setter pt PrietenieTrimisa
    public int getIdPrietenieTrimisa() {
        return idPrietenieTrimisa;
    }
    public void setIdPrietenieTrimisa(int idPrietenieTrimisa) {
        this.idPrietenieTrimisa = idPrietenieTrimisa;
    }

    //getter si setter pt PrieteniePrimita
    public int getIdPrieteniePrimita() {
        return idPrieteniePrimita;
    }

    public void setIdPrieteniePrimita(int idPrieteniePrimita) {
        this.idPrieteniePrimita = idPrieteniePrimita;
    }

    //getter si setter pt Mesaj
    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    //to string-ul:
    @Override
    public String toString() {
        return "Prietenie{" +
                "id=" + id +
                ", idPrietenieTrimisa=" + idPrietenieTrimisa +
                ", idPrieteniePrimita=" + idPrieteniePrimita +
                ", mesaj='" + mesaj + '\'' +
                '}';
    }
}
