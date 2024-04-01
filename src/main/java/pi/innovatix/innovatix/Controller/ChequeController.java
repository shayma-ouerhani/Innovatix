package pi.innovatix.innovatix.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pi.innovatix.innovatix.entities.Cheque;
import pi.innovatix.innovatix.services.ServiceCheque;

import java.sql.SQLException;
import java.util.List;

public class ChequeController {

    @FXML
    private TableView<Cheque> tableView;

    @FXML
    private TableColumn<Cheque, Integer> ribColumn;

    @FXML
    private TableColumn<Cheque, Integer> cinColumn;

    @FXML
    private TableColumn<Cheque, String> nomPrenomColumn;

    @FXML
    private TableColumn<Cheque, String> emailColumn;

    @FXML
    private TableColumn<Cheque, String> dateColumn;

    @FXML
    private TableColumn<Cheque, String> beneficiaireColumn;

    @FXML
    private TableColumn<Cheque, Double> montantColumn;

    @FXML
    private TableColumn<Cheque, String> resultatColumn;

    private ServiceCheque serviceCheque;

    public ChequeController() {
        serviceCheque = new ServiceCheque();
    }

    @FXML
    public void initialize() {
        initializeTableView();
        afficherCheques();
    }

    private void initializeTableView() {
        ribColumn.setCellValueFactory(new PropertyValueFactory<>("rib"));
        cinColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));
        nomPrenomColumn.setCellValueFactory(new PropertyValueFactory<>("nomPrenom"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        beneficiaireColumn.setCellValueFactory(new PropertyValueFactory<>("beneficiaire"));
        montantColumn.setCellValueFactory(new PropertyValueFactory<>("montant"));
        resultatColumn.setCellValueFactory(new PropertyValueFactory<>("resultat"));
    }

    private void afficherCheques() {
        try {
            List<Cheque> cheques = serviceCheque.afficher();
            tableView.getItems().addAll(cheques);
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'exception appropriée
        }
    }

    // Méthodes pour ajouter, modifier et supprimer des chèques
    // Vous devrez implémenter ces méthodes en fonction de votre logique métier
}

