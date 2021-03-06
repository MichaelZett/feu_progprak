package hh.fernuni.rentamovie.rent.adapter;

import java.time.LocalDate;
import java.util.Optional;

import hh.fernuni.rentamovie.rent.application.RentService;
import hh.fernuni.rentamovie.rent.domain.Rent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RentOverviewController {
	private RentService rentService = RentService.getService();

	@FXML
	private TableView<Rent> rentTable;
	@FXML
	private TableColumn<Rent, String> customerColumn;
	@FXML
	private TableColumn<Rent, String> copyColumn;
	@FXML
	private TableColumn<Rent, LocalDate> startDateColumn;
	@FXML
	private TableColumn<Rent, LocalDate> endDateColumn;
	@FXML
	private Button newButton;

	@FXML
	private void initialize() {
		customerColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("customer.lastname"));
		copyColumn.setCellValueFactory(new PropertyValueFactory<Rent, String>("copy.movie.title"));
		startDateColumn.setCellValueFactory(new PropertyValueFactory<Rent, LocalDate>("startDate"));
		refreshCustomers();
	}

	private void refreshCustomers() {
		ObservableList<Rent> observableArrayList = FXCollections.observableArrayList();
		observableArrayList.setAll(rentService.readAllRents());
		rentTable.setItems(observableArrayList);
		rentTable.refresh();
	}

	@FXML
	private void handleNewRent() {
		System.out.println("Popup rent dialog");
		Dialog<Rent> dialog = new RentDialog();
		Optional<Rent> result = dialog.showAndWait();
	}

}