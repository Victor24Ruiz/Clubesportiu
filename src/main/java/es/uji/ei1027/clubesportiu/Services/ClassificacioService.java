package es.uji.ei1027.clubesportiu.Services;

import es.uji.ei1027.clubesportiu.Model.Nadador;

import java.util.List;
import java.util.Map;

public interface ClassificacioService {
    public Map<String, List<Nadador>> getClassificationByCountry(String prova);
}
