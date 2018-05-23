package DAO;

import entidade.Produto;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO implements GenericDAO<Produto>{
    
    private String insert = "insert into produto(pro_descricao, pro_preco, pro_estoque, pro_estMin, mar_codigo) values(?,?,?,?,?)";
    private String update = "update produto set pro_descricao = ?, pro_preco = ?, pro_estoque = ?, pro_estMin = ?, mar_codigo = ? where pro_codigo = ?";
    private String delete = "delete from produto where pro_codigo = ?";
    private String select = "select * from produto";

    @Override
    public int insert(Produto obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(insert);
                ps.setString(++cont, obj.getDescricao());
                ps.setDouble(++cont, obj.getPreco());
                ps.setInt(++cont, obj.getEstoque());
                ps.setInt(++cont, obj.getEstMin());
                ps.setInt(++cont, obj.getMarca().getCodigo());
                return ps.executeUpdate();
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão!");
        }
    }

    @Override
    public int update(Produto obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(update);
                ps.setString(++cont, obj.getDescricao());
                ps.setDouble(++cont, obj.getPreco());
                ps.setInt(++cont, obj.getEstoque());
                ps.setInt(++cont, obj.getEstMin());
                ps.setInt(++cont, obj.getMarca().getCodigo());
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
    public int delete(Produto obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(delete);
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
    public Produto select(Produto obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(insert);
                ps.setString(++cont, obj.getDescricao());
                ps.setDouble(++cont, obj.getPreco());
                ps.setInt(++cont, obj.getEstoque());
                ps.setInt(++cont, obj.getEstMin());
                ps.setInt(++cont, obj.getMarca().getCodigo());
                rs = ps.executeQuery();
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão!");
        }
        return null;
    }
    
}
