package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class MenuPrincipalController implements Initializable {

    @FXML
    private MenuItem menuCliente;
    @FXML
    private MenuItem menuFornecedor;
    @FXML
    private MenuItem menuFuncionario;
    @FXML
    private MenuItem menuProduto;
    @FXML
    private MenuItem menuMarca;
    @FXML
    private MenuItem menuVenda;
    @FXML
    private MenuItem menuCompra;
    @FXML
    private MenuItem menuSair;
    @FXML
    private MenuBar menuBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clkCliente(ActionEvent event) {
    }

    @FXML
    private void clkFornecedor(ActionEvent event) {
    }

    @FXML
    private void clkFuncionario(ActionEvent event) {
    }

    @FXML
    private void clkProduto(ActionEvent event) {
    }

    @FXML
    private void clkMarca(ActionEvent event) {
    }

    @FXML
    private void clkSair(ActionEvent event) {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clkVenda(ActionEvent event) {
    }

    @FXML
    private void clkCompra(ActionEvent event) {
    }
    
}
