package Domain.Validator;

public interface Validator<T> {
    void validate_add(T entity);
    void validate_delete(T entity);
}
