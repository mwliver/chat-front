package pl.edu.agh.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import pl.edu.agh.model.Carer;
import pl.edu.agh.model.Patient;
import pl.edu.agh.rest.CarerService;
import pl.edu.agh.rest.PatientService;
import pl.edu.agh.rest.UrlsList;

@Controller
@RequestMapping("/manage/patients")
public class ManagePatientsController {

	@Autowired
	private PatientService patientService;
	@Autowired
	private CarerService carerService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Carer.class, "carer",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String text) {
						setValue((text.equals("")) ? null : getCarerbyId(Integer.parseInt((String) text)));
					}
				});
	}

	@RequestMapping("/list")
	public String hello(Model model) {
		List<Patient> patientslist = patientService.getAll();

		model.addAttribute("patients", patientslist);
		return "listPatients";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String viewAddPatient(Model model) {
		System.out.println("w get");
		Patient patient = new Patient();
		model.addAttribute("patientForm", patient);
		model.addAttribute("carers", carerService.getAll());
		System.out.println("w get");

		return "addPatient";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePatient(@ModelAttribute("patientForm") Patient patient,
			Model model) {
		patient.setLastModification(new Date());
		patient.setUserRole("ROLE_PATIENT");
		try {
			patientService.postPatient(patient, UrlsList.GET_SAVE_PATIENT_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("info", "Dodano pacjenta");
		model.addAttribute("patientForm", new Patient());

		return "addPatient";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String savePatient(@RequestParam("id") long id, Model model) {

		List<Patient> patientslist = patientService.getAll();

		Patient patientToDelete = null;
		for (Patient patient : patientslist) {
			if (patient.getId() == id) {
				patientToDelete = patient;
				break;
			}
		}

		try {
			patientService.postPatient(patientToDelete,
					UrlsList.GET_REMOVE_PATIENT_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("info", "Usunięto pacjenta");
		patientslist = patientService.getAll();
		model.addAttribute("patients", patientslist);

		return "listPatients";

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getUpdatePatientView(@RequestParam("id") long id, Model model) {

		List<Patient> patientslist = patientService.getAll();
		for (Patient pat : patientslist)
			System.out.println(pat);
		System.out.println("After getting from service");
		System.out.println(patientslist);
		Patient patientToUpdate = null;
		for (Patient patient : patientslist) {
			System.out.println(patient);
			if (patient.getId() == id) {
				patientToUpdate = patient;
				break;
			}
		}

		model.addAttribute("patient", patientToUpdate);
		model.addAttribute("carers", carerService.getAll());

		return "editPatient";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePatient(@ModelAttribute("patient") Patient patient,
			Model model) {
		patient.setLastModification(new Date());
		patient.setUserRole("ROLE_PATIENT");
		try {
			patientService
					.postPatient(patient, UrlsList.GET_UPDATE_PATIENT_URL);

		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("info", "Zaktualizowano pacjenta");
		model.addAttribute("patient", patient);
		model.addAttribute("carers", carerService.getAll());

		return "editPatient";

	}
	
	public Carer getCarerbyId(long id) {
		List<Carer> carerslist = carerService.getAll();
		Carer endCarer = null;
		for (Carer carer : carerslist) {
			if (carer.getId() == id) {
				endCarer = carer;
				break;
			}
		}
		
		return endCarer;
		
	}

}
