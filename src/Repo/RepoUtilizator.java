package Repo;
import Domain.Utilizator;
import java.util.ArrayList;

public class RepoUtilizator extends RepoModelImplementat<Utilizator> {
    public RepoUtilizator() {
        this.list=new ArrayList<>();
    }

    Utilizator get_by_id(int id){
        for(Utilizator u: list)
            if(id == u.getId())
                return u;
        return null;
    }

    public void delete(int id) {
        list.remove(this.get_by_id(id));
    }
}