package pojo;

import java.io.Serializable;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idClient;
	private String loginClient;
	private String passwordClient;

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getLoginClient() {
		return loginClient;
	}

	public void setLoginClient(String loginClient) {
		this.loginClient = loginClient;
	}

	public String getPasswordClient() {
		return passwordClient;
	}

	public void setPasswordClient(String passwordClient) {
		this.passwordClient = passwordClient;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", loginClient=" + loginClient
				+ ", passwordClient=" + passwordClient + "]";
	}

	

	
	
}
