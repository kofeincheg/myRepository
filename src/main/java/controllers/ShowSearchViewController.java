package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import pojo.Worker;
import pojo.Workers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowSearchViewController implements Initializable {
	
	private ObservableList<Worker> workersData = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Worker> listView;
	@FXML
	private TableColumn<Worker, Integer> tcId;
	@FXML
	private TableColumn<Worker, Integer> tcTabNumber;
	@FXML
	private TableColumn<Worker, String>  tcPib;
	@FXML
	private TableColumn<Worker, Integer> tcDepartment;
	@FXML
	private TableColumn<Worker, String>  tcPost;
	@FXML
	private TableColumn<Worker, String>  tcAddress;
	@FXML
	private TableColumn<Worker, Double>  tcSalary;
	@FXML
	private TableColumn<Worker, Integer> tcChildren;
	
	@FXML 
	private TextField tfdSearch;
	
	@FXML
	private Button btnSearch;
	@FXML
	private Button btnShowAll;
	
	public void clickSearch() throws ClassNotFoundException, IOException {
		workersData.clear();
		searchData();
		setProperty();
		listView.setItems(workersData);
	}
	
	public void clickShowAll() throws ClassNotFoundException, IOException {
		workersData.clear();
		initAllData();
		setProperty();
		listView.setItems(workersData);
	}
	
	private void initAllData() throws IOException, ClassNotFoundException {
		try {
			// load records
			FileInputStream fileInputStream = new FileInputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/records.records");
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);
			Workers workers = (Workers) objectInputStream.readObject();
			for (Worker worker : workers.getWorkers()) {
				workersData.add(worker);
			}
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	private void searchData() throws IOException, ClassNotFoundException {
		try {
			// load records
			FileInputStream fileInputStream = new FileInputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/records.records");
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);
			Workers workers = (Workers) objectInputStream.readObject();
			for (Worker worker : workers.getWorkers()) {
				if (String.valueOf(worker.getTabNumberWorker()).contains(tfdSearch.getText())){
					workersData.add(worker);
				}
			}
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		try {
			initAllData();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setProperty();
        listView.setItems(workersData);
	}
	
	public void setProperty() {
		tcId.setCellValueFactory(new PropertyValueFactory<Worker, Integer>("idWorker"));
        tcTabNumber.setCellValueFactory(new PropertyValueFactory<Worker, Integer>("tabNumberWorker"));
        tcPib.setCellValueFactory(new PropertyValueFactory<Worker, String>("pibWorker"));
        tcDepartment.setCellValueFactory(new PropertyValueFactory<Worker, Integer>("numberDepartment"));
        tcPost.setCellValueFactory(new PropertyValueFactory<Worker, String>("postWorker"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<Worker, String>("addressWorker"));
        tcSalary.setCellValueFactory(new PropertyValueFactory<Worker, Double>("salaryWorker"));
        tcChildren.setCellValueFactory(new PropertyValueFactory<Worker, Integer>("quantityWorker"));
	}

}
