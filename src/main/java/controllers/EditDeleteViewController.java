package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

public class EditDeleteViewController implements Initializable {

	private ObservableList<Worker> workersData = FXCollections
			.observableArrayList();
	@FXML
	private TableView<Worker> tableWorkers;
	@FXML
	private TableColumn<Worker, Integer> id;
	@FXML
	private TableColumn<Worker, Integer> tab;
	@FXML
	private TableColumn<Worker, String> pib;
	@FXML
	private TableColumn<Worker, Integer> department;
	@FXML
	private TableColumn<Worker, String> post;
	@FXML
	private TableColumn<Worker, String> address;
	@FXML
	private TableColumn<Worker, Double> salary;
	@FXML
	private TableColumn<Worker, Integer> children;

	@FXML
	private TextField tfdId;
	@FXML
	private TextField tfdTabNumberWorker;
	@FXML
	private TextField tfdPibWorker;
	@FXML
	private TextField tfdDepartment;
	@FXML
	private TextField tfdPostWorker;
	@FXML
	private TextField tfdAddressWorker;
	@FXML
	private TextField tfdSalaryWorker;
	@FXML
	private TextField tfdChildrensWorker;

	@FXML
	private Button btnEdit;
	@FXML
	private Button btnDelete;

	public void clickEdit() throws IOException, ClassNotFoundException {
		try {
			// load records
			FileInputStream fileInputStream = new FileInputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/records.records");
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);
			Workers workers = (Workers) objectInputStream.readObject();
			for (Worker worker : workers.getWorkers()) {
				if (worker.getIdWorker() == Integer.parseInt(tfdId.getText())) {
					setFields(worker);
				}
			}
			FileOutputStream fileOutStream = new FileOutputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/records.records");
			ObjectOutputStream objectOutStream = new ObjectOutputStream(
					fileOutStream);
			objectInputStream.close();
			objectOutStream.writeObject(workers);
			objectOutStream.flush();
			objectOutStream.close();

			workersData.clear();

			updateTable();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void clickDelete() throws IOException, ClassNotFoundException {
		try {
			// load records
			FileInputStream fileInputStream = new FileInputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/records.records");
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);
			Workers workers = (Workers) objectInputStream.readObject();
			// delete this record
			for (int i = 0; i < workers.getWorkers().size(); i++) {
				if (workers.getWorkers().get(i).getIdWorker() == Integer
						.parseInt(tfdId.getText())) {
					System.out.println(i);
					workers.deleteWorker(workers.getWorkers().get(i));
				}
			}
			// save results
			FileOutputStream fileOutStream = new FileOutputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/records.records");
			ObjectOutputStream objectOutStream = new ObjectOutputStream(
					fileOutStream);
			objectInputStream.close();
			objectOutStream.writeObject(workers);
			objectOutStream.flush();
			objectOutStream.close();

			workersData.clear();

			updateTable();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void tableWorkersClick() {
		Worker worker = tableWorkers.getSelectionModel().getSelectedItem();
		tfdId.setText(worker.getIdWorker() + "");
		tfdTabNumberWorker.setText(worker.getTabNumberWorker() + "");
		tfdPibWorker.setText(worker.getPibWorker() + "");
		tfdDepartment.setText(worker.getNumberDepartment() + "");
		tfdPostWorker.setText(worker.getPostWorker() + "");
		tfdAddressWorker.setText(worker.getAddressWorker() + "");
		tfdSalaryWorker.setText(worker.getSalaryWorker() + "");
		tfdChildrensWorker.setText(worker.getQuantityWorker() + "");
		setButtonDisable(false);
	}

	public void setProperty() {
		id.setCellValueFactory(new PropertyValueFactory<Worker, Integer>(
				"idWorker"));
		tab.setCellValueFactory(new PropertyValueFactory<Worker, Integer>(
				"tabNumberWorker"));
		pib.setCellValueFactory(new PropertyValueFactory<Worker, String>(
				"pibWorker"));
		department
				.setCellValueFactory(new PropertyValueFactory<Worker, Integer>(
						"numberDepartment"));
		post.setCellValueFactory(new PropertyValueFactory<Worker, String>(
				"postWorker"));
		address.setCellValueFactory(new PropertyValueFactory<Worker, String>(
				"addressWorker"));
		salary.setCellValueFactory(new PropertyValueFactory<Worker, Double>(
				"salaryWorker"));
		children.setCellValueFactory(new PropertyValueFactory<Worker, Integer>(
				"quantityWorker"));
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

	private void setButtonDisable(boolean isDisable) {
		btnDelete.setDisable(isDisable);
		btnEdit.setDisable(isDisable);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateTable();
	}

	private void updateTable() {
		setButtonDisable(true);
		try {
			initAllData();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setProperty();
		tableWorkers.setItems(workersData);
	}

	private void setFields(Worker worker) {
		worker.setIdWorker(Integer.parseInt(tfdId.getText()));
		worker.setTabNumberWorker(Integer.parseInt(tfdTabNumberWorker.getText()));
		worker.setPibWorker(tfdPibWorker.getText());
		worker.setNumberDepartment(Integer.parseInt(tfdDepartment
				.getText()));
		worker.setPostWorker(tfdPostWorker.getText());
		worker.setAddressWorker(tfdAddressWorker.getText());
		worker.setSalaryWorker(Double.parseDouble(tfdSalaryWorker.getText()));
		worker.setQuantityWorker(Integer.parseInt(tfdChildrensWorker.getText()));
	}

}
