package es.uji.ei1027.clubesportiu.Services;

import es.uji.ei1027.clubesportiu.Dao.ClassificacioDao;
import es.uji.ei1027.clubesportiu.Dao.NadadorDao;
import es.uji.ei1027.clubesportiu.Model.Classificacio;
import es.uji.ei1027.clubesportiu.Model.Nadador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassificacioSvc implements ClassificacioService {

    @Autowired
    NadadorDao nadadorDao;

    @Autowired
    ClassificacioDao classificacioDao;

    @Override
    public Map<String, List<Nadador>> getClassificationByCountry(String prova) {
        List<Classificacio> classProva = classificacioDao.getClassificacioProva(prova);
        HashMap<String, List<Nadador>> nadadorsPerPais = new HashMap<String, List<Nadador>>();
        for (Classificacio clsf : classProva) {
            Nadador nadador = nadadorDao.getNadador(clsf.getNomNadador());
            if (!nadadorsPerPais.containsKey(nadador.getPais()))
                nadadorsPerPais.put(nadador.getPais(), new ArrayList<Nadador>());

            nadadorsPerPais.get(nadador.getPais()).add(nadador);
        }

        return nadadorsPerPais;
    }
}
