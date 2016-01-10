package pl.edu.agh.rest;

import java.io.IOException;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import pl.edu.agh.model.GlobalSettings;

@Repository
public class GlobalSettingsService {

	public void postGlobalSettings(GlobalSettings globalSettings)
			throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(UrlsList.GET_BASE_URL
				+ UrlsList.GET_GLOBAL_SETTINGS_POST_URL, globalSettings,
				GlobalSettings.class);
	}

	public GlobalSettings getGlobalSettings() {
		RestTemplate rt = new RestTemplate();
		return rt.getForObject(UrlsList.GET_BASE_URL
				+ UrlsList.GET_GLOBAL_SETTINGS_URL, GlobalSettings.class);
	}
}
