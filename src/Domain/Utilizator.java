package Domain;

public class Utilizator {
    int id,age;
    String nume;
    String prenume;
    String adresaEMail;
    String numarTelefon;

    public Utilizator(int id, int age, String nume, String prenume, String adresaEMail, String numarTelefon) {
            //constructor cu parametrii
        this.id = id;
        this.age = age;
        this.nume = nume;
        this.prenume = prenume;
        this.adresaEMail = adresaEMail;
        this.numarTelefon = numarTelefon;
    }

    //getteri:
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public String getNume() {
        return nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public String getAdresaEMail() {
        return adresaEMail;
    }
    public String getNumarTelefon() {
        return numarTelefon;
    }

    //setteri:
    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setAdresaEMail(String adresaEMail) {
        this.adresaEMail = adresaEMail;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    //suprascrierea toString-ului:
    @Override
    public String toString() {
        return "Utilizator{" +
                "id=" + id +
                ", varsta=" + age +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", adresaEMail='" + adresaEMail + '\'' +
                ", numarTelefon='" + numarTelefon + '\'' +
                '}';
    }
}