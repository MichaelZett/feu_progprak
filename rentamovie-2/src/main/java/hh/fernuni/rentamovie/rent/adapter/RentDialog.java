package hh.fernuni.rentamovie.rent.adapter;

import java.time.LocalDate;

import hh.fernuni.rentamovie.customer.application.CustomerService;
import hh.fernuni.rentamovie.customer.domain.Customer;
import hh.fernuni.rentamovie.movie.application.MovieService;
import hh.fernuni.rentamovie.movie.domain.Copy;
import hh.fernuni.rentamovie.movie.domain.Movie;
import hh.fernuni.rentamovie.rent.application.RentService;
import hh.fernuni.rentamovie.rent.domain.Rent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class RentDialog extends Dialog<Rent> {
	private Label customerLabel = new Label("Customer: ");
	private Label movieLabel = new Label("Movie: ");
	private GridPane grid = new GridPane();
	private ComboBox<Customer> customerBox;
	private ComboBox<Movie> movieBox;

	private CustomerService customerService = CustomerService.getService();
	private MovieService movieService = MovieService.getService();
	private RentService rentService = RentService.getService();

	RentDialog() {
		this.setTitle("Input rent");
		ObservableList<Customer> customerOptions = FXCollections
				.observableArrayList(customerService.readAllCustomers());
		customerBox = new ComboBox<Customer>(customerOptions);
		ObservableList<Movie> movieOptions = FXCollections.observableArrayList(movieService.readAllMovies());
		movieBox = new ComboBox<Movie>(movieOptions);

		grid.add(customerLabel, 1, 1);
		grid.add(customerBox, 2, 1);
		grid.add(movieLabel, 1, 2);
		grid.add(movieBox, 2, 2);
		this.getDialogPane().setContent(grid);

		ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().add(buttonTypeOk);
		this.setResultConverter(b -> {
			Movie movie = movieBox.getValue();
			Copy freeCopy = rentService.findAllFreeCopies(movie).iterator().next();
			return new Rent(customerBox.getValue(), freeCopy, LocalDate.now());
		});
	}

}
