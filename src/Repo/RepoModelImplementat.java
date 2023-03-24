package Repo;
import java.util.List;

public abstract class RepoModelImplementat<T> implements RepoModel<T>{
    public List<T> list;

    @Override
    public void add(T element) {
        list.add(element);
    }

    @Override
    public abstract void delete(int id);

    @Override
    public List<T> get_all() {
        return list;
    }
}
