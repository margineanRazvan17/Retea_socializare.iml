package Domain.Validator;

import Domain.Utilizator;




public class ValidatorUtilizator implements Validator<Utilizator>{
    @Override
    public void validate_add(Utilizator utilizator) {
        if(utilizator.getId() <= 0)
            throw new ValidationException("Id-ul nu poate fi mai mic sau egal cu 0.");
        if(utilizator.getAge() <= 0 || utilizator.getAge() >= 200)
            throw new ValidationException("Varsta nu poate fi mai mica sau egala cu 0 sau mai mare decat 200.");
        if(utilizator.getNume() == null)
            throw new ValidationException("Nu poate avea numele null");
        if(utilizator.getPrenume() == null)
            throw new ValidationException("Nu poate avea numele null");
        if(utilizator.getAdresaEMail() == null)
            throw new ValidationException("Nu poate avea adresa de mail nula");
        if(utilizator.getNumarTelefon() == null)
            throw new ValidationException("Nu poate avea numarul de telefon null.");
        if(utilizator.getNumarTelefon().length() != 10)
            throw new ValidationException("Numarul trebuie sa aiba 10 cifre!");
    }

    @Override
    public void validate_delete(Utilizator utilizator) {
        if(utilizator.getId() <= 0)
            throw new ValidationException("id-ul nu poate fi mai mic ca 0.");
    }
}
