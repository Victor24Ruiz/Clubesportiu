package es.uji.ei1027.clubesportiu.Controller;

import es.uji.ei1027.clubesportiu.Model.Nadador;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;

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
        List<String> valors = Arrays.asList("Femeni", "Masculi");
        if (!valors.contains(nadador.getGenere()))
            errors.rejectValue("genere", "valor incorrecte", "Deu ser: Femeni o Masculi");
    }
}
