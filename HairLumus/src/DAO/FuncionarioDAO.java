package DAO;

import entidade.Funcionario;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements GenericDAO<Funcionario>{
    
    private String insertfu= "insert into funcionario(fun_login, fun_senha, fun_cargo, fun_salario, cli_cpf, pes_codigo) values(?,?,?,?,?,?)";
    private String updatefu= "update funcionario set fun_login = ?, fun_senha = ?, fun_cargo = ?, fun_salario = ? where pes_codigo = ? and cli_cpf = ?";
    private String deletefu= "delete from funcionario where pes_codigo = ? and cli_cpf = ?";
    private String selectfu= "select * from pessoa p inner join cliente c on p.pes_codigo = c.pes_codigo inner join funcionario f on c.cli_cpf = f.cli_cpf";
    
    @Override
    public int insert(Funcionario obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(insertfu);
                ps.setString(++cont, obj.getLogin());
                ps.setString(++cont, obj.getSenha());
                ps.setString(++cont, obj.getCargo());
                ps.setDouble(++cont, obj.getSalario());
                ps.setString(++cont, obj.getCpf());
                ps.setInt(++cont, obj.getCodigo());
                return ps.executeUpdate();
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão");
        }
    }

    @Override
    public int update(Funcionario obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(updatefu);
                ps.setString(++cont, obj.getLogin());
                ps.setString(++cont, obj.getSenha());
                ps.setString(++cont, obj.getCargo());
                ps.setDouble(++cont, obj.getSalario());
                ps.setInt(++cont, obj.getCodigo());
                ps.setString(++cont, obj.getCpf());
                return ps.executeUpdate();
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão");
        }
    }

    @Override
    public int delete(Funcionario obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(deletefu);
                ps.setInt(++cont, obj.getCodigo());
                ps.setString(++cont, obj.getCpf());
                return ps.executeUpdate();
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão");
        }
    }

    @Override
    public Funcionario select(Funcionario obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean ultimo = false;
        int cont = 0;
        if(con!=null){
            
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                selectfu+= " where pes_codigo = ?";
                ultimo = true;
            }
            
            if(obj!=null && obj.getCpf()!=null && !obj.getCpf().isEmpty()){
                if(ultimo)
                    selectfu+=" and cli_cpf = ?";
                else{
                    selectfu+= " where cli_cpf = ?";
                    ultimo = true;
                }
            }
            
            if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty()){
                if(ultimo)
                    selectfu+=" and pes_nome like ?";
                else{
                    selectfu+= " where pes_nome like ?";
                    ultimo = true;
                }
            }
            
            if(obj!=null && obj.getLogin()!=null && !obj.getLogin().isEmpty()){
                if(ultimo)
                    selectfu+=" and fun_login = ?";
                else{
                    selectfu+= " where fun_login = ?";
                }
            }
            
            try{
                ps = con.prepareStatement(updatefu);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getCpf()!=null && !obj.getCpf().isEmpty())
                    ps.setString(++cont, obj.getCpf());
                if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty())
                    ps.setString(++cont, "%"+obj.getNome()+"%");
                if(obj!=null && obj.getLogin()!=null && !obj.getLogin().isEmpty())
                    ps.setString(++cont, obj.getLogin());
                rs = ps.executeQuery();
                
                if(rs.next()){
                    Funcionario f = new Funcionario();
                    f.setCodigo(rs.getInt("pes_codigo"));
                    f.setNome(rs.getString("pes_nome"));
                    f.setEndereco(rs.getString("pes_endereco"));
                    f.setTelefone(rs.getString("pes_telefone"));
                    f.setCelular(rs.getString("pes_celular"));
                    f.setCpf(rs.getString("cli_cpf"));
                    f.setRg(rs.getString("cli_rg"));
                    f.setDataNasc(rs.getDate("cli_dtNasc"));
                    f.setSexo(rs.getString("cli_sexo"));
                    f.setLogin(rs.getString("fun_login"));
                    f.setSenha(rs.getString("fun_senha"));
                    f.setCargo(rs.getString("fun_cargo"));
                    f.setSalario(rs.getDouble("fun_salario"));
                    return f;
                }
                
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão");
        }
        return null;
    }
    
    public List<Funcionario> lista(Funcionario obj, Connection con) throws DAOException {
        List<Funcionario> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean ultimo = false;
        int cont = 0;
        if(con!=null){
            
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                selectfu+= " where pes_codigo = ?";
                ultimo = true;
            }
            
            if(obj!=null && obj.getCpf()!=null && !obj.getCpf().isEmpty()){
                if(ultimo)
                    selectfu+=" and cli_cpf = ?";
                else{
                    selectfu+= " where cli_cpf = ?";
                    ultimo = true;
                }
            }
            
            if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty()){
                if(ultimo)
                    selectfu+=" and pes_nome like ?";
                else{
                    selectfu+= " where pes_nome like ?";
                    ultimo = true;
                }
            }
            
            if(obj!=null && obj.getLogin()!=null && !obj.getLogin().isEmpty()){
                if(ultimo)
                    selectfu+=" and fun_login = ?";
                else{
                    selectfu+= " where fun_login = ?";
                }
            }
            
            try{
                ps = con.prepareStatement(updatefu);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getCpf()!=null && !obj.getCpf().isEmpty())
                    ps.setString(++cont, obj.getCpf());
                if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty())
                    ps.setString(++cont, "%"+obj.getNome()+"%");
                if(obj!=null && obj.getLogin()!=null && !obj.getLogin().isEmpty())
                    ps.setString(++cont, obj.getLogin());
                rs = ps.executeQuery();
                
                while(rs.next()){
                    Funcionario f = new Funcionario();
                    f.setCodigo(rs.getInt("pes_codigo"));
                    f.setNome(rs.getString("pes_nome"));
                    f.setEndereco(rs.getString("pes_endereco"));
                    f.setTelefone(rs.getString("pes_telefone"));
                    f.setCelular(rs.getString("pes_celular"));
                    f.setCpf(rs.getString("cli_cpf"));
                    f.setRg(rs.getString("cli_rg"));
                    f.setDataNasc(rs.getDate("cli_dtNasc"));
                    f.setSexo(rs.getString("cli_sexo"));
                    f.setLogin(rs.getString("fun_login"));
                    f.setSenha(rs.getString("fun_senha"));
                    f.setCargo(rs.getString("fun_cargo"));
                    f.setSalario(rs.getDouble("fun_salario"));
                    lista.add(f);
                }
                return lista;
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão");
        }
    }
    
}
