package Service;

import java.util.List;
//lucram cu datele (face anumite operatii)
public abstract class Service<T> {

    public abstract List<T> get_all();

    public abstract T get_by_id(int id);

    public abstract void add(T element);

    public abstract void delete(int id);
}
