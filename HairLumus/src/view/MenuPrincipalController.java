package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


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
    private void clkCliente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/GerenciarCliente.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Gerenciar Cliente");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.showAndWait();
        stage.close();
    }

    @FXML
    private void clkFornecedor(ActionEvent event) {
    }

    @FXML
    private void clkFuncionario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/GerenciarFuncionario.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Gerenciar Funcionario");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.showAndWait();
        stage.close();
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
