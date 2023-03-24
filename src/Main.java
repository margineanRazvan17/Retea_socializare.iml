import Domain.Prietenie;
import Domain.Utilizator;
import Domain.Validator.ValidatorPrietenie;
import Domain.Validator.ValidatorUtilizator;
import Repo.RepoPrietenie;
import Repo.RepoUtilizator;
import Service.ServiceUtilizator;
import Service.ServicePrietenie;
import UserInterface.UI;

public class Main {
    public static void main(String[] args) {
        //valori initiale
        Utilizator utilizator1 = new Utilizator(1,19,"Pop","Anastasia","anastasia19@yahoo.com","0711111111");
        Utilizator utilizator2 = new Utilizator(2,22,"Petrescu","Vasile","petrescu_vasile@yahoo.com","0722222222");
        Utilizator utilizator3 = new Utilizator(3,13,"Andrei","Paula","pau.paula13@gmail.com","0733333333");
        Utilizator utilizator4 = new Utilizator(4,32,"Crainic","Raul","k.kraul@yahoo.com","0744444444");
        Prietenie prietenie1= new Prietenie(1,1,2,"Salut!");
        Prietenie prietenie2= new Prietenie(2,1,3,"Ce faci?");
        Prietenie prietenie3= new Prietenie(3,3,4,"Hei!");
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        RepoUtilizator repoUttilizator = new RepoUtilizator();
        ValidatorUtilizator validatorUtilizator = new ValidatorUtilizator();
        RepoPrietenie repoPrietenie = new RepoPrietenie();
        ValidatorPrietenie validatorPrietenie = new ValidatorPrietenie();
        ServiceUtilizator serviceUtilizator = new ServiceUtilizator(repoUttilizator,repoPrietenie,validatorUtilizator);
        ServicePrietenie servicePrietenie = new ServicePrietenie(repoUttilizator, repoPrietenie,validatorPrietenie);
        UI ui = new UI(serviceUtilizator, servicePrietenie);

        //adaugari de entitati:
        repoUttilizator.add(utilizator1);
        repoUttilizator.add(utilizator2);
        repoUttilizator.add(utilizator3);
        repoUttilizator.add(utilizator4);
        repoPrietenie.add(prietenie1);
        repoPrietenie.add(prietenie2);
        repoPrietenie.add(prietenie3);
        //--------------------------------------------------------------------------------------------------------------

        ui.run_menu();
    }
}