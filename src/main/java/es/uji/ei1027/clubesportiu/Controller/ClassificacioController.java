package es.uji.ei1027.clubesportiu.Controller;

import es.uji.ei1027.clubesportiu.Dao.ClassificacioDao;
import es.uji.ei1027.clubesportiu.Model.Classificacio;
import es.uji.ei1027.clubesportiu.Services.ClassificacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/classificacio")
public class ClassificacioController {
    private ClassificacioDao classificacioDao;
    private ClassificacioService classificacioService;

    @Autowired
    public void setClassificacioService(ClassificacioService classificacioService) {
        this.classificacioService = classificacioService;
    }

    @RequestMapping("/perpais")
    public String listClsfPerPais(Model model) {
        model.addAttribute("classificacions",
                classificacioService.getClassificationByCountry("Duos Sincro"));
        return "classificacio/perpais";
    }

    @Autowired
    public void setClassificacioDao(ClassificacioDao classificacioDao) {
        this.classificacioDao = classificacioDao;
    }

    @RequestMapping("/list")
    public String listClassificacio(Model model) {
        model.addAttribute("classificacions", classificacioDao.getClassificacions());
        return "classificacio/list";
    }

    @RequestMapping("/add")
    public String addClassificacio(Model model) {
        model.addAttribute("classificacio", new Classificacio());
        return "classificacio/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("classificacio") Classificacio classificacio, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "classificacio/add";
        classificacioDao.addClassificacio(classificacio);
        return "redirect:list";
    }

    @RequestMapping(value = "/update/{nomNadador}/{nomProva}", method = RequestMethod.GET)
    public String editClassificacio(Model model, @PathVariable String nomNadador, @PathVariable String nomProva) {
        model.addAttribute("classificacio", classificacioDao.getClassificacio(nomNadador, nomProva));
        return "classificacio/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String processUpdateSubmit(@ModelAttribute("classificacio") Classificacio classificacio, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "classificacio/update";
        classificacioDao.updateClassificacio(classificacio);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{nNadador}/{nProva}")
    public String processDeleteClassif(@PathVariable String nNadador, @PathVariable String nProva) {
        classificacioDao.deleteClassificacio(nNadador, nProva);
        return "redirect:../../list";
    }
}
