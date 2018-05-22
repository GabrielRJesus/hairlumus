package DAO;

import entidade.Marca;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAO implements GenericDAO<Marca>{
    
    private String insert = "insert into marca(mar_descricao) values (?)";
    private String update = "update marca set mar_descricao = ? where mar_codigo = ?";
    private String delete = "delete from marca where mar_codigo = ?";
    private String select = "select * from marca";

    @Override
    public int insert(Marca obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps=con.prepareStatement(insert);
                ps.setString(++cont, obj.getMarca());
                return ps.executeUpdate();
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão!");
        }
    }

    @Override
    public int update(Marca obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps=con.prepareStatement(update);
                ps.setString(++cont, obj.getMarca());
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
    public int delete(Marca obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        int cont = 0;
        if(con!=null){
            try{
                ps=con.prepareStatement(delete);
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
    public Marca select(Marca obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean ultimo = false;
        int cont = 0;
        if(con!=null){
            
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                select+= " where mar_codigo = ?";
                ultimo = true;
            }
            
            if(obj!=null && obj.getMarca()!=null && !obj.getMarca().isEmpty()){
                if(ultimo)
                    select+=" and mar_descricao = ?";
                else
                    select+= " where mar_descricao = ?";
            }
            
            try{
                ps=con.prepareStatement(select);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getMarca()!=null && !obj.getMarca().isEmpty())
                    ps.setString(++cont, obj.getMarca());
                rs = ps.executeQuery();
                
                if(rs.next()){
                    Marca m = new Marca();
                    m.setCodigo(rs.getInt("mar_codigo"));
                    m.setMarca(rs.getString("mar_descricao"));
                    return m;
                }
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão!");
        }
        return null;
    }
    
    public List<Marca> lista(Marca obj, Connection con) throws DAOException {
        List<Marca> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean ultimo = false;
        int cont = 0;
        if(con!=null){
            
            if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0){
                select+= " where mar_codigo = ?";
                ultimo = true;
            }
            
            if(obj!=null && obj.getMarca()!=null && !obj.getMarca().isEmpty()){
                if(ultimo)
                    select+=" and mar_descricao = ?";
                else
                    select+= " where mar_descricao = ?";
            }
            
            try{
                ps=con.prepareStatement(select);
                if(obj!=null && obj.getCodigo()!=null && obj.getCodigo()!=0)
                    ps.setInt(++cont, obj.getCodigo());
                if(obj!=null && obj.getMarca()!=null && !obj.getMarca().isEmpty())
                    ps.setString(++cont, obj.getMarca());
                rs = ps.executeQuery();
                
                while(rs.next()){
                    Marca m = new Marca();
                    m.setCodigo(rs.getInt("mar_codigo"));
                    m.setMarca(rs.getString("mar_descricao"));
                    lista.add(m);
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
