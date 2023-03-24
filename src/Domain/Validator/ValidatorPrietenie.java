package Domain.Validator;
import Domain.Prietenie;

public class ValidatorPrietenie implements Validator<Prietenie>{
    @Override
    public void validate_add(Prietenie entity) {
        if(entity.getIdPrietenieTrimisa() <= 0)
            throw new ValidationException("Id-ul nu poate fi negativ!");
        if(entity.getIdPrieteniePrimita() <= 0)
            throw new ValidationException("Id-ul nu poate fi negativ!");
        if(entity.getId() <= 0)
            throw new ValidationException("Id-ul nu poate fi negativ!");
    }
    @Override
    public void validate_delete(Prietenie entity) {
        if(entity.getId() <= 0)
            throw new ValidationException("Id-ul nu poate fi negativ");
    }
}
