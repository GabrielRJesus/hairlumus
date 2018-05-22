package DAO;

import entidade.Cliente;
import entidade.Pessoa;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements GenericDAO<Cliente>{
    
    private String insertc = "insert into cliente(cli_cpf, cli_rg, cli_dtNasc, cli_sexo,pes_codigo) values(?,?,?,?,?)";
    private String updatec = "update cliente set cli_rg = ?, cli_dtNasc = ?, cli_sexo = ? where pes_codigo =? and cli_cpf = ?";
    private String deletec = "delete from cliente where pes_codigo = ? and cli_cpf = ?";
    private String selectc = "select * from pessoa p inner join cliente c on p.pes_codigo=c.pes_codigo";
    
    @Override
    public int insert(Cliente obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(insertc);
                ps.setString(++cont, obj.getCpf());
                ps.setString(++cont, obj.getRg());
                ps.setDate(++cont, new java.sql.Date(obj.getDataNasc().getTime()));
                ps.setString(++cont, obj.getSexo());
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
    public int update(Cliente obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(updatec);
                ps.setString(++cont, obj.getRg());
                ps.setDate(++cont, new java.sql.Date(obj.getDataNasc().getTime()));
                ps.setString(++cont, obj.getSexo());
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
    public int delete(Cliente obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(deletec);
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
    public Cliente select(Cliente obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cont = 0;
        boolean ultimo = false;
        if(con!=null){
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                selectc+=" where pes_codigo = ?";
                ultimo = true;
            }
            
            if(obj!=null && obj.getCpf()!=null && !obj.getCpf().isEmpty()){
                if(ultimo){
                    selectc+=" and cli_cpf = ?";
                }else{
                    selectc+=" where cli_cpf = ?";
                    ultimo = true;
                }
            }

            if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty()){
                if(ultimo){
                    selectc+=" and pes_nome like ?";
                }else{
                    selectc+=" where pes_nome like ?";
                }
            }
            try{
                ps = con.prepareStatement(selectc);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getCpf()!=null && !obj.getCpf().isEmpty())
                    ps.setString(++cont, obj.getCpf());
                if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty())
                    ps.setString(++cont, obj.getNome());
                rs = ps.executeQuery();
                if(rs.next()){
                    Cliente c = new Cliente();
                    c.setCodigo(rs.getInt("pes_codigo"));
                    c.setNome(rs.getString("pes_nome"));
                    c.setEndereco(rs.getString("pes_endereco"));
                    c.setTelefone(rs.getString("pes_telefone"));
                    c.setCelular(rs.getString("pes_celular"));
                    c.setCpf(rs.getString("cli_cpf"));
                    c.setRg(rs.getString("cli_rg"));
                    c.setDataNasc(rs.getDate("cli_dtNasc"));
                    c.setSexo(rs.getString("cli_sexo"));
                    return c;
                }
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão");
        }
        return null;
    }
    
    public List<Cliente> lista(Cliente obj, Connection con) throws DAOException {
        List<Cliente> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cont = 0;
        boolean ultimo = false;
        if(con!=null){
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                selectc+=" where pes_codigo = ?";
                ultimo = true;
            }
            
            if(obj!=null && obj.getCpf()!=null && !obj.getCpf().isEmpty()){
                if(ultimo){
                    selectc+=" and cli_cpf = ?";
                }else{
                    selectc+=" where cli_cpf = ?";
                    ultimo = true;
                }
            }

            if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty()){
                if(ultimo){
                    selectc+=" and pes_nome like ?";
                }else{
                    selectc+=" where pes_nome like ?";
                }
            }
            try{
                ps = con.prepareStatement(selectc);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getCpf()!=null && !obj.getCpf().isEmpty())
                    ps.setString(++cont, obj.getCpf());
                if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty())
                    ps.setString(++cont, obj.getNome());
                rs = ps.executeQuery();
                while(rs.next()){
                    Cliente c = new Cliente();
                    c.setCodigo(rs.getInt("pes_codigo"));
                    c.setNome(rs.getString("pes_nome"));
                    c.setEndereco(rs.getString("pes_endereco"));
                    c.setTelefone(rs.getString("pes_telefone"));
                    c.setCelular(rs.getString("pes_celular"));
                    c.setCpf(rs.getString("cli_cpf"));
                    c.setRg(rs.getString("cli_rg"));
                    c.setDataNasc(rs.getDate("cli_dtNasc"));
                    c.setSexo(rs.getString("cli_sexo"));
                    lista.add(c);
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
