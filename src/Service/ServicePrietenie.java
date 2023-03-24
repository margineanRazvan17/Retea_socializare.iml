package Service;

import Domain.Prietenie;
import Domain.Utilizator;
import Domain.Validator.ValidationException;
import Domain.Validator.Validator;
import Repo.RepoModelImplementat;
import java.util.List;

public class ServicePrietenie extends Service<Prietenie>{
    RepoModelImplementat<Utilizator> utilizatorRepoModelImplementat;
    RepoModelImplementat<Prietenie> prietenieRepoModelImplementat;
    Validator<Prietenie> prietenieValidator;

    public ServicePrietenie(RepoModelImplementat<Utilizator> utilizatorRepoModelImplementat,
                            RepoModelImplementat<Prietenie> prietenieRepoModelImplementat,
                            Validator<Prietenie> prietenieValidator) {
        this.utilizatorRepoModelImplementat = utilizatorRepoModelImplementat;
        this.prietenieRepoModelImplementat = prietenieRepoModelImplementat;
        this.prietenieValidator = prietenieValidator;
    }

    public List<Prietenie> get_all(){
        //Get all lista de prieteni
        return prietenieRepoModelImplementat.get_all();
    }

    public Prietenie get_by_id(int id){
        //Luam o prietenie dupa id
        for(Prietenie p: prietenieRepoModelImplementat.get_all()){
            if(p.getId() == id)
                return p;
        }
    return null;
    }

    public void add(Prietenie prietenie){
        //Adaugam o prietenie
        int k1=0;
        int k2=0;
        int ok =1;
        for(Prietenie p: prietenieRepoModelImplementat.get_all()){
            if(p.getId() == prietenie.getId())
                throw new ValidationException("Exista deja prietenie cu id-ul dat!");
        }

        //Verificam daca exista utilizatorii:
        for(Utilizator u: utilizatorRepoModelImplementat.get_all()){
            if(prietenie.getIdPrieteniePrimita() == u.getId()){
                    k1=1;
            }
        }
        for(Utilizator u: utilizatorRepoModelImplementat.get_all()){
            if(prietenie.getIdPrietenieTrimisa() == u.getId()){
                k2=1;
            }
        }
        //Verificam daca exista prietenie intre utilizatori:
        for(Prietenie prietenie1: prietenieRepoModelImplementat.get_all()) {
            if(prietenie1.getIdPrietenieTrimisa() == prietenie.getIdPrietenieTrimisa() && prietenie1.getIdPrieteniePrimita() == prietenie.getIdPrieteniePrimita())
                ok =0;
        }
        for(Prietenie prietenie1: prietenieRepoModelImplementat.get_all()) {
            if(prietenie1.getIdPrieteniePrimita() == prietenie.getIdPrietenieTrimisa() && prietenie1.getIdPrietenieTrimisa() == prietenie.getIdPrieteniePrimita())
                ok =0;
        }

        //Daca toate conditiile sunt satisfacute se adauga prietenia:
        if(k2 == 1 && k1 ==1 && ok ==1){
            prietenieValidator.validate_add(prietenie);
            prietenieRepoModelImplementat.add(prietenie);
        }
        else
            throw new ValidationException("Id-ul utilizatorului dat nu exista!");
    }

    public void delete(int id){
        //Stergem o prietenie dupa id
        int k=0;
        for(Prietenie p: prietenieRepoModelImplementat.get_all()){
            if(p.getId() == id){
                k=1;
            }
        }
        if (k == 0)
            throw new ValidationException("Id-ul prieteniei date nu exista!");
        else{
            prietenieValidator.validate_delete(get_by_id(id));
            prietenieRepoModelImplementat.delete(id);}
    }
}