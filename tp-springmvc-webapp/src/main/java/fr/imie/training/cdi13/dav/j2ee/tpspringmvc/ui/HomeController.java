package fr.imie.training.cdi13.dav.j2ee.tpspringmvc.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String all(ModelMap model) {
		return "home";
	}

}
