package es.uji.ei1027.clubesportiu.Controller;

import es.uji.ei1027.clubesportiu.Dao.ProvaDao;
import es.uji.ei1027.clubesportiu.Model.Prova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/prova")
public class ProvaController {
    private ProvaDao provaDao;

    @Autowired
    public void setProvaDao(ProvaDao provaDao) {
        this.provaDao = provaDao;
    }

    @RequestMapping("/list")
    public String listProva(Model model) {
        model.addAttribute("proves", provaDao.getProves());
        return "prova/list";
    }

    @RequestMapping("/add")
    public String addNadador(Model model) {
        model.addAttribute("prova", new Prova());
        return "prova/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("prova") Prova prova, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "prova/add";
        provaDao.addProva(prova);
        return "redirect:list";
    }
}
