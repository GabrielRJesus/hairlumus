package entidade;

import DAO.ClienteDAO;
import exception.DAOException;
import exception.EntidadeException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class Cliente extends Pessoa{
    private String cpf;
    private String rg;
    private Date dataNasc;
    private String sexo;

    public Cliente() {
    }

    public Cliente(String cpf, String rg, Date dataNasc, String sexo, Integer codigo, String nome, String endereco, String telefone, String celular) {
        super(codigo, nome, endereco, telefone, celular);
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
    }
    
    public Cliente(Integer codigo, String nome, String endereco, String telefone, String celular) {
        super(codigo,nome,endereco,telefone,celular);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public int insert(Connection con) throws EntidadeException{
        try{
            return new ClienteDAO().insert(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public int update(Connection con) throws EntidadeException{
        try{
            return new ClienteDAO().update(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public int delete(Connection con) throws EntidadeException{
        try{
            return new ClienteDAO().delete(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public Cliente select(Connection con) throws EntidadeException{
        try{
            return new ClienteDAO().select(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public List<Cliente>listacli(Connection con) throws EntidadeException{
        try{
            return new ClienteDAO().lista(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
}
