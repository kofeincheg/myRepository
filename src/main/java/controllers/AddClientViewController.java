package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import pojo.Client;
import pojo.Clients;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class AddClientViewController implements Initializable {

	private int sizeFile;

	@FXML
	private TextField tfdLogin;
	@FXML
	private PasswordField tfdPassword;
	@FXML
	private PasswordField tfdPasswordRepeat;
	@FXML
	private Button btnAdd;

	public void clickAdd() {
		try {
			addNewClient();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tfdLogin.clear();
		tfdPassword.clear();
		tfdPasswordRepeat.clear();
	}

	public void addNewClient() throws ParseException, IOException,
			ClassNotFoundException {
		load();
		try {
			// load clients
			FileInputStream fileInputStream = new FileInputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/out.out");
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);
			Clients clients = (Clients) objectInputStream.readObject();
			// add new client
			clients.addClient(addClientTemp());
			// save new client
			FileOutputStream fileOutStream = new FileOutputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/out.out");
			ObjectOutputStream objectOutStream = new ObjectOutputStream(
					fileOutStream);
		//	Clients clients = new Clients();
		//	clients.addClient(addClientTemp());
			System.out.println("Added:" + addClientTemp().toString());
			// System.out.println(clients.getClients().toString());
			objectInputStream.close();
			objectOutStream.writeObject(clients);
			objectOutStream.flush();
			objectOutStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Client addClientTemp() throws ParseException {
		Client client = new Client();
		client.setIdClient(sizeFile);
		client.setLoginClient(tfdLogin.getText());
		client.setPasswordClient(tfdPassword.getText());
		return client;
	}

	public void load() throws IOException, ClassNotFoundException,
			ParseException {
		try {
			FileInputStream fileStream = new FileInputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/out.out");
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);
			Clients clients = (Clients) objectStream.readObject();
			System.out.println(clients.getClients().size());
			sizeFile = clients.getClients()
					.get(clients.getClients().size() - 1).getIdClient() + 1;
			objectStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sizeFile = 0;
	}

}
