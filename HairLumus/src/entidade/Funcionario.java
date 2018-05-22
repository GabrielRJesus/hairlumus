package entidade;

import DAO.FuncionarioDAO;
import exception.DAOException;
import exception.EntidadeException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class Funcionario extends Cliente{
    private String login;
    private String senha;
    private String cargo;
    private double salario;
    private CalculaImposto CI;

    public Funcionario() {
        
    }

    public Funcionario(String cpf, String rg, Date dataNasc, String sexo, Integer codigo, String nome, String endereco, String telefone, String celular) {
        super(cpf, rg, dataNasc, sexo, codigo, nome, endereco, telefone, celular);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario, String cargo) {
        switch (cargo) {
        case "Funcionario":
                this.salario = calcularSalarioComImposto();
                break;
        case "Gerente":
                this.salario = calcularSalarioComImposto();
                break;
        default:
                throw new RuntimeException("Cargo não encontrado :/");
        }
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public double calcularSalarioComImposto() {
            return CI.calculaSalarioComImposto(this);
    }
    
    public int insertf(Connection con) throws EntidadeException{
        try{
            return new FuncionarioDAO().insert(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public int updatef(Connection con) throws EntidadeException{
        try{
            return new FuncionarioDAO().update(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public int deletef(Connection con) throws EntidadeException{
        try{
            return new FuncionarioDAO().delete(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public Funcionario selectf(Connection con) throws EntidadeException{
        try{
            return new FuncionarioDAO().select(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
    
    public List<Funcionario>listafun(Connection con) throws EntidadeException{
        try{
            return new FuncionarioDAO().lista(this, con);
        }catch(DAOException ex){
            throw new EntidadeException(ex.getMessage());
        }
    }
}
