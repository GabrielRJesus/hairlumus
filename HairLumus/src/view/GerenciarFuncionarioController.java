/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import control.PessoaControl;
import exception.ControlException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class GerenciarFuncionarioController implements Initializable {

    @FXML
    private DatePicker dpDtNasc;
    @FXML
    private ComboBox<String> cbSexo;
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
    @FXML
    private JFXTextField tvCodigo;
    @FXML
    private JFXTextField tvNome;
    @FXML
    private JFXTextField tvEndereco;
    @FXML
    private JFXTextField tvCPF;
    @FXML
    private JFXTextField tvRG;
    @FXML
    private JFXTextField tvTelefone;
    @FXML
    private JFXTextField tvCelular;
    @FXML
    private JFXTextField tvLogin;
    @FXML
    private JFXPasswordField tvSenha;
    @FXML
    private JFXTextField tvCargo;
    @FXML
    private JFXTextField tvSalario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializa(true);
        carregacb();
    }    

    @FXML
    private void clkNovo(ActionEvent event) {
        inicializa(false);
    }

    @FXML
    private void clkGravar(ActionEvent event) {
        PessoaControl pc = new PessoaControl();
        Date data = java.sql.Date.valueOf(dpDtNasc.getValue());
        int codigo = Integer.parseInt(tvCodigo.getText().toString());
        try{
            int n = pc.gravarFuncionario(codigo, tvNome.getText().toString(), tvEndereco.getText().toString(), 
                                     tvTelefone.getText().toString(), tvCelular.getText().toString(), 
                                     tvCPF.getText().toString(), tvRG.getText().toString(), data, cbSexo.getValue(),
                                     tvLogin.getText().toString(), tvSenha.getText().toString(), tvCargo.getText().toString(),
                                     Double.parseDouble(tvSalario.getText().toString()));
            if(n>0){
                System.out.println("Inserido com Sucesso");
                clkCancelar(event);
            }else{
                System.out.println("Erro na hora de inserir!");
            }
        }catch(ControlException ex){
            System.out.println("Erro na inserção");
        }
    }

    @FXML
    private void clkCancelar(ActionEvent event) {
        limpatela();
        inicializa(true);
    }

    @FXML
    private void clkBusca(ActionEvent event) {
    }

    @FXML
    private void clkExcluir(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MenuPrincipal.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) btSair.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Menu Principal");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.showAndWait();
        stage.close();
    }

    @FXML
    private void clkSair(ActionEvent event) {
    }
    
    public void inicializa(boolean estado){
        tvNome.setDisable(estado);
        tvEndereco.setDisable(estado);
        tvTelefone.setDisable(estado);
        tvCelular.setDisable(estado);
        tvCPF.setDisable(estado);
        tvRG.setDisable(estado);
        btExcluir.setDisable(estado);
        btGravar.setDisable(estado);
        btCancelar.setDisable(estado);
        tvLogin.setDisable(estado);
        tvSenha.setDisable(estado);
        tvCargo.setDisable(estado);
        tvSalario.setDisable(estado);
    }
    
    public void carregacb(){
        List<String> lista = new ArrayList<>();
        lista.add("M");
        lista.add("F");
        ObservableList<String> colection = FXCollections.observableArrayList(lista);
        cbSexo.getItems().addAll(colection);
    }
    
    public void limpatela(){
        tvNome.setText("");
        tvEndereco.setText("");
        tvTelefone.setText("");
        tvCelular.setText("");
        tvCPF.setText("");
        tvRG.setText("");
        dpDtNasc.setValue(LocalDate.now());
        tvLogin.setText("");
        tvSenha.setText("");
        tvCargo.setText("");
        tvSalario.setText("");
    }
    
}
