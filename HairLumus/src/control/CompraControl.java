package control;


import entidade.Compra;
import entidade.Fornecedor;
import entidade.ItensCompra;
import entidade.Produto;
import exception.ControlException;
import exception.EntidadeException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sql.Banco;

public class CompraControl extends TemplateMethod{
    
    Banco conSing = Banco.getInstancia();
    Connection con = conSing.getConexao();
    
    private List<ItensCompra> listaitens = new ArrayList<>();

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
            ItensCompra ic = new ItensCompra();
            ic.setProd(listaprod.get(i));
            ic.setQtde(qtd);
            listaitens.add(ic);
        }
    }
    
    public int gravaCompra(int codigo, double valor, Date data, Fornecedor f){
        Compra comp = new Compra();
        comp.setCodigo(codigo);
        comp.setValor(valor);
        comp.setDataCompra(data);
        comp.setFornecedor(f);
        comp.setListaItens(listaitens);
//        try{
            //return comp.insert(con);
//        }catch(SQLException ex){
//            System.out.println(ex.getMessage());
//        }
        return 0;
    }
    
}
