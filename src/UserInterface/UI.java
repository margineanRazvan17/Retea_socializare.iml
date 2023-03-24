package UserInterface;

import Domain.Prietenie;
import Domain.Utilizator;
import Domain.Validator.ValidationException;
import Service.ServicePrietenie;
import Service.ServiceUtilizator;

import java.util.Scanner;
//afisam/citim datele
public class UI {
    ServiceUtilizator serviceUtilizator;
    ServicePrietenie servicePrietenie;

    public UI(ServiceUtilizator serviceUtilizator, ServicePrietenie servicePrietenie) {
        this.serviceUtilizator = serviceUtilizator;
        this.servicePrietenie = servicePrietenie;
    }

    public void run_menu(){
        boolean ok = true;
        Scanner sc = new Scanner(System.in); //iterator
        String option;
        while (ok){
            System.out.println();
            System.out.println("1. Meniu utilizator.");
            System.out.println("2. Meniu prietenie.");
            System.out.println("x. Exit.");

            System.out.println("Introduceti optiunea: ");
            option = sc.nextLine();
        switch (option){
            case "1":{
                ui_utilizator();
                break;
            }
            case "2":{
                ui_prietenie();
                break;
            }
            case "x":{
                ok = false;
                break;
            }
            default:
                System.out.println("Optiune gresita! Reincercati: ");
        }
        }
    }

    //utilizator
    void ui_utilizator(){
        boolean ok = true;
        Scanner sc = new Scanner(System.in); //Citeste ce am introdus eu de la tastatura.
        String option;
        while (ok){
            System.out.println();
            System.out.println("1. Adaugare utilizator.");
            System.out.println("2. Stergere utilizator.");
            System.out.println("3. Afisare utilizatori.");
            System.out.println("x. Exit.");
        System.out.println("Introduceti optiunea: ");
        option = sc.nextLine();
        switch (option){
            case "1":{
                ui_add_utilizator();
                break;
            }
            case "2":{
                ui_delete_utilizator();
                break;
            }
            case "3":{
                show_all();
                break;
            }
            case "x":{
                ok = false;
                break;
            }
            default:
                System.out.println("Optiune gresita! Reincercati: ");
        }
    }}

    void ui_add_utilizator(){
        try{
        Scanner scanner=new Scanner(System.in);
        int id,varsta;
        String nume,prenume,adresa_de_mail,numar_telefon;
        System.out.println("Introduceti id-ul utilizatorului: ");
        id = scanner.nextInt();
        System.out.println("Introduceti varsta utilizatorului: ");
        varsta = scanner.nextInt();
        System.out.println("Introduceti numele utilizatorului: ");
        nume = scanner.next();
        System.out.println("Introduceti prenumele utilizatorului: ");
        prenume = scanner.next();
        System.out.println("Introduceti adresa de e-mail a utilizatorului: ");
        adresa_de_mail = scanner.next();
        System.out.println("Introduceti numarul de telefon al utilizatorului: ");
        numar_telefon = scanner.next();

        Utilizator utilizator= new Utilizator(id,varsta,nume,prenume,adresa_de_mail,numar_telefon);
        serviceUtilizator.add(utilizator);}
        catch (Exception e){
            System.out.println("Eroare: ");
            System.out.println(e.getMessage());
        }
    }
    void ui_delete_utilizator(){
        try{
            Scanner scanner=new Scanner(System.in);
            int id;
            System.out.println("Introduceti id-ul utilizatorului de sters: ");
            id = scanner.nextInt();
            serviceUtilizator.delete(id);
        }
        catch (Exception e){
            System.out.println("Eroare: ");
            System.out.println(e.getMessage());
        }
    }

    void show_all(){
        for(Utilizator utilizator: serviceUtilizator.get_all())
            System.out.println(utilizator);
    }

    //prietenie

    void ui_prietenie(){
        boolean ok=true;
        Scanner sc = new Scanner(System.in);
        String option;
        while (ok){
            System.out.println();
            System.out.println("1. Adaugare prietenie.");
            System.out.println("2. Stergere prietenie.");
            System.out.println("3. Afiseaza prietenii.");
            System.out.println("4. Afiseaza prietenii unui anumit utilizator.");
            System.out.println("x. Exit.");
            System.out.println("Introduceti optiunea: ");
            option = sc.nextLine();
            switch (option){
                case "1":{
                    ui_add_prietenie();
                    break;
                }
                case "2":{
                    ui_delete_prietenie();
                    break;
                }
                case "3":{
                    show_all_prietenie();
                    break;
                }
                case "4":{
                    ui_afiseaza_prietenii_unui_anumit_utilizator();
                    break;
                }
                case "x":{
                    ok = false;
                    break;
                }
                default:
                    System.out.println("Optiune gresita! Reincercati: ");
            }
        }
    }

    void ui_add_prietenie(){
        try{
            Scanner scanner=new Scanner(System.in);
            int id,id_utilizator1,id_utilizator2;
            String mesaj;
            System.out.println("Introduceti id prietenie: ");
            id = scanner.nextInt();
            System.out.println("Introduceti id-ul primului utilizator: ");
            id_utilizator1 = scanner.nextInt();
            System.out.println("Introduceti id-ul celui de-al doilea utilizator: ");
            id_utilizator2 = scanner.nextInt();
            System.out.println("Introduceti mesajul: ");
            mesaj = scanner.next();

            Prietenie prietenie= new Prietenie(id,id_utilizator1,id_utilizator2,mesaj);
            servicePrietenie.add(prietenie);
        }
        catch (Exception e){
            System.out.println("Eroare: ");
            System.out.println(e.getMessage());
        }
    }
    void ui_delete_prietenie(){
        try{
            Scanner scanner=new Scanner(System.in);
            int id;
            System.out.println("Introduceti id-ul prieteniei de sters: ");
            id = scanner.nextInt();
            servicePrietenie.delete(id);
        }
        catch (Exception e){
            System.out.println("Eroare: ");
            System.out.println(e.getMessage());
        }
    }
    void show_all_prietenie(){
        for(Prietenie prietenie: servicePrietenie.get_all())
            System.out.println(prietenie);
    }

    private void ui_afiseaza_prietenii_unui_anumit_utilizator() {
        int ok = 0;
        Scanner scan = new Scanner(System.in);
        int idDeCautat;
        System.out.println("Introduceti id-ul utilizatorului pt a-i vedea prieteniile: ");
        idDeCautat = scan.nextInt();

        for (Prietenie p : servicePrietenie.get_all())
            if (p.getIdPrieteniePrimita() == idDeCautat || p.getIdPrietenieTrimisa() == idDeCautat) {
                System.out.println(p);
                ok ++;
            }
        if(ok == 0)
            System.out.println("Id-ul nu corespunde niciunui utilizator! Reincercati! ");
    }
}