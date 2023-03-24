package Repo;

import Domain.Prietenie;
import java.util.ArrayList;

public class RepoPrietenie extends RepoModelImplementat<Prietenie> {//mosteneste
    public RepoPrietenie() {
        this.list = new ArrayList<>();
    }

    Prietenie get_by_id(int id){
        for(Prietenie p: list)
            if(id == p.getId())
                return p;
        return null;
    }

    public void delete(int id) {
        list.remove(this.get_by_id(id));
    }
}
