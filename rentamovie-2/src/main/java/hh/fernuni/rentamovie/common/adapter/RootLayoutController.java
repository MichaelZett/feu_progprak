package hh.fernuni.rentamovie.common.adapter;

import hh.fernuni.rentamovie.main.RentAMovie;
import javafx.fxml.FXML;

public class RootLayoutController {

	// Reference to the main application
	private RentAMovie mainApp;

	public void setMainApp(RentAMovie mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	public void navigateToMovies() {
		mainApp.navigateToMovies();
	}

	@FXML
	public void navigateToUsers() {
		mainApp.navigateToCustomers();
	}

	@FXML
	public void navigateToRent() {
		mainApp.navigateToRent();
	}

}