package control;

import entidade.*;
import exception.ControlException;
import exception.EntidadeException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sql.Banco;


public class ProdutoControl {
    
    Banco conSing = Banco.getInstancia();
    Connection con = conSing.getConexao();
    
    
    public List<String> validaCampos(String codigo,String descr,String tamanho,String qtde,String cor,String preco){
        List<String> listaerros = new ArrayList<>();
        if(codigo!=null && !codigo.isEmpty()){
            try{
                int cod = Integer.parseInt(codigo);
            }catch(Exception ex){
                listaerros.add("Erro no codigo");
            }
        }
        
        if(descr==null || descr.isEmpty()){
            listaerros.add("Insira a descrição do produto!");
        }
        
        if(tamanho.equalsIgnoreCase("Tamanho") || tamanho.isEmpty() || tamanho==null){
            listaerros.add("Selecione um tamanho");
        }
        
        try{
            int qtd = Integer.parseInt(qtde);
        }catch(Exception ex){
            listaerros.add("Digite uma quantidade válida!");
        }
        
        if(cor==null || cor.isEmpty()){
            listaerros.add("Insira a cor do produto!");
        }
        
        
        try{
            double val = Double.parseDouble(preco);
        }catch(Exception ex){
            listaerros.add("Erro ao inserir preço!");
        }
        
        return listaerros;
    }
    
    
    public int gravar(String codigo,String descr,String preco,int est, int estMin , Marca marca) throws ControlException, SQLException{
        List<String> listaerros = new ArrayList<>();
        if(codigo!=null && !codigo.isEmpty()){
            try{
                int cod = Integer.parseInt(codigo);
            }catch(Exception ex){
                listaerros.add("Erro no codigo");
            }
        }
        try{
            double val = Double.parseDouble(preco);
        }catch(Exception ex){
            listaerros.add("Erro ao inserir preço!");
        }
        
        if(listaerros.isEmpty()){
            Produto p = new Produto();
            p.setCodigo(Integer.parseInt(codigo));
            p.setDescricao(descr);
            p.setPreco(Double.parseDouble(preco));
            p.setEstMin(estMin);
            p.setEstoque(est);
            p.setMarca(marca);
            try{
                
                con.setAutoCommit(false);
                    p.insert(con);
                con.commit();
                return 1;
            }catch(EntidadeException ex){
                throw new ControlException(ex.getMessage());
            } catch (SQLException ex) {
                con.rollback();
                throw new ControlException(ex.getMessage());
            }
        }else{
            return 0;
        }
    }
    
    public Produto buscar(String codigo, String descr) throws ControlException{
        if(codigo!=null && !codigo.isEmpty()){
            try{
                int cod = Integer.parseInt(codigo);
            }catch(Exception ex){
                throw new ControlException(ex.getMessage());
            }
        }
        try{
            Produto p = new Produto();
            p.setCodigo(Integer.parseInt(codigo));
            p.setDescricao(descr);
            return  p.select(con);
        } catch (EntidadeException ex) {
             throw new ControlException(ex.getMessage());
        }
    }
}
