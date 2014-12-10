package pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Workers implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Worker> workers;

	public Workers() {
		this.workers = new ArrayList<>();
	}
	
	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public Workers(List<Worker> workers) {
		this.workers = workers;
	}
	
	public void addWorker(Worker worker) {
		workers.add(worker);
	}
	
	public void deleteWorker(Worker worker) {
		workers.remove(worker);
	}
	
	
}
