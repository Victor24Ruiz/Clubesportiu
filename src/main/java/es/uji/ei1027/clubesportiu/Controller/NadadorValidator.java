package es.uji.ei1027.clubesportiu.Controller;

import es.uji.ei1027.clubesportiu.Model.Nadador;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NadadorValidator implements Validator {
    @Override
    public boolean supports(Class<?> cls) {
        return Nadador.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Nadador nadador = (Nadador) obj;
        if (nadador.getNom().trim().equals(""))
            errors.rejectValue("nom", "obligatori", "Cal introduir un valor");
        if (nadador.getEdat() <= 15)
            errors.rejectValue("edat", "invalid", "El nadador ha de tenir més de 15 anys");
    }
}
