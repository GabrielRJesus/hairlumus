package entidade;

import DAO.FornecedorDAO;
import exception.DAOException;
import exception.EntidadeException;
import java.sql.Connection;
import java.util.List;

public class Fornecedor extends Pessoa{
    private String cnpj;
    private String ie;
    private String nomeResp;

    public Fornecedor(Integer codigo, String nome, String endereco, String telefone, String celular) {
        super(codigo, nome, endereco, telefone, celular);
    }

    public Fornecedor() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getNomeResp() {
        return nomeResp;
    }

    public void setNomeResp(String nomeResp) {
        this.nomeResp = nomeResp;
    }
    
    public int insert(Connection con) throws EntidadeException{
        try{
            return new FornecedorDAO().insert(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public int update(Connection con) throws EntidadeException{
        try{
            return new FornecedorDAO().update(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public int delete(Connection con) throws EntidadeException{
        try{
            return new FornecedorDAO().delete(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public Fornecedor select(Connection con) throws EntidadeException{
        try{
            return new FornecedorDAO().select(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public List<Fornecedor>listafor(Connection con) throws EntidadeException{
        try{
            return new FornecedorDAO().lista(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
}
