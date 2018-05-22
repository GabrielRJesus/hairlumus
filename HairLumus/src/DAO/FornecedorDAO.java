package DAO;

import entidade.Fornecedor;
import entidade.Pessoa;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO implements GenericDAO<Fornecedor>{
    
    private String insertfo= "insert into fornecedor(for_cnpj, for_ie, for_nomeContato, pes_codigo) values(?,?,?,?)";
    private String updatefo= "update fornecedor set for_ie = ?, for_nomeContato= ? where pes_codigo = ? and for_cnpj = ?";
    private String deletefo= "delete from fornecedor where pes_codigo = ? and for_cnpj = ?";
    private String selectfo= "select * from pessoa p inner join fornecedor f on p.pes_codigo = f.pes_codigo";

    @Override
    public int insert(Fornecedor obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(insertfo);
                ps.setString(++cont, obj.getCnpj());
                ps.setString(++cont, obj.getIe());
                ps.setString(++cont, obj.getNomeResp());
                ps.setInt(++cont, obj.getCodigo());
                return ps.executeUpdate();
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão!");
        }
    }

    @Override
    public int update(Fornecedor obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(updatefo);
                ps.setString(++cont, obj.getIe());
                ps.setString(++cont, obj.getNomeResp());
                ps.setInt(++cont, obj.getCodigo());
                ps.setString(++cont, obj.getCnpj());
                return ps.executeUpdate();
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão!");
        }
    }

    @Override
    public int delete(Fornecedor obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(deletefo);
                ps.setInt(++cont, obj.getCodigo());
                ps.setString(++cont, obj.getCnpj());
                return ps.executeUpdate();
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão!");
        }
    }

    @Override
    public Fornecedor select(Fornecedor obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cont = 0;
        boolean ultimo = false;
        if(con!=null){
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                selectfo+=" where pes_codigo = ?";
                ultimo = true;
            }

            if(obj!=null && obj.getCnpj()!=null && !obj.getCnpj().isEmpty()){
                if(ultimo)
                    selectfo+=" and for_cnpj = ?";
                else{
                    selectfo+=" where for_cnpj = ?";
                    ultimo = true;
                }
            }

            if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty()){
                if(ultimo)
                    selectfo+=" and pes_nome like ?";
                else
                    selectfo+=" where pes_nome like ?";
            }

            try{
                ps = con.prepareStatement(selectfo);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getCnpj()!=null && !obj.getCnpj().isEmpty())
                    ps.setString(++cont, obj.getCnpj());
                if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty())
                    ps.setString(++cont, obj.getNome());
                rs = ps.executeQuery();
                
                if(rs.next()){
                    Fornecedor f = new Fornecedor();
                    f.setCodigo(rs.getInt("pes_codigo"));
                    f.setNome(rs.getString("pes_nome"));
                    f.setEndereco(rs.getString("pes_endereco"));
                    f.setTelefone(rs.getString("pes_telefone"));
                    f.setCelular(rs.getString("pes_celular"));
                    f.setCnpj(rs.getString("for_cnpj"));
                    f.setIe(rs.getString("for_ie"));
                    f.setNomeResp(rs.getString("for_nomeContato"));
                    return f;
                }
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        
        }else{
            throw new DAOException("Erro na conexão!");
        }
        return null;
    }
    
    public List<Fornecedor> lista(Fornecedor obj, Connection con) throws DAOException {
        List<Fornecedor> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cont = 0;
        boolean ultimo = false;
        if(con!=null){
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                selectfo+=" where pes_codigo = ?";
                ultimo = true;
            }

            if(obj!=null && obj.getCnpj()!=null && !obj.getCnpj().isEmpty()){
                if(ultimo)
                    selectfo+=" and for_cnpj = ?";
                else{
                    selectfo+=" where for_cnpj = ?";
                    ultimo = true;
                }
            }

            if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty()){
                if(ultimo)
                    selectfo+=" and pes_nome like ?";
                else
                    selectfo+=" where pes_nome like ?";
            }

            try{
                ps = con.prepareStatement(selectfo);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getCnpj()!=null && !obj.getCnpj().isEmpty())
                    ps.setString(++cont, obj.getCnpj());
                if(obj!=null && obj.getNome()!=null && !obj.getNome().isEmpty())
                    ps.setString(++cont, obj.getNome());
                rs = ps.executeQuery();
                
                while(rs.next()){
                    Fornecedor f = new Fornecedor();
                    f.setCodigo(rs.getInt("pes_codigo"));
                    f.setNome(rs.getString("pes_nome"));
                    f.setEndereco(rs.getString("pes_endereco"));
                    f.setTelefone(rs.getString("pes_telefone"));
                    f.setCelular(rs.getString("pes_celular"));
                    f.setCnpj(rs.getString("for_cnpj"));
                    f.setIe(rs.getString("for_ie"));
                    f.setNomeResp(rs.getString("for_nomeContato"));
                    lista.add(f);
                }
                return lista;
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        
        }else{
            throw new DAOException("Erro na conexão!");
        }
    }
    
}
