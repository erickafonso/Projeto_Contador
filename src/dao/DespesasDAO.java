package dao;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.DespesasVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author cralves
 */
public class DespesasDAO {

    public void cadastrarDespesa(DespesasVO dVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();
        Date sqlDate = new java.sql.Date(dVO.getDataPagamento().getTime());
        try {
            String sql = "INSERT INTO despesa VALUES (null, ?, ?, ?, ?, ?, ? )";
            //String sql = "INSERT INTO curso (nome , duracao , valor ) VALUES(?,?,?) ";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, dVO.getNome());
            pstm.setDouble(2, dVO.getValor());

            pstm.setString(3, dVO.getDescricao());
            pstm.setDate(4, sqlDate);
            pstm.setInt(5, dVO.getCategoria());
            pstm.setInt(6, dVO.getFormaPagamento());
            
            pstm.execute();
            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro no Cadastro!" + se);
        } finally {
            con.close();
        }//fim do try catch finally

    }//fim do método cadastrarProduto

    public ArrayList<DespesasVO> buscarDespesa() throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "Select * from despesa";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            ArrayList<DespesasVO> despesasList = new ArrayList<>();

            while (rs.next()) {
                DespesasVO dVO = new DespesasVO();

                dVO.setIdDespesa(rs.getInt("idDespesa"));
                dVO.setNome(rs.getString("nome"));

                dVO.setValor(rs.getDouble("valor"));
                dVO.setDescricao(rs.getString("descricao")); 
                dVO.setDataPagamento(rs.getDate("dataPagamento"));
                               
                dVO.setCategoria(rs.getInt("categoria"));                
                dVO.setFormaPagamento(rs.getInt("formaPagamento"));                
                despesasList.add(dVO);
            }//fim do while
            pstm.close();

            return despesasList;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar Despesa! " + se.getMessage());
        } finally {
            con.close();
        }
    }//fim do método buscarProduto

    public ArrayList<DespesasVO> filtrarDespesa(String query) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "select * from despesa " + query;
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            ArrayList<DespesasVO> despesaList = new ArrayList<>();

            while (rs.next()) {
                DespesasVO dVO = new DespesasVO();

                dVO.setIdDespesa(rs.getInt("idDespesa"));
                dVO.setNome(rs.getString("nome"));
                dVO.setValor(rs.getDouble("valor"));
                dVO.setDataPagamento(rs.getDate("dataPagamento"));
                dVO.setDescricao(rs.getString("descricao"));
                dVO.setCategoria(rs.getInt("categoria"));
                dVO.setFormaPagamento(rs.getInt("formaPagamento"));
                despesaList.add(dVO);
            }//fim do while

            pstm.close();

            return despesaList;

        } catch (SQLException se) {
            throw new SQLException("Erro ao filtrar despesa! " + se.getMessage());
        } finally {
            con.close();
        }//fim da finally        
    }//fim do método filtrarProduto

    public void deletarDespesa(int idDespesa) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "delete from despesa where idDespesa = ?";
            //String sql = "delete from curso where idCurso = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(1, idDespesa);
            //pstm.setInt(1, idCurso);
            pstm.execute();
            pstm.close();
        } catch (SQLException se) {
            throw new SQLException("Erro ao deletar despesa! DespesaDAO " + se.getMessage());
        } finally {
            con.close();
        }//fim da finally
    }//fecha o método detelarProduto

    public void alterarDespesa(DespesasVO dVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();
        Date sqlDate = new java.sql.Date(dVO.getDataPagamento().getTime());
        

        try {
            String sql;
            sql = "Update despesa set "
                    + "nome = '" + dVO.getNome() + "', "
                    + "valor = " + dVO.getValor() + ", "
                    + "descricao = ' " + dVO.getDescricao() + "', "
                    + "dataPagamento = '" + sqlDate + "', "
                    
                    + "categoria = " + dVO.getCategoria() + ", "
                    + "formaPagamento = " + dVO.getFormaPagamento() + " "
                    + " where idDespesa = " + dVO.getIdDespesa() + "; ";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro ao Alterar Despesa! " + se.getMessage());
        } finally {
            con.close();
        }//fim do Try catch finally
    }//fecha o método alterarProduto

}//fecha a classe ProdutoDAO
