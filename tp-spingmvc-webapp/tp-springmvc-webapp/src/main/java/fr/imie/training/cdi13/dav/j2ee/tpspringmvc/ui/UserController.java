package fr.imie.training.cdi13.dav.j2ee.tpspringmvc.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/user")
	public String all(ModelMap model) {
		return "user";
	}
	
//	@RequestMapping("/user")
//	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//	    model.addAttribute("name", name);
//	    return "greeting";
//	}
	
//	@RequestMapping("/person")
//	public String all(ModelMap model) {
//		// model.addAttribute("list", dao.findAll);
//		return "person";
//	}
//
//	@RequestMapping("/person/select")
//	public String select(Person person, ModelMap model) {
//		person.getId();
//		// model.addAttribute("data", dao.findOne(id);
//		return all(model);
//	}
//
//	@RequestMapping("/person/save")
//	public String save(Person person, ModelMap model) {
//		// dao.insert ou update selon si l'id est null ou pas
//		return all(model);
//	}
//
//	@RequestMapping("/person/delete")
//	public String delete(Person person, ModelMap model) {
//		person.getId();
//		// dao.delete(id)
//		return all(model);
//	}
//	
}


