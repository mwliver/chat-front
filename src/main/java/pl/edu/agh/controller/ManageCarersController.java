package pl.edu.agh.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.edu.agh.model.Carer;
import pl.edu.agh.rest.CarerService;
import pl.edu.agh.rest.UrlsList;

@Controller
@RequestMapping("/manage/carers")
public class ManageCarersController {

	@Autowired
	private CarerService carerService;

	@RequestMapping("/list")
	public String hello(Model model) {
		List<Carer> carerslist = carerService.getAll();

		model.addAttribute("carers", carerslist);
		return "listCarers";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String viewAddCarer(Model model) {
		Carer carer = new Carer();

		model.addAttribute("carerForm", carer);

		return "addCarer";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCarer(@ModelAttribute("carerForm") Carer carer,
			Model model) {
		carer.setLastModification(new Date());
		carer.setUserRole("ROLE_CARER");
		try {
			carerService.postCarer(carer, UrlsList.GET_SAVE_CARER_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("info", "Dodano nowego opiekuna");
		model.addAttribute("carerForm", new Carer());

		return "addCarer";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String removeCarer(@RequestParam("id") long id, Model model) {

		List<Carer> carerslist = carerService.getAll();

		Carer carerToDelete = null;
		for (Carer carer : carerslist) {
			if (carer.getId() == id) {
				carerToDelete = carer;
				break;
			}
		}

		try {
			carerService
					.postCarer(carerToDelete, UrlsList.GET_REMOVE_CARER_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("info", "Usunięto opiekuna");
		carerslist = carerService.getAll();
		model.addAttribute("carers", carerslist);

		return "listCarers";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getUpdateCarerView(@RequestParam("id") long id, Model model) {

		List<Carer> carerslist = carerService.getAll();
		Carer carerToUpdate = null;

		for (Carer carer : carerslist) {
			if (carer.getId() == id) {
				carerToUpdate = carer;
				break;
			}
		}

		model.addAttribute("carer", carerToUpdate);

		return "editCarer";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCarer(@ModelAttribute("carer") Carer carer, Model model) {
		carer.setLastModification(new Date());
		carer.setUserRole("ROLE_CARER");
		try {
			carerService.postCarer(carer, UrlsList.GET_UPDATE_CARER_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("info", "Zmieniono dane opiekuna");
		model.addAttribute("carer", carer);

		return "editCarer";
	}

}
