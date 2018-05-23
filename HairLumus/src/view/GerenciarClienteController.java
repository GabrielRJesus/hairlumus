/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class GerenciarClienteController implements Initializable {

    @FXML
    private DatePicker dpDtNasc;
    @FXML
    private ComboBox<?> cbSexo;
    @FXML
    private Button btNovo;
    @FXML
    private Button btGravar;
    @FXML
    private Button btCancelar;
    @FXML
    private Button btBusca;
    @FXML
    private Button btExcluir;
    @FXML
    private Button btSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clkNovo(ActionEvent event) {
    }

    @FXML
    private void clkGravar(ActionEvent event) {
    }

    @FXML
    private void clkCancelar(ActionEvent event) {
    }

    @FXML
    private void clkBusca(ActionEvent event) {
    }

    @FXML
    private void clkExcluir(ActionEvent event) {
    }

    @FXML
    private void clkSair(ActionEvent event) {
        Stage stage = (Stage) btBusca.getScene().getWindow();
        stage.close();
    }
    
}
