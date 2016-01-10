package pl.edu.agh.model;


public class GlobalSettings {

	private long id;
	private boolean active;
	private int reassignCarerTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getReassignCarerTime() {
		return reassignCarerTime;
	}

	public void setReassignCarerTime(int reassignCarerTime) {
		this.reassignCarerTime = reassignCarerTime;
	}

}
