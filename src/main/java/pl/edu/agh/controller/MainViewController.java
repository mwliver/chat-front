package pl.edu.agh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainViewController {

	@RequestMapping(value = { "/", "home/" })
	public String hello(Model model) {
		return "main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( Model model,
						 @RequestParam(value = "error", required = false) String error,
						 @RequestParam(value = "logout", required = false) String logout) {
		System.out.println("test");
		System.out.println(error);
		System.out.println(logout);
//			ModelAndView model = new ModelAndView();
		model.addAttribute("test", "test");
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

//			if (logout != null) {
		model.addAttribute("msg", "You've been logged out successfully.");
//			}

		return "login";

	}
}
