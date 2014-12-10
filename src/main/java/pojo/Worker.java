package pojo;

import java.io.Serializable;

public class Worker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idWorker;
	private int tabNumberWorker;
	private String pibWorker;
	private int numberDepartment;
	private String postWorker;
	private String addressWorker;
	private double salaryWorker;
	private int quantityWorker;

	public Worker(int idWorker, int tabNumberWorker, String pibWorker,
			int numberDepartment, String postWorker, String addressWorker,
			double salaryWorker, int quantityWorker) {
		this.idWorker = idWorker;
		this.tabNumberWorker = tabNumberWorker;
		this.pibWorker = pibWorker;
		this.numberDepartment = numberDepartment;
		this.postWorker = postWorker;
		this.addressWorker = addressWorker;
		this.salaryWorker = salaryWorker;
		this.quantityWorker = quantityWorker;
	}

	public Worker() {

	}

	public int getIdWorker() {
		return idWorker;
	}

	public void setIdWorker(int idWorker) {
		this.idWorker = idWorker;
	}

	public int getTabNumberWorker() {
		return tabNumberWorker;
	}

	public void setTabNumberWorker(int tabNumberWorker) {
		this.tabNumberWorker = tabNumberWorker;
	}

	public String getPibWorker() {
		return pibWorker;
	}

	public void setPibWorker(String pibWorker) {
		this.pibWorker = pibWorker;
	}

	public int getNumberDepartment() {
		return numberDepartment;
	}

	public void setNumberDepartment(int numberDepartment) {
		this.numberDepartment = numberDepartment;
	}

	public String getPostWorker() {
		return postWorker;
	}

	public void setPostWorker(String postWorker) {
		this.postWorker = postWorker;
	}

	public String getAddressWorker() {
		return addressWorker;
	}

	public void setAddressWorker(String addressWorker) {
		this.addressWorker = addressWorker;
	}

	public double getSalaryWorker() {
		return salaryWorker;
	}

	public void setSalaryWorker(double salaryWorker) {
		this.salaryWorker = salaryWorker;
	}

	public int getQuantityWorker() {
		return quantityWorker;
	}

	public void setQuantityWorker(int quantityWorker) {
		this.quantityWorker = quantityWorker;
	}

	@Override
	public String toString() {
		return "Worker [idWorker=" + idWorker + ", tabNumberWorker="
				+ tabNumberWorker + ", pibWorker=" + pibWorker
				+ ", numberDepartment=" + numberDepartment + ", postWorker="
				+ postWorker + ", addressWorker=" + addressWorker
				+ ", salaryWorker=" + salaryWorker + ", quantityWorker="
				+ quantityWorker + "]";
	}

}
