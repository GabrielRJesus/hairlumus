package DAO;

import entidade.Pessoa;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements GenericDAO<Pessoa>{
    //insert
    private String insertp = "insert into pessoa(pes_nome, pes_endereco,pes_telefone,pes_celular) values(?,?,?,?)";
    //update
    private String updatep = "update pessoa set pes_nome = ?, pes_endereco =?, pes_telefone = ?, pes_celular = ? where pes_codigo = ?";
    //delete
    private String deletep = "delete from pessoa where pes_codigo = ?";
    //select
    private String selectp = "select * from pessoa";

    @Override
    public int insert(Pessoa obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cont = 0;
        int chave = -1;
        if(con!=null){
            try{
                ps = con.prepareStatement(insertp, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(++cont, obj.getNome());
                ps.setString(++cont, obj.getEndereco());
                ps.setString(++cont, obj.getTelefone());
                ps.setString(++cont, obj.getCelular());
                ps.executeUpdate();
                rs = ps.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    chave = rs.getInt(1);
                }
                return chave;
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão");
        }
    }

    @Override
    public int update(Pessoa obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(updatep);
                ps.setString(++cont, obj.getNome());
                ps.setString(++cont, obj.getEndereco());
                ps.setString(++cont, obj.getTelefone());
                ps.setString(++cont, obj.getCelular());
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
    public int delete(Pessoa obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(deletep);
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
    public Pessoa select(Pessoa obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cont = 0;
        boolean ultimo = false;
        if(con!=null){
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                selectp+=" where pes_codigo = ?";
                ultimo = true;
            }

            if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty()){
                if(ultimo){
                    selectp+=" and pes_nome like ?";
                }else{
                    selectp+=" where pes_nome like ?";
                    ultimo = true;
                }
            }

            if(obj!=null && obj.getEndereco()!=null && !obj.getEndereco().isEmpty()){
                if(ultimo){
                    selectp+=" and pes_endereco like ?";
                }else{
                    selectp+=" where pes_endereco like ?";
                    ultimo = true;
                }
            }

            if(obj!=null && obj.getTelefone()!=null && !obj.getTelefone().isEmpty()){
                if(ultimo){
                    selectp+=" and pes_telefone = ?";
                }else{
                    selectp+=" where pes_telefone = ?";
                    ultimo = true;
                }
            }

            if(obj!=null && obj.getCelular()!=null && !obj.getCelular().isEmpty()){
                if(ultimo){
                    selectp+=" and pes_celular = ?";
                }else{
                    selectp+=" where pes_celular = ?";
                }
            }
            try{
                ps = con.prepareStatement(selectp);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty())
                    ps.setString(++cont, obj.getNome());
                if(obj!=null && obj.getEndereco()!=null && !obj.getEndereco().isEmpty())
                    ps.setString(++cont, obj.getEndereco());
                if(obj!=null && obj.getTelefone()!=null && !obj.getTelefone().isEmpty())
                    ps.setString(++cont, obj.getTelefone());
                if(obj!=null && obj.getCelular()!=null && !obj.getCelular().isEmpty())
                    ps.setString(++cont, obj.getCelular());
                rs = ps.executeQuery();
                if(rs.next()){
                    Pessoa p = new Pessoa();
                    p.setCodigo(rs.getInt("pes_codigo"));
                    p.setNome(rs.getString("pes_nome"));
                    p.setEndereco(rs.getString("pes_endereco"));
                    p.setTelefone(rs.getString("pes_telefone"));
                    p.setCelular(rs.getString("pes_celular"));
                    return p;
                }
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão");
        }
        return null;
    }
    
    public List<Pessoa> listaPessoa(Pessoa obj, Connection con)throws DAOException{
        List<Pessoa> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cont = 0;
        boolean ultimo = false;
        if(con!=null){
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                selectp+=" where pes_codigo = ?";
                ultimo = true;
            }

            if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty()){
                if(ultimo){
                    selectp+=" and pes_nome like ?";
                }else{
                    selectp+=" where pes_nome like ?";
                    ultimo = true;
                }
            }

            if(obj!=null && obj.getEndereco()!=null && !obj.getEndereco().isEmpty()){
                if(ultimo){
                    selectp+=" and pes_endereco like ?";
                }else{
                    selectp+=" where pes_endereco like ?";
                    ultimo = true;
                }
            }

            if(obj!=null && obj.getTelefone()!=null && !obj.getTelefone().isEmpty()){
                if(ultimo){
                    selectp+=" and pes_telefone = ?";
                }else{
                    selectp+=" where pes_telefone = ?";
                    ultimo = true;
                }
            }

            if(obj!=null && obj.getCelular()!=null && !obj.getCelular().isEmpty()){
                if(ultimo){
                    selectp+=" and pes_celular = ?";
                }else{
                    selectp+=" where pes_celular = ?";
                }
            }
            try{
                ps = con.prepareStatement(selectp);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty())
                    ps.setString(++cont, obj.getNome());
                if(obj!=null && obj.getEndereco()!=null && !obj.getEndereco().isEmpty())
                    ps.setString(++cont, obj.getEndereco());
                if(obj!=null && obj.getTelefone()!=null && !obj.getTelefone().isEmpty())
                    ps.setString(++cont, obj.getTelefone());
                if(obj!=null && obj.getCelular()!=null && !obj.getCelular().isEmpty())
                    ps.setString(++cont, obj.getCelular());
                rs = ps.executeQuery();
                while(rs.next()){
                    Pessoa p = new Pessoa();
                    p.setCodigo(rs.getInt("pes_codigo"));
                    p.setNome(rs.getString("pes_nome"));
                    p.setEndereco(rs.getString("pes_endereco"));
                    p.setTelefone(rs.getString("pes_telefone"));
                    p.setCelular(rs.getString("pes_celular"));
                    lista.add(p);
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
