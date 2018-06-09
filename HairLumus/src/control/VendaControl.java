package control;

import entidade.*;
import exception.ControlException;
import exception.EntidadeException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.Banco;

public class VendaControl extends TemplateMethod{

    Banco conSing = Banco.getInstancia();
    Connection con = conSing.getConexao();
    
    private List<ItensVenda> listaitens = new ArrayList<>();

    public List<Cliente> preenchelistaclientes() throws ControlException, EntidadeException {
        List<Cliente> listaclientes = new ArrayList<>();
        Cliente c = new Cliente();
        try {
            listaclientes = c.listacli(con);
            return listaclientes;
        } catch (EntidadeException ex) {
            throw new ControlException(ex.getMessage());
        }
    }

    public List<Produto> preenchelistaprodutos() throws ControlException {
        List<Produto> listaprodutos = new ArrayList<>();
        Produto p = new Produto();
        try {
            List<Produto> listap = p.lista(con);
            if (listap != null) {
                for (int i = 0; i < listap.size(); i++) {
                    listaprodutos.add(listap.get(i));
                }
                return listaprodutos;
            }
        } catch (EntidadeException ex) {
            throw new ControlException(ex.getMessage());
        }
        return listaprodutos;
    }
    
    @Override
    void inserirProdutos(List<Produto> listaprod, int qtd) {
        for (int i = 0; i < listaprod.size(); i++) {
            ItensVenda iv = new ItensVenda();
            iv.setProduto(listaprod.get(i));
            iv.setQtd(qtd);
            listaitens.add(iv);
        }
    }
    
    public int gravaVenda(int codigo, double valor, Date data, Cliente c, Pessoa p){
        Venda v = new Venda();
        v.setCodigo(codigo);
        v.setValor(valor);
        v.setData(data);
        v.setCliente(c);
        v.setLista(listaitens);
//        try{
            //return v.insert(con);
//        }catch(SQLException ex){
//            System.out.println(ex.getMessage());
//        }
        return 0;
    }
    
}
