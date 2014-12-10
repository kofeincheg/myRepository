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

import pojo.Worker;
import pojo.Workers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddWorkerViewController implements Initializable {

	private int sizeFile;

	@FXML
	private TextField tfdTabNumberWorker;
	@FXML
	private TextField tfdPibWorker;
	@FXML
	private TextField tfdNumberDepartmentWorker;
	@FXML
	private TextField tfdPostWorker;
	@FXML
	private TextField tfdAddressWorker;
	@FXML
	private TextField tfdSalaryWorker;
	@FXML
	private TextField tfdChildrensWorker;

	@FXML
	private Button btnAddWorker;

	public void clickAddWorker() throws IOException, ParseException,
			ClassNotFoundException {
		createWorker();
		//createWorkerFault();
		clearAllFields();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void createWorker() throws IOException, ParseException, ClassNotFoundException {
		load();
		try {
			// load records
			FileInputStream fileInputStream = new FileInputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/records.records");
			ObjectInputStream objectInputStream = new ObjectInputStream(
					fileInputStream);
			Workers workers = (Workers) objectInputStream.readObject();
			// add new record
			workers.addWorker(addWorkerTemp());
			// save new record
			FileOutputStream fileOutStream = new FileOutputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/records.records");
			ObjectOutputStream objectOutStream = new ObjectOutputStream(
					fileOutStream);
			//Workers workers = new Workers();
			//workers.addWorker(addWorkerTemp());
			System.out.println("Added:" + addWorkerTemp().toString());
			System.out.println(workers.getWorkers().toString());
			objectInputStream.close();
			objectOutStream.writeObject(workers);
			objectOutStream.flush();
			objectOutStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void createWorkerFault() throws IOException, ParseException, ClassNotFoundException {
		try {
			FileOutputStream fileOutStream = new FileOutputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/records.records");
			ObjectOutputStream objectOutStream = new ObjectOutputStream(
					fileOutStream);
			Workers workers = new Workers();
			workers.addWorker(addWorkerTemp());
			System.out.println("Added:" + addWorkerTemp().toString());
			System.out.println(workers.getWorkers().toString());
			objectOutStream.writeObject(workers);
			objectOutStream.flush();
			objectOutStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Worker addWorkerTemp() throws ParseException {
		Worker worker = new Worker();
		worker.setIdWorker(sizeFile);
		worker.setTabNumberWorker(Integer.parseInt(tfdTabNumberWorker.getText()));
		worker.setPibWorker(tfdPibWorker.getText());
		worker.setNumberDepartment(Integer.parseInt(tfdNumberDepartmentWorker.getText()));
		worker.setPostWorker(tfdPostWorker.getText());
		worker.setAddressWorker(tfdAddressWorker.getText());
		worker.setSalaryWorker(Double.parseDouble(tfdSalaryWorker.getText()));
		worker.setQuantityWorker(Integer.parseInt(tfdChildrensWorker.getText()));
		return worker;
	}

	public void load() throws IOException, ClassNotFoundException,
			ParseException {
		try {
			FileInputStream fileStream = new FileInputStream(
					"/home/anchous/workspace/ProjectPraktikum3AndXML/src/main/resources/records.records");
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);
			Workers workers = (Workers) objectStream.readObject();
			System.out.println(workers.getWorkers().size());
			sizeFile = workers.getWorkers()
					.get(workers.getWorkers().size() - 1).getIdWorker() + 1;
			objectStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void clearAllFields() {
			tfdTabNumberWorker.clear();
			tfdPibWorker.clear();
			tfdAddressWorker.clear();
			tfdChildrensWorker.clear();
			tfdNumberDepartmentWorker.clear();
			tfdPostWorker.clear();
			tfdSalaryWorker.clear();
	}
}
