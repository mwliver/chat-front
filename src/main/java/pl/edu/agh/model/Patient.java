package pl.edu.agh.model;

public class Patient extends User {

	private Carer pernamentCarer;
	private String patientClassification;
	private String aliments;

	public Carer getPernamentCarer() {
		return pernamentCarer;
	}

	public void setPernamentCarer(Carer pernamentCarer) {
		this.pernamentCarer = pernamentCarer;
	}

	public String getPatientClassification() {
		return patientClassification;
	}

	public void setPatientClassification(String patientClassification) {
		this.patientClassification = patientClassification;
	}

	public String getAliments() {
		return aliments;
	}

	public void setAliments(String aliments) {
		this.aliments = aliments;
	}
}
