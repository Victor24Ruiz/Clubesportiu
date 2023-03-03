package es.uji.ei1027.clubesportiu.Controller;

import es.uji.ei1027.clubesportiu.Dao.NadadorDao;
import es.uji.ei1027.clubesportiu.Model.Nadador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/nadador")
public class NadadorController {
    private NadadorDao nadadorDao;

    @Autowired
    public void setNadadorDao(NadadorDao nadadorDao) {
        this.nadadorDao = nadadorDao;
    }

    @RequestMapping("/list")
    public String listNadadors(Model model) {
        model.addAttribute("nadadors", nadadorDao.getNadadors());
        return "nadador/list";
    }

    @RequestMapping("/add")
    public String addNadador(Model model) {
        model.addAttribute("nadador", new Nadador());
        return "nadador/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddSubmit(@ModelAttribute("nadador") Nadador nadador, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "nadador/add";
        nadadorDao.addNadador(nadador);
        return "redirect:list";
    }
}
