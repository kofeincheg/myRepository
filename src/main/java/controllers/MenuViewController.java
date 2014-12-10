package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuViewController implements Initializable {
	@FXML
	private Button	btnAddView;
	@FXML
	private Button  btnEditDeleteView;
	@FXML
	private Button  btnShowAllRecordAndSearchView;
	
	
	public void clickAddView() {
		showOtherView("/AddWorkerView.fxml", "Add Worker");
	}
	
	public void clickEditDeleteView() {
		showOtherView("/EditDeleteView.fxml", "Edit/Delete Worker");
	}
	
	public void clickShow() {
		showOtherView("/ShowSearchView.fxml", "Search/Show All");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
