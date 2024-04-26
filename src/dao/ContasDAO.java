package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ContasVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author cralves
 */
public class ContasDAO {

    public void cadastrarConta(ContasVO cVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();
        Date sqlDate = new java.sql.Date(cVO.getDataPagamento().getTime());
        Date sqlDate2 = new java.sql.Date(cVO.getDataVencimento().getTime());
        try {
            String sql = "INSERT INTO conta VALUES (null, ?, ?, ?, ?, ?, ?, ? )";
            //String sql = "INSERT INTO curso (nome , duracao , valor ) VALUES(?,?,?) ";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cVO.getNome());
            pstm.setDouble(2, cVO.getValor());
            pstm.setString(3, cVO.getDescricao());
            pstm.setDate(4, sqlDate);
            pstm.setDate(5, sqlDate2);
            pstm.setInt(6, cVO.getCategoria());
            pstm.setInt(7, cVO.getFormaPagamento());
            

            pstm.execute();
            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro no Cadastro!" + se);
        } finally {
            con.close();
        }//fim do try catch finally

    }//fim do método cadastrarProduto

    public ArrayList<ContasVO> buscarConta() throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "Select * from conta";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            ArrayList<ContasVO> contasList = new ArrayList<>();

            while (rs.next()) {
                ContasVO cVO = new ContasVO();

                cVO.setIdConta(rs.getInt("idConta"));
                cVO.setNome(rs.getString("nome"));

                cVO.setValor(rs.getDouble("valor"));
                cVO.setDescricao(rs.getString("descricao"));  
                cVO.setDataPagamento(rs.getDate("dataPagamento"));
                cVO.setDataVencimento(rs.getDate("dataVencimento"));
                cVO.setCategoria(rs.getInt("categoria"));
                cVO.setFormaPagamento(rs.getInt("formaPagamento"));
                              
                contasList.add(cVO);
            }//fim do while
            pstm.close();

            return contasList;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar conta! " + se.getMessage());
        } finally {
            con.close();
        }
    }//fim do método buscarProduto

    public ArrayList<ContasVO> filtrarConta(String query) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "select * from conta" + query;
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            ArrayList<ContasVO> contasList = new ArrayList<>();

            while (rs.next()) {
                ContasVO cVO = new ContasVO();

                cVO.setIdConta(rs.getInt("idConta"));
                cVO.setNome(rs.getString("nome"));
                cVO.setValor(rs.getDouble("valor"));
                cVO.setDescricao(rs.getString("descricao"));
                cVO.setDataPagamento(rs.getDate("dataPagamento"));
                cVO.setDataPagamento(rs.getDate("dataVencimento"));
                cVO.setCategoria(rs.getInt("categoria"));
                cVO.setFormaPagamento(rs.getInt("formaPagamento"));  
                contasList.add(cVO);
            }//fim do while

            pstm.close();

            return contasList;

        } catch (SQLException se) {
            throw new SQLException("Erro ao filtrar conta! " + se.getMessage());
        } finally {
            con.close();
        }//fim da finally        
    }//fim do método filtrarProduto

    public void deletarConta(int idConta) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql = "delete from conta where idConta = ?";
            //String sql = "delete from curso where idCurso = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(0, idConta);
            //pstm.setInt(1, idCurso);
            pstm.execute();
            pstm.close();
        } catch (SQLException se) {
            throw new SQLException("Erro ao deletar curso! ContaDAO " + se.getMessage());
        } finally {
            con.close();
        }//fim da finally
    }//fecha o método detelarProduto

    public void alterarConta(ContasVO cVO) throws SQLException {
        Connection con = new ConexaoBanco().getConexao();

        try {
            String sql;
            sql = "Update conta set "
                    + "nome = ' " + cVO.getNome() + " ', "
                    + "valor = " + cVO.getValor() + ", "
                    + "descricao = " + cVO.getDescricao() + ", "
                    + "dataPagamento = " + cVO.getDataPagamento() + ", "
                    + "dataVencimento = " + cVO.getDataVencimento() + ", "
                    + "categoria = " + cVO.getCategoria() + ", "
                    + "formaPagamento = " + cVO.getFormaPagamento() + ", "
                    + " where idConta= " + cVO.getIdConta() + " ";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro ao Alterar Conta! " + se.getMessage());
        } finally {
            con.close();
        }//fim do Try catch finally
    }//fecha o método alterarProduto

}//fecha a classe ProdutoDAO
