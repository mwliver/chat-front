package pl.edu.agh.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import pl.edu.agh.model.Carer;

@Repository
public class CarerService {

	public List<Carer> getAll() {

		List<Carer> carerList = new ArrayList<Carer>();

		RestTemplate rt = new RestTemplate();
		Carer[] userArray = rt.getForObject(UrlsList.GET_BASE_URL
				+ UrlsList.GET_CARERS_URL, new Carer[0].getClass());
		carerList = Arrays.asList(userArray);

		return carerList;
	}

	public void postCarer(Carer carer, String shortUrl) throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(UrlsList.GET_BASE_URL + shortUrl, carer,
				Carer.class);
	}
}
