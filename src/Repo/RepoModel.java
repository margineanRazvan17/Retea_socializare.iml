package Repo;

import java.util.List;
//salvam datele
public interface RepoModel<T> {
    void add(T element);

    void delete(int id);

    List<T> get_all();
}
