/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import control.CompraControl;
import control.ProdutoControl;
import entidade.Compra;
import entidade.Fornecedor;
import entidade.ItensCompra;
import entidade.Produto;
import exception.ControlException;
import exception.EntidadeException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class TelaCompraController implements Initializable {

    @FXML
    private JFXTextField txtCodigo;
    @FXML
    private JFXComboBox<String> cbFornecedor;
    @FXML
    private JFXTextField txtProduto;
    @FXML
    private JFXButton btPesquisa;
    @FXML
    private JFXTextField txtQtde;
    @FXML
    private JFXButton btInsere;
    @FXML
    private JFXButton btRetira;
    @FXML
    private TableView<ItensCompra> tabProduto;
    @FXML
    private TableColumn colProduto;
    @FXML
    private TableColumn colQtde;
    @FXML
    private TableColumn colValorUnit;
    @FXML
    private JFXButton btGravar;
    @FXML
    private JFXTextField txtTotal;
    @FXML
    private JFXButton btSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clkPesquisa(ActionEvent event) {
    }

    @FXML
    private void clkInsere(ActionEvent event) throws ControlException, EntidadeException {
        CompraControl cc = new CompraControl();
        int qtd = Integer.parseInt(txtQtde.getText());
        cc.inserirProdutos(cc.buscarP(txtProduto.getText()), qtd);
        double soma = cc.soma();
        txtTotal.setText(soma+"");
    }

    @FXML
    private void clkRetira(ActionEvent event) {
    }

    @FXML
    private void clkGravar(ActionEvent event) throws EntidadeException {
        CompraControl cc = new CompraControl();
        Date data = new Date();
        cc.gravaCompra(Integer.parseInt(txtCodigo.getText()), Double.parseDouble(txtTotal.getText()), data, cc.selecionaFornecedor(cbFornecedor.getValue()));
    }

    @FXML
    private void clkSair(ActionEvent event) {
    }
    
}
