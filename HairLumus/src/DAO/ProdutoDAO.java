package DAO;

import entidade.Marca;
import entidade.Produto;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements GenericDAO<Produto>{
    
    private String insert = "insert into produto(pro_descricao, pro_preco, pro_estoque, pro_estMin, mar_codigo) values(?,?,?,?,?)";
    private String update = "update produto set pro_descricao = ?, pro_preco = ?, pro_estoque = ?, pro_estMin = ?, mar_codigo = ? where pro_codigo = ?";
    private String delete = "delete from produto where pro_codigo = ?";
    private String select = "select * from produto p inner join marca m on m.mar_codigo = p.mar_codigo";

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
        boolean ultimo = false;
        if(con!=null){
            
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                select+=" where p.pro_codigo=?";
                ultimo=true;
            }
            
            if(obj!=null && obj.getDescricao()!=null && !obj.getDescricao().isEmpty()){
                if(ultimo)
                    select+=" and p.pro_descricao = ?";
                else{
                    select+=" where p.pro_descricao= ?";
                    ultimo= true;
                }
            }
            
            if(obj!=null && obj.getMarca().getMarca()!=null && !obj.getMarca().getMarca().isEmpty()){
                if(ultimo)
                    select+=" and m.mar_descricao = ?";
                else{
                    select+=" where m.mar_descricao= ?";
                }
            }
            
            try{
                ps = con.prepareStatement(insert);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getDescricao()!=null && !obj.getDescricao().isEmpty())
                    ps.setString(++cont, obj.getDescricao());
                if(obj!=null && obj.getMarca().getMarca()!=null && !obj.getMarca().getMarca().isEmpty())
                    ps.setString(++cont, obj.getMarca().getMarca());
                rs = ps.executeQuery();
                
                if(rs.next()){
                    Produto p = new Produto();
                    Marca m = new Marca();
                    p.setCodigo(rs.getInt("p.pro_codigo"));
                    p.setDescricao(rs.getString("p.pro_descricao"));
                    p.setPreco(rs.getDouble("p.pro_preco"));
                    p.setEstoque(rs.getInt("p.pro_estoque"));
                    p.setEstMin(rs.getInt("p.pro_estMin"));
                    m.setCodigo(rs.getInt("m.mar_codigo"));
                    m.setMarca(rs.getString("m.mar_descricao"));
                    p.setMarca(m);
                    return p;
                }
                
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão!");
        }
        return null;
    }
    
    public List<Produto> lista(Produto obj, Connection con) throws DAOException {
        List<Produto> lista= new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cont = 0;
        boolean ultimo = false;
        if(con!=null){
            
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                select+=" where p.pro_codigo=?";
                ultimo=true;
            }
            
            if(obj!=null && obj.getDescricao()!=null && !obj.getDescricao().isEmpty()){
                if(ultimo)
                    select+=" and p.pro_descricao = ?";
                else{
                    select+=" where p.pro_descricao= ?";
                    ultimo= true;
                }
            }
            
            if(obj!=null && obj.getMarca().getMarca()!=null && !obj.getMarca().getMarca().isEmpty()){
                if(ultimo)
                    select+=" and m.mar_descricao = ?";
                else{
                    select+=" where m.mar_descricao= ?";
                }
            }
            
            try{
                ps = con.prepareStatement(insert);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getDescricao()!=null && !obj.getDescricao().isEmpty())
                    ps.setString(++cont, obj.getDescricao());
                if(obj!=null && obj.getMarca().getMarca()!=null && !obj.getMarca().getMarca().isEmpty())
                    ps.setString(++cont, obj.getMarca().getMarca());
                rs = ps.executeQuery();
                
                while(rs.next()){
                    Produto p = new Produto();
                    Marca m = new Marca();
                    p.setCodigo(rs.getInt("p.pro_codigo"));
                    p.setDescricao(rs.getString("p.pro_descricao"));
                    p.setPreco(rs.getDouble("p.pro_preco"));
                    p.setEstoque(rs.getInt("p.pro_estoque"));
                    p.setEstMin(rs.getInt("p.pro_estMin"));
                    m.setCodigo(rs.getInt("m.mar_codigo"));
                    m.setMarca(rs.getString("m.mar_descricao"));
                    p.setMarca(m);
                    lista.add(p);
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
