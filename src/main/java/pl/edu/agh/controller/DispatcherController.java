package pl.edu.agh.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.agh.model.GlobalSettings;
import pl.edu.agh.rest.GlobalSettingsService;

@Controller
@RequestMapping("/dispatcher")
public class DispatcherController {

	@Autowired
	private GlobalSettingsService globalSettingsDao;

	@RequestMapping("/configure")
	public String getConfigurePage(Model model) {
		GlobalSettings globalSettings = globalSettingsDao.getGlobalSettings();
		model.addAttribute("status", globalSettings.isActive() ? "aktywny" : "nieaktywny");
		model.addAttribute("time", globalSettings.getReassignCarerTime());
		return "configure";
	}

	@RequestMapping("/configure/updateAgent")
	public String getUpdateAgentForm(Model model) {

		GlobalSettings globalSettings = globalSettingsDao.getGlobalSettings();
//		model.addAttribute("noSelected", globalSettings.isActive() == true ? "true" : "false");
		model.addAttribute("agent", globalSettings);
		

		return "updateAgent";
	}

	@RequestMapping(value = "/configure/updateAgent", method = RequestMethod.POST)
	public String updateGlobalSettings(
			@ModelAttribute("agent") GlobalSettings globalSettings, Model model) {

		try {
			globalSettingsDao.postGlobalSettings(globalSettings);

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("info",
				"Aktualizacja ustawień agenta dyspozytora wykonana pomyślnie");
		globalSettings = globalSettingsDao.getGlobalSettings();
//		model.addAttribute("noSelected", globalSettings.isActive() == true ? "true" : "false");
		model.addAttribute("agent", globalSettings);
		

		return "updateAgent";
	}
}
