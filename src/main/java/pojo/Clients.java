package pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clients implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Client> clients ;

	public Clients() {
		this.clients = new ArrayList<>();
	}
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Clients(List<Client> clients) {
		this.clients = clients;
	}
	
	public void addClient(Client client) {
		clients.add(client);
	}

}
