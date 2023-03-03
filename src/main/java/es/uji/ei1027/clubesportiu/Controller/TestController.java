package es.uji.ei1027.clubesportiu.Controller;

import es.uji.ei1027.clubesportiu.Categoria.Categoria;
import es.uji.ei1027.clubesportiu.Dao.NadadorDao;
import es.uji.ei1027.clubesportiu.Model.Nadador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    private Categoria categoria;
    @Autowired
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @RequestMapping("/provaCategoria")
    public String provaCategoria(Model model) {
        model.addAttribute("message", "El nadador té la categoria "
                + categoria.getCategoria(19));
        return "prova";
    }

    @RequestMapping("/provaTest")
    public String provaWeb(Model model) {
        String message = "Provant la Web del Club Esportiu";
        model.addAttribute("message", message);
        return "prova";
    }

    @Autowired
    NadadorDao nadadorDao;

    @RequestMapping("/provaNadador/{nom}")
    public String provaUnNadador(Model model, @PathVariable String nom) {
        Nadador nadador = nadadorDao.getNadador(nom);
        model.addAttribute("nadador", nadador);
        model.addAttribute("categoria", categoria.getCategoria(nadador.getEdat()));
        return "prova_nadador";
    }
}
