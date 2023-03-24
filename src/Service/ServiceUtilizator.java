package Service;

import Domain.Prietenie;
import Domain.Utilizator;
import Domain.Validator.Validator;
import Repo.RepoModelImplementat;

import java.util.List;

public class ServiceUtilizator extends Service<Utilizator>{
    RepoModelImplementat<Prietenie> prietenieRepoModelImplementat;
    RepoModelImplementat<Utilizator> utilizatorRepoModelImplementat;
    Validator<Utilizator> utilizatorValidator;

    public ServiceUtilizator() {
    }

    public ServiceUtilizator(RepoModelImplementat<Utilizator> utilizatorRepoModelmplementat, RepoModelImplementat<Prietenie> prietenieRepoModelmplementat, Validator<Utilizator> utilizatorValidator) {
        this.utilizatorRepoModelImplementat = utilizatorRepoModelmplementat;
        this.prietenieRepoModelImplementat = prietenieRepoModelmplementat;
        this.utilizatorValidator = utilizatorValidator;
    }

    public Utilizator get_by_id(int id){
        //Luam un utilizator dupa id
        for(Utilizator u: utilizatorRepoModelImplementat.get_all()){
            if(u.getId() == id)
                return u;
        }
        return null;
    }

    public List<Utilizator> get_all(){
        //Get all lista de utilizatori
        return utilizatorRepoModelImplementat.get_all();
    }
    public void add(Utilizator element){
        //Adaugam un utilizator
        for(Utilizator u: utilizatorRepoModelImplementat.get_all()){
            if(u.getId() == element.getId())
                throw new IllegalArgumentException("Exista deja utilizator cu id-ul dat!");
        }
        utilizatorValidator.validate_add(element);
        utilizatorRepoModelImplementat.add(element);
    }

    public void delete(int id){
        //Stergem un utilizator dupa id
          int k = 0;
          for(Utilizator u: utilizatorRepoModelImplementat.get_all()){
              if(u.getId() == id) {
                  k = 1;
              }
          }
          if (k == 0)
              throw new IllegalArgumentException("Id-ul dat nu exista!");
          else{
              utilizatorValidator.validate_delete(get_by_id(id));
              utilizatorRepoModelImplementat.delete(id);
              for(int i = 0; i< prietenieRepoModelImplementat.get_all().size(); i++){
                  if(prietenieRepoModelImplementat.get_all().get(i).getIdPrieteniePrimita() == id || prietenieRepoModelImplementat.get_all().get(i).getIdPrietenieTrimisa() ==id){
                      prietenieRepoModelImplementat.delete(prietenieRepoModelImplementat.get_all().get(i).getId());
                      i--;
                  }
              }
         }
    }
}