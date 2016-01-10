package pl.edu.agh.rest;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.agh.model.Patient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PatientService {

	public List<Patient> getAll() {

		List<Patient> patientList = new ArrayList<Patient>();

		RestTemplate rt = new RestTemplate();
		Patient[] userArray = rt.getForObject(UrlsList.GET_BASE_URL
				+ UrlsList.GET_PATIENTS_URL, new Patient[0].getClass());
		patientList = Arrays.asList(userArray);

		return patientList;
	}

	public void postPatient(Patient patient, String shortUrl)
			throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		Patient result = restTemplate.postForObject(UrlsList.GET_BASE_URL
				+ shortUrl, patient, Patient.class);
		System.out.println(result);
	}
}
