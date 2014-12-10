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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {

	//private Clients clients;
	
	@FXML
	private TextField tfdLogin;
	@FXML
	private PasswordField tfdPassword;
	@FXML
	private Button btnEnter;
	@FXML
	private Button btnClear;
	@FXML
	private Button btnAddClient;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void clickEnter() throws ClassNotFoundException, IOException, ParseException {
		loadClient();
	}

	public void clickAddClient() {
		showOtherView("/AddClientView.fxml", "Add Client");
	}

	public void clickClear() {
		tfdLogin.clear();
		tfdPassword.clear();
	}

	public void saveClient() throws IOException {
		try {
			FileOutputStream fileStream = new FileOutputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/out.out");
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
			objectStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void loadClient() throws IOException, ClassNotFoundException, ParseException {
		try {
			FileInputStream fileStream = new FileInputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/out.out");
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);
			Clients clients = (Clients) objectStream.readObject();
			boolean flag = false;
			for (Client client : clients.getClients()) {
				if (tfdLogin.getText().equals(client.getLoginClient())
						&& tfdPassword.getText().equals(client.getPasswordClient())) {
					flag = true;
				}
			}
			
			if (flag == true) {
				System.out.println("PASSED: Client Found");
				showOtherView("/MenuView.fxml", "MENU");
			}
			else {
				System.out.println("ERROR: Client not Found");
			}
			objectStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void showOtherView(String viewPath, String titleText) {
		Stage plusStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource(viewPath));
			plusStage.setScene(new Scene(root));
			plusStage.initModality(Modality.APPLICATION_MODAL);
			plusStage.setTitle(titleText);
		} catch (IOException e) {
			e.getStackTrace();
		}
		plusStage.setResizable(false);
		plusStage.show();
	}
}
