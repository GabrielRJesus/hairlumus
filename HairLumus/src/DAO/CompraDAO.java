package DAO;

import entidade.Compra;
import exception.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CompraDAO implements GenericDAO<Compra>{
    
    private String insert = "insert into compra(com_valor, com_data, for_cnpj, pes_codigo)values(?,?,?,?)";
    private String insertic = "insert into itens_compra(com_codigo, pro_codigo, itc_qtde) values(?,?,?)";

    @Override
    public int insert(Compra obj, Connection con) throws DAOException {
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        int chave = -1;
        int cont = 0;
        if(con!=null){
            try{
                ps = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setDouble(++cont, obj.getValor());
                ps.setDate(++cont, new java.sql.Date(obj.getDataCompra().getTime()));
                ps.setString(++cont, obj.getFornecedor().getCnpj());
                ps.setInt(++cont, obj.getFornecedor().getCodigo());
                ps.executeUpdate();
                rs = ps.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    chave = rs.getInt(1);
                }
                for(int i = 0; i<obj.getListaItens().size(); i++){
                    cont = 0;
                    ps2 = con.prepareStatement(insertic);
                    ps2.setInt(++cont, chave);
                    ps2.setInt(++cont, obj.getListaItens().get(i).getProd().getCodigo());
                    ps2.setInt(++cont, obj.getListaItens().get(i).getQtde());
                    ps.executeUpdate();
                }
                return chave;
            }catch(SQLException ex){
                throw new DAOException(ex.getMessage());
            }
        }else{
            throw new DAOException("Erro na conexão!");
        }
    }

    @Override
    public int update(Compra obj, Connection con) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Compra obj, Connection con) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compra select(Compra obj, Connection con) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
